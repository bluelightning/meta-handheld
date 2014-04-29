FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-dev:${THISDIR}/${PN}:${THISDIR}/files:"

COMPATIBLE_MACHINE .= "|h1940"

# Override kernel features
#KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc"

KERNEL_EXTRA_FEATURES_h1940 ?= ""
KMACHINE_h1940 = "h1940"

# Note: Providing "defconfig" we bypass the linux-yocto processing
# re-expand the defconfig produced by "make_savedefconfig"
KCONFIG_MODE_h1940 = "--alldefconfig"

SRC_URI_append_h1940 = " \
           file://defconfig \
           file://0001-s3c24xx-DMA-don-t-use-autoreload-feature.patch \
           file://0002-s3cmci-minor-fixups.patch \
           file://0003-ARM-s3c2410-drop-RFKILL-driver-for-H1940-bluetooth.patch \
           file://0008-ARM-h1940-add-bluetooth-RF-kill-switch.patch \
           file://0004-mtd-nand-s3c2410-add-iPAQ-specific-layout.patch \
           file://0005-ARM-s3c2410-Add-nand-device-for-h1940.patch \
           file://0006-ARM-s3c2410-h1940-don-t-touch-UPLLCON.patch \
           file://0009-rfkill-add-IR-type.patch \
           file://0007-ARM-s3c2410-unlock-reset-button-on-H1940.patch \
           file://0010-rfkill_gpio-add-support-for-inverted-GPIOs.patch \
           file://0011-ARM-h1940-add-IR-switch.patch \
           file://0012-ARM-h1940-increase-oversampling-shift.patch \
           file://qvga/logo_linux_clut224.ppm.bz2 \
           "

do_configure_prepend() {

    if [ -e ${WORKDIR}/logo_linux_clut224.ppm ]; then
        install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm ${WORKDIR}/linux/drivers/video/logo/logo_linux_clut224.ppm
    fi
}
