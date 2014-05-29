FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.14:${THISDIR}/${PN}:"

# Declare more compatible machines
COMPATIBLE_MACHINE .= "|akita|c7x0|collie|h1940|h3600|hx4700|poodle|spitz|tosa"

KERNEL_EXTRA_FEATURES_akita ?= ""
KERNEL_EXTRA_FEATURES_c7x0 ?= ""
KERNEL_EXTRA_FEATURES_collie ?= ""
KERNEL_EXTRA_FEATURES_h1940 ?= ""
KERNEL_EXTRA_FEATURES_h3600 ?= ""
KERNEL_EXTRA_FEATURES_hx4700 ?= ""
KERNEL_EXTRA_FEATURES_poodle ?= ""
KERNEL_EXTRA_FEATURES_spitz ?= ""
KERNEL_EXTRA_FEATURES_tosa ?= ""

KMACHINE_akita = "akita"
KMACHINE_c7x0 = "c7x0"
KMACHINE_collie = "collie"
KMACHINE_h1940 = "h1940"
KMACHINE_h3600 = "h3600"
KMACHINE_hx4700 = "hx4700"
KMACHINE_poodle = "poodle"
KMACHINE_spitz = "spitz"
KMACHINE_tosa = "tosa"

# Note: Providing "defconfig" we bypass the linux-yocto processing
# re-expand the defconfig produced by "make_savedefconfig"
KCONFIG_MODE_akita = "--alldefconfig"
KCONFIG_MODE_c7x0 = "--alldefconfig"
KCONFIG_MODE_collie = "--alldefconfig"
KCONFIG_MODE_h1940 = "--alldefconfig"
KCONFIG_MODE_h3600 = "--alldefconfig"
KCONFIG_MODE_hx4700 = "--alldefconfig"
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
           file://corgi-gpio_keys.patch \
           "

SRC_URI_append_collie = " \
           file://defconfig \
           file://OE-qvga-logo.patch \
           file://locomo_kbd_tweak-r2.patch \
           \
           file://collie-irda.patch \
           \
           file://collie-cfi-probe-again.patch \
           file://collie-mtd-resize.patch \
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

SRC_URI_append_h1940 = " \
           file://defconfig \
           file://OE-qvga-logo.patch \
           file://0001-rfkill-add-IR-type.patch \
           file://0002-ARM-s3c24xx-Remove-S3C24XX_DMA-dependency-from-S3C24.patch \
           file://0003-ARM-s3c24xx-add-dma_coherent_mask-for-DMA-devices.patch \
           file://0004-ARM-s3c24xx-Add-DMA-resources-for-SDI-and-I2S.patch \
           file://0005-ARM-s3c24xx-drop-RFKILL-driver-for-H1940-bluetooth.patch \
           file://0006-ARM-s3c24xx-h1940-Add-nand-device.patch \
           file://0007-ARM-s3c24xx-h1940-don-t-touch-UPLLCON.patch \
           file://0008-ARM-s3c24xx-h1940-unlock-reset-button.patch \
           file://0009-ARM-s3c24xx-h1940-add-bluetooth-RF-kill-switch.patch \
           file://0010-ARM-s3c24xx-h1940-add-IR-switch.patch \
           file://0011-ARM-s3c24xx-h1940-increase-oversampling-shift.patch \
           file://0012-ARM-s3c24xx-h1940-Add-DMA-device.patch \
           file://0013-dmaengine-s3c24xx-dma-Process-whole-SG-chain.patch \
           file://0014-dmaengine-s3c24xx-dma-Add-cyclic-transfer-support.patch \
           file://0015-s3cmci-port-DMA-code-to-dmaengine-API.patch \
           file://0016-ASoC-samsung-s3c24-xx-12-i2s-port-to-use-generic-dma.patch \
           file://0017-ASoC-samsung-drop-support-for-legacy-S3C24XX-DMA-API.patch \
           "

SRC_URI_append_h3600 = " \
           file://defconfig \
           file://OE-qvga-logo.patch \
           file://0001-MFD-driver-for-Atmel-Microcontroller-on-iPaq-h3xxx.patch \
           file://0002-ARM-sa1100-add-Micro-ASIC-platform-device.patch \
           file://0003-input-driver-for-microcontroller-keys-on-the-iPaq-h3.patch \
           file://0004-fb-backlight-add-driver-for-iPAQ-micro-backlight.patch \
           file://0005-input-driver-for-touchscreen-on-iPaq-h3xxx.patch \
           file://0006-leds-add-driver-for-the-iPAQ-micro.patch \
           file://0007-power-add-driver-for-battery-reading-on-iPaq-h3xxx.patch \
           "

SRC_URI_append_hx4700 = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           file://hx4700-change-led-trigger-assignments.patch \
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
