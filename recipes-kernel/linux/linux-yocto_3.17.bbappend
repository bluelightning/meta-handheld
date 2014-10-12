FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.17:${THISDIR}/${PN}:"

# Declare more compatible machines
COMPATIBLE_MACHINE .= "|akita|c7x0|collie|poodle|spitz|tosa"

KERNEL_EXTRA_FEATURES_akita ?= ""
KERNEL_EXTRA_FEATURES_c7x0 ?= ""
KERNEL_EXTRA_FEATURES_collie ?= ""
KERNEL_EXTRA_FEATURES_poodle ?= ""
KERNEL_EXTRA_FEATURES_spitz ?= ""
KERNEL_EXTRA_FEATURES_tosa ?= ""

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
           file://OE-vga-logo.patch \
           "

SRC_URI_append_c7x0 = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           "

SRC_URI_append_collie = " \
           file://defconfig \
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
           file://mtd-resume.patch \
           \
           "

SRC_URI_append_poodle = " \
           file://defconfig \
           file://OE-qvga-logo.patch \
           file://locomo_kbd_tweak-r2.patch \
           file://locomo-fix-SCL-SDA.patch \
           file://locomolcd-suspend-resume.patch \
           "

SRC_URI_append_spitz = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           "

SRC_URI_append_tosa = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           file://0001-HACK-video-move-backlight-to-the-end-of-Makefile.patch \
           file://0002-tosa-bl-correct-backlight-calculations.patch \
           file://0003-tmio-call-tmiofb_set_par-in-tmiofb_probe.patch \
           file://0004-ARM-pxa-tosa-switch-to-gpio-charger.patch \
           file://0005-ARM-pxa-tosa-fix-several-build-failures.patch \
           file://0006-mfd-tc6393xb-fail-ohci-suspend-if-full-state-restore.patch \
           file://0007-wm97xx-adapt-parameters-to-tosa-touchscreen.patch \
           "
