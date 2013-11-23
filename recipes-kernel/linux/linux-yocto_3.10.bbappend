FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.10:${THISDIR}/${PN}:${THISDIR}/files:"

COMPATIBLE_MACHINE .= "|akita|c7x0|collie|h3600|hx4700|poodle|spitz|tosa"

# Override kernel features
#KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc"

KERNEL_EXTRA_FEATURES_akita ?= ""
KERNEL_EXTRA_FEATURES_c7x0 ?= ""
KERNEL_EXTRA_FEATURES_collie ?= ""
KERNEL_EXTRA_FEATURES_h3600 ?= ""
KERNEL_EXTRA_FEATURES_hx4700 ?= ""
KERNEL_EXTRA_FEATURES_poodle ?= ""
KERNEL_EXTRA_FEATURES_spitz ?= ""
KERNEL_EXTRA_FEATURES_tosa ?= ""

KMACHINE_akita = "akita"
KMACHINE_c7x0 = "c7x0"
KMACHINE_collie = "collie"
KMACHINE_h3600 = "h3600"
KMACHINE_hx4700 = "hx4700"
KMACHINE_poodle = "poodle"
KMACHINE_spitz = "spitz"
KMACHINE_tosa = "tosa"

SRC_URI_append_akita = " \
           file://feature-top.scc \
           file://vga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_c7x0 = " \
           file://feature-top.scc \
           file://vga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_collie = " \
           file://feature-top.scc \
           file://qvga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_h3600 = " \
           file://defconfig \
           file://0001-MFD-driver-for-Atmel-Microcontroller-on-iPaq-h3xxx.patch \
           file://0002-ARM-sa1100-add-Micro-ASIC-platform-device.patch \
           file://0003-input-driver-for-microcontroller-keys-on-the-iPaq-h3.patch \
           file://0004-input-driver-for-touchscreen-on-iPaq-h3xxx.patch \
           file://0005-power-add-driver-for-battery-reading-on-iPaq-h3xxx.patch \
           file://0006-leds-add-driver-for-the-iPAQ-micro.patch \
           file://0007-fb-backlight-add-driver-for-iPAQ-micro-backlight.patch \
           file://qvga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_hx4700 = " \
           file://defconfig \
           file://hx4700-change-led-trigger-assignments.patch \
           file://vga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_poodle = " \
           file://feature-top.scc \
           file://qvga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_spitz = " \
           file://feature-top.scc \
           file://vga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_tosa = " \
           file://feature-top.scc \
           file://vga/logo_linux_clut224.ppm.bz2 \
           "

do_configure_prepend() {

    if [ -e ${WORKDIR}/logo_linux_clut224.ppm ]; then
        install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm ${WORKDIR}/linux/drivers/video/logo/logo_linux_clut224.ppm
    fi
}
