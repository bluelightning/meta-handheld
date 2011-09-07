DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel siteinfo

# Enable OABI compat for people stuck with obsolete userspace
ARM_KEEP_OABI ?= "1"

# Set the verbosity of kernel messages during runtime
# You can define CMDLINE_DEBUG in your local.conf or distro.conf to override this behaviour
CMDLINE_DEBUG ?= '${@base_contains("IMAGE_FEATURES", "debug-tweaks", "debug", "loglevel=3", d)}'

# Kernel bootlogo is distro-specific (default is OE logo).
# Logo resolution (qvga, vga, ...) is machine-specific.
LOGO_SIZE ?= "."
# To use this, add file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 or similar
# to your kernel recipe, and then structure your logos for each resolution
# accordingly.

LOCALVERSION ?= ""

do_configure_prepend() {
        echo "" > ${S}/.config

        #
        # logo support, if you supply logo_linux_clut224.ppm in SRC_URI, then it's going to be used
        #
        if [ -e ${WORKDIR}/logo_linux_clut224.ppm ]; then
                install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm drivers/video/logo/logo_linux_clut224.ppm
                echo "CONFIG_LOGO=y"                    >> ${S}/.config
                echo "CONFIG_LOGO_LINUX_CLUT224=y"      >> ${S}/.config
        fi

        #
        # oabi / eabi support
        #
	echo "CONFIG_AEABI=y"                   >> ${S}/.config
	if [ "${ARM_KEEP_OABI}" = "1" ] ; then
		echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
	else
		echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
	fi

        # When enabling thumb for userspace we also need thumb support in the kernel
        if [ "${ARM_INSTRUCTION_SET}" = "thumb" ] ; then
            sed -i -e /CONFIG_ARM_THUMB/d ${WORKDIR}/defconfig 
            echo "CONFIG_ARM_THUMB=y" >> ${S}/.config
        fi

        echo "CONFIG_CMDLINE=\"${CMDLINE} ${CMDLINE_DEBUG}\"" >> ${S}/.config

        sed -e '/CONFIG_AEABI/d' \
            -e '/CONFIG_OABI_COMPAT=/d' \
            -e '/CONFIG_CMDLINE=/d' \
            -e '/CONFIG_CPU_BIG_ENDIAN/d' \
            -e '/CONFIG_LOGO=/d' \
            -e '/CONFIG_LOGO_LINUX_CLUT224=/d' \
            -e '/CONFIG_LOCALVERSION/d' \
            -e '/CONFIG_LOCALVERSION_AUTO/d' \
	    < '${WORKDIR}/defconfig' >>'${S}/.config'

        echo 'CONFIG_LOCALVERSION="${LOCALVERSION}"' >>${S}/.config
        echo '# CONFIG_LOCALVERSION_AUTO is not set' >>${S}/.config

        # Newer versions of udev mandate that sysfs doesn't have deprecated entries
        sed -e /CONFIG_SYSFS_DEPRECATED/d \
                -e /CONFIG_SYSFS_DEPRECATED_V2/d \
                -e /CONFIG_HOTPLUG/d \
                -e /CONFIG_UEVENT_HELPER_PATH/d \
                -e /CONFIG_UNIX/d \
                -e /CONFIG_SYSFS/d \
                -e /CONFIG_PROC_FS/d \
                -e /CONFIG_TMPFS/d \
                -e /CONFIG_INOTIFY_USER/d \
                -e /CONFIG_SIGNALFD/d \
                -e /CONFIG_TMPFS_POSIX_ACL/d \
                -e /CONFIG_BLK_DEV_BSG/d \
                -i '${S}/.config'

        echo '# CONFIG_SYSFS_DEPRECATED is not set' >> ${S}/.config
        echo '# CONFIG_SYSFS_DEPRECATED_V2 is not set' >> ${S}/.config
        echo 'CONFIG_HOTPLUG=y' >> ${S}/.config
        echo 'CONFIG_UEVENT_HELPER_PATH=""' >> ${S}/.config
        echo 'CONFIG_UNIX=y' >> ${S}/.config
        echo 'CONFIG_SYSFS=y' >> ${S}/.config
        echo 'CONFIG_PROC_FS=y' >> ${S}/.config
        echo 'CONFIG_TMPFS=y' >> ${S}/.config
        echo 'CONFIG_INOTIFY_USER=y' >> ${S}/.config
        echo 'CONFIG_SIGNALFD=y' >> ${S}/.config
        echo 'CONFIG_TMPFS_POSIX_ACL=y' >> ${S}/.config
        echo 'CONFIG_BLK_DEV_BSG=y' >> ${S}/.config
        echo 'CONFIG_DEVTMPFS=y' >> ${S}/.config
        echo 'CONFIG_DEVTMPFS_MOUNT=y' >> ${S}/.config

        # Newer inits like systemd need cgroup support
        if [ "${KERNEL_ENABLE_CGROUPS}" = "1" ] ; then
            sed -e /CONFIG_CGROUP_SCHED/d \
                -e /CONFIG_CGROUPS/d \
                -i '${S}/.config'
            
            echo 'CONFIG_CGROUP_SCHED=y' >> ${S}/.config
            echo 'CONFIG_CGROUPS=y' >> ${S}/.config
            echo 'CONFIG_CGROUP_NS=y' >> ${S}/.config
            echo 'CONFIG_CGROUP_FREEZER=y' >> ${S}/.config
            echo 'CONFIG_CGROUP_DEVICE=y' >> ${S}/.config
            echo 'CONFIG_CPUSETS=y' >> ${S}/.config
            echo 'CONFIG_PROC_PID_CPUSET=y' >> ${S}/.config
            echo 'CONFIG_CGROUP_CPUACCT=y' >> ${S}/.config
            echo 'CONFIG_RESOURCE_COUNTERS=y' >> ${S}/.config
        fi

        #
        # root-over-nfs-over-usb-eth support. Limited, but should cover some cases.
        # Enable this by setting a proper CMDLINE_NFSROOT_USB.
        #
        if [ ! -z "${CMDLINE_NFSROOT_USB}" ]; then
                bbnote "Configuring the kernel for root-over-nfs-over-usb-eth with CMDLINE ${CMDLINE_NFSROOT_USB}"
                sed -e '/CONFIG_INET/d' \
                    -e '/CONFIG_IP_PNP=/d' \
                    -e '/CONFIG_USB_GADGET=/d' \
                    -e '/CONFIG_USB_GADGET_SELECTED=/d' \
                    -e '/CONFIG_USB_ETH=/d' \
                    -e '/CONFIG_NFS_FS=/d' \
                    -e '/CONFIG_ROOT_NFS=/d' \
                    -e '/CONFIG_CMDLINE=/d' \
                    -i ${S}/.config
                echo "CONFIG_INET=y"                     >> ${S}/.config
                echo "CONFIG_IP_PNP=y"                   >> ${S}/.config
                echo "CONFIG_USB_GADGET=y"               >> ${S}/.config
                echo "CONFIG_USB_GADGET_SELECTED=y"      >> ${S}/.config
                echo "CONFIG_USB_ETH=y"                  >> ${S}/.config
                echo "CONFIG_NFS_FS=y"                   >> ${S}/.config
                echo "CONFIG_ROOT_NFS=y"                 >> ${S}/.config
                echo "CONFIG_CMDLINE=\"${CMDLINE_NFSROOT_USB} ${CMDLINE_DEBUG}\"" >> ${S}/.config
        fi
		yes '' | oe_runmake oldconfig
}

do_configure_append() {
        if test -e scripts/Makefile.fwinst ; then
		sed -i -e "s:-m0644:-m 0644:g" scripts/Makefile.fwinst
	fi
}

do_install_append() {
	oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix}/src/linux-${KERNEL_VERSION} ARCH=$ARCH
}

PACKAGES =+ "kernel-headers"
FILES_kernel-headers = "${exec_prefix}/src/linux*"
