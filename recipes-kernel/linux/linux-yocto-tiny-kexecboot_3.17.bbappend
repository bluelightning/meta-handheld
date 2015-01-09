FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.17:${THISDIR}/linux-yocto-3.17:${THISDIR}/files:"

COMPATIBLE_MACHINE .= "|akita|c7x0|collie|poodle|spitz|tosa"

# Zaurus machines need kernel size-check.
KERNEL_IMAGE_MAXSIZE_akita = "1264"
KERNEL_IMAGE_MAXSIZE_c7x0 = "1264"
KERNEL_IMAGE_MAXSIZE_collie = "1024"
KERNEL_IMAGE_MAXSIZE_poodle = "1264"
KERNEL_IMAGE_MAXSIZE_spitz = "1264"
KERNEL_IMAGE_MAXSIZE_tosa = "1264"

KMACHINE_akita = "akita"
KMACHINE_c7x0 = "c7x0"
KMACHINE_collie = "collie"
KMACHINE_poodle = "poodle"
KMACHINE_spitz = "spitz"
KMACHINE_tosa = "tosa"

# Note: Providing "defconfig" we bypass the linux-yocto processing
# re-expand the defconfig produced by "make_savedefconfig"
KCONFIG_MODE_akita = "--alldefconfig"
KCONFIG_MODE_c7x0 = "--alldefconfig"
KCONFIG_MODE_collie = "--alldefconfig"
KCONFIG_MODE_poodle = "--alldefconfig"
KCONFIG_MODE_spitz = "--alldefconfig"
KCONFIG_MODE_tosa = "--alldefconfig"

SRC_URI_append_akita = " \
           file://defconfig \
           file://revert-check-on-console-device.patch \
           file://OE-vga-logo.patch \
           "

SRC_URI_append_c7x0 = " \
           file://defconfig \
           file://revert-check-on-console-device.patch \
           file://OE-vga-logo.patch \
           "

SRC_URI_append_collie = " \
           file://defconfig \
           file://revert-check-on-console-device.patch \
           file://OE-qvga-logo.patch \
           file://locomo_kbd_tweak-r2.patch \
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

SRC_URI_append_poodle = " \
           file://defconfig \
           file://revert-check-on-console-device.patch \
           file://OE-qvga-logo.patch \
           file://locomo_kbd_tweak-r2.patch \
           file://locomo-fix-SCL-SDA.patch \
           file://locomolcd-suspend-resume.patch \
           "

SRC_URI_append_spitz = " \
           file://defconfig \
           file://revert-check-on-console-device.patch \
           file://OE-vga-logo.patch \
           "

SRC_URI_append_tosa = " \
           file://defconfig \
           file://revert-check-on-console-device.patch \
           file://OE-vga-logo.patch \
           file://0001-HACK-video-move-backlight-to-the-end-of-Makefile.patch \
           file://0002-tosa-bl-correct-backlight-calculations.patch \
           file://0003-tmio-call-tmiofb_set_par-in-tmiofb_probe.patch \
           file://0004-ARM-pxa-tosa-switch-to-gpio-charger.patch \
           file://0005-ARM-pxa-tosa-fix-several-build-failures.patch \
           file://0006-mfd-tc6393xb-fail-ohci-suspend-if-full-state-restore.patch \
           file://0007-wm97xx-adapt-parameters-to-tosa-touchscreen.patch \
           "
