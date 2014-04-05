FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.14:${THISDIR}/${PN}:"

COMPATIBLE_MACHINE .= "|akita|c7x0|collie|h3600|hx4700|poodle|spitz|tosa"

KMACHINE_${MACHINE} = "${MACHINE}"
KERNEL_EXTRA_FEATURES_${MACHINE} ?= ""

OELOGO_PATCH = '${@base_contains("MACHINE_FEATURES", "qvga", "OE-qvga-logo.patch", "OE-vga-logo.patch", d)}'
SRC_URI += "file://${OELOGO_PATCH}"

# Note: Providing "defconfig" we bypass the linux-yocto processing
SRC_URI += "file://defconfig"

SRC_URI_append_c7x0 = " \
           file://corgi-gpio_keys.patch \
           "

SRC_URI_append_collie = " \
           file://locomo_kbd_tweak-r2.patch \
           \
           file://collie-irda.patch \
           \
           file://collie-cfi-probe-again.patch \
           file://collie-mtd-resize.patch \
           file://collie-match-cfi-qry.patch \
           file://collie-LH28F640BF.patch \
           file://collie-add-bootblock.patch \
           \
           file://revert-arm-sa1100-dummy-clk_get_rate.patch \
           file://arm-sa1100-dummy-clk_set_rate.patch \
           file://arm-sa1100-add-cpu-clock.patch \
           file://fbdev-sa1100fb-make-use-of-device-clock.patch \
           file://pcmcia-sa1100-device-clock.patch \
           \
           file://locomo-fix-SCL-SDA.patch \
           file://locomolcd-suspend-resume.patch \
           \
           file://collie-use-gpio-charger.patch \
           \
           "

SRC_URI_append_h3600 = " \
           file://0001-MFD-driver-for-Atmel-Microcontroller-on-iPaq-h3xxx.patch \
           file://0002-ARM-sa1100-add-Micro-ASIC-platform-device.patch \
           file://0003-input-driver-for-microcontroller-keys-on-the-iPaq-h3.patch \
           file://0004-fb-backlight-add-driver-for-iPAQ-micro-backlight.patch \
           file://0005-input-driver-for-touchscreen-on-iPaq-h3xxx.patch \
           file://0006-leds-add-driver-for-the-iPAQ-micro.patch \
           file://0007-power-add-driver-for-battery-reading-on-iPaq-h3xxx.patch \
           "

SRC_URI_append_hx4700 = " \
           file://hx4700-change-led-trigger-assignments.patch \
           file://hx4700.h-include-irqs.h-for-PXA_NR_BUILTIN_G.patch \
           "

SRC_URI_append_poodle = " \
           file://locomo_kbd_tweak-r2.patch \
           file://locomo-fix-SCL-SDA.patch \
           file://locomolcd-suspend-resume.patch \
           "

SRC_URI_append_tosa = " \
           file://0001-HACK-video-move-backlight-to-the-end-of-Makefile.patch \
           file://0002-tosa-bl-correct-backlight-calculations.patch \
           file://0003-tmio-call-tmiofb_set_par-in-tmiofb_probe.patch \
           file://0004-ARM-pxa-tosa-switch-to-gpio-charger.patch \
           file://0005-ARM-pxa-tosa-fix-several-build-failures.patch \
           file://0006-mfd-tc6393xb-fail-ohci-suspend-if-full-state-restore.patch \
           file://0007-wm97xx-adapt-parameters-to-tosa-touchscreen.patch \
           "
