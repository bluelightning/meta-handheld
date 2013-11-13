KMACHINE_akita = "akita"
KMACHINE_c7x0 = "c7x0"
KMACHINE_collie = "collie"
KMACHINE_h1940 = "h1940"
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
