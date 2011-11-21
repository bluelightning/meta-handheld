DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

INC_PR = "r0"

inherit kernel siteinfo

# FILESEXTRAPATHS cannot be used, because it puts extra paths before FILESPATH and we need it at the end
# only as fallback for patches available only in linux-PV dir and ie defconfigs needs to go from linux-kexecboot-PV
FILESPATH_append = ":${FILE_DIRNAME}/linux-${PV}"

DEPENDS += "xz-native"

# Kernel bootlogo is distro-specific (default is OE logo).
# Logo resolution (qvga, vga, ...) is machine-specific.
LOGO_SIZE ?= "."
# To use this, add file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 or similar
# to your kernel recipe, and then structure your logos for each resolution
# accordingly.

# Set the verbosity of kernel messages during runtime
# You can define CMDLINE_DEBUG in your local.conf or distro.conf to override this behaviour
CMDLINE_DEBUG ?= '${@base_contains("IMAGE_FEATURES", "debug-tweaks", "debug", "loglevel=3", d)}'

# Note how we set loglevel=3 and master console on serial to protect bootlogo.
CMDLINE_c7x0 = "console=tty1 console=ttyS0,115200n8"
CMDLINE_tosa = "console=tty1 console=ttyS0,115200n8"
CMDLINE_poodle = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1"
CMDLINE_akita = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1"
CMDLINE_collie = "console=tty1 console=ttySA0,115200n8 fbcon=rotate:1 mem=64M"
CMDLINE_spitz = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1"

PACKAGES = ""
PROVIDES = ""

# Zaurus machines need kernel size-check
KERNEL_IMAGE_MAXSIZE_akita = "1294336"
KERNEL_IMAGE_MAXSIZE_c7x0 = "1294336"
KERNEL_IMAGE_MAXSIZE_collie = "1048576"
KERNEL_IMAGE_MAXSIZE_poodle = "1294336"
KERNEL_IMAGE_MAXSIZE_tosa = "1294336"
KERNEL_IMAGE_MAXSIZE_spitz = "1294336"

KERNEL_IMAGE_BASE_NAME = "${KERNEL_IMAGETYPE}-kexecboot-${PV}-${PR}-${MACHINE}"
KERNEL_IMAGE_SYMLINK_NAME = "${KERNEL_IMAGETYPE}-kexecboot-${MACHINE}"

LOCALVERSION ?= ""

# we want the smallest size
INITRAMFS_IMAGE = "initramfs-kexecboot-klibc-image"

kernel_conf_variable() {
        CONF_SED_SCRIPT="$CONF_SED_SCRIPT /CONFIG_$1[ =]/d;"
        if test "$2" = "n"
        then
                echo "# CONFIG_$1 is not set" >> ${S}/.config
        else
                echo "CONFIG_$1=$2" >> ${S}/.config
        fi
}

do_configure_prepend() {

        echo "" > ${S}/.config
        CONF_SED_SCRIPT=""

        #
        # CONFIG_CMDLINE mangling
        #
        kernel_conf_variable CMDLINE_BOOL y
        kernel_conf_variable CMDLINE "\"${CMDLINE} ${CMDLINE_DEBUG}\""

        # mips and x86
        kernel_conf_variable CMDLINE_OVERRIDE y

        # sh only
        kernel_conf_variable CMDLINE_OVERWRITE y
        kernel_conf_variable CMDLINE_EXTEND n

        #
        # endian support
        #
        if [ "${SITEINFO_ENDIANNESS}" = "be" ]; then
                kernel_conf_variable CPU_BIG_ENDIAN y
        fi

        #
        # logo support, if you supply logo_linux_clut224.ppm in SRC_URI, then it is going to be used
        #
        if [ -e ${WORKDIR}/logo_linux_clut224.ppm ]; then
                install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm drivers/video/logo/logo_linux_clut224.ppm
                kernel_conf_variable LOGO y
                kernel_conf_variable LOGO_LINUX_CLUT224 y
        fi

        # When enabling thumb for userspace we also need thumb support in the kernel
        if [ "${ARM_INSTRUCTION_SET}" = "thumb" ] ; then
                kernel_conf_variable ARM_THUMB y
        fi

        kernel_conf_variable LOCALVERSION "\"${LOCALVERSION}\""
        kernel_conf_variable LOCALVERSION_AUTO n

        # Force sane defaults for kexec-enabled kernels and keep size small
        kernel_conf_variable BLK_DEV_INITRD y
        kernel_conf_variable KEXEC y
        CONF_SED_SCRIPT="$CONF_SED_SCRIPT /=m/d;"
        kernel_conf_variable MODULES n
        if ${@base_contains("CMDLINE_DEBUG", "debug", "true", "false", d)}; then
                kernel_conf_variable DEBUG_LL y
                kernel_conf_variable PRINTK y
                kernel_conf_variable EARLY_PRINTK y
                kernel_conf_variable BUG y
                kernel_conf_variable DEBUG_ERRORS y
                kernel_conf_variable DEBUG_BUGVERBOSE y
                kernel_conf_variable DEBUG_KERNEL y
        else
                kernel_conf_variable DEBUG_ERRORS n
                kernel_conf_variable DEBUG_BUGVERBOSE n
                kernel_conf_variable DEBUG_KERNEL n
        fi

        # Force lzma for arm kernels only
        if [ "${ARCH}" = "arm" ] ; then
                CONF_SED_SCRIPT="$CONF_SED_SCRIPT /CONFIG_KERNEL/d;"
                CONF_SED_SCRIPT="$CONF_SED_SCRIPT /CONFIG_RD/d;"
                CONF_SED_SCRIPT="$CONF_SED_SCRIPT /CONFIG_INITRAMFS_COMPRESSION/d;"
                CONF_SED_SCRIPT="$CONF_SED_SCRIPT /CONFIG_INITRAMFS_SOURCE/d;"
                kernel_conf_variable KERNEL_LZMA y
                kernel_conf_variable RD_LZMA y
                kernel_conf_variable INITRAMFS_COMPRESSION_LZMA y
                kernel_conf_variable INITRAMFS_SOURCE "\"initramfs.cpio.lzma\""
        fi

        sed -e "${CONF_SED_SCRIPT}" \
                        < '${WORKDIR}/defconfig' >>'${S}/.config'

        yes '' | oe_runmake oldconfig
}

do_populate_sysroot() {
        :
}

do_install() {
        :
}

