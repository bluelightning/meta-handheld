DESCRIPTION = "Linux kernel for handheld devices"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

COMPATIBLE_MACHINE .= "|akita|c7x0|collie|h1940|h3600|hx4700|poodle|spitz|tosa"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-4.0.tar.xz;name=kernel"
SRC_URI[kernel.md5sum] = "a86916bd12798220da9eb4a1eec3616d"
SRC_URI[kernel.sha256sum] = "0f2f7d44979bc8f71c4fc5d3308c03499c26a824dd311fdf6eef4dee0d7d5991"
SRC_URI += "\
           file://arm-sa1100-dummy-clk_set_rate.patch \
           \
           file://locomo/0001-iio-add-m62332-DAC-driver.patch \
           file://locomo/0002-mfd-add-new-driver-for-Sharp-LoCoMo.patch \
           file://locomo/0003-leds-port-locomo-leds-driver-to-new-locomo-core.patch \
           file://locomo/0004-input-convert-LoCoMo-keyboard-driver-to-use-new-loco.patch \
           file://locomo/0005-input-locomokbd-provide-an-Alt-SysRQ-combination.patch \
           file://locomo/0006-video-backlight-add-new-locomo-backlight-driver.patch \
           file://locomo/0007-video-lcd-add-LoCoMo-LCD-driver.patch \
           file://locomo/0008-GPIO-port-LoCoMo-gpio-support-from-old-driver.patch \
           file://locomo/0009-gpio-locomo-implement-per-pin-irq-handling.patch \
           file://locomo/0010-spi-add-locomo-SPI-driver.patch \
           file://locomo/0011-i2c-add-locomo-i2c-driver.patch \
           file://locomo/0012-ARM-drop-old-LoCoMo-driver.patch \
           file://locomo/0013-video-backlight-drop-old-locomo-bl-lcd-driver.patch \
           file://locomo/0014-ARM-sa1100-make-collie-use-new-locomo-drivers.patch \
           file://locomo/0015-ARM-sa1100-don-t-preallocate-IRQ-space-for-locomo.patch \
           file://locomo/0016-ARM-pxa-poodle-use-new-LoCoMo-driver.patch \
           file://locomo/0017-ARM-pxa-poodle-don-t-preallocate-IRQ-space-for-locom.patch \
           file://locomo/0018-ASoC-pxa-poodle-make-use-of-new-locomo-GPIO-interfac.patch \
           file://locomo/0019-poodle-gpio-uart-hack.patch \
           file://locomo/0020-irq-HACK-around-for-handling-irq0-when-we-should.patch \
           \
           "
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
           "
SRC_URI_append_h1940 = " \
           file://defconfig \
           file://OE-qvga-logo.patch \
           file://0001-rfkill-add-IR-type.patch \
           file://0002-ARM-s3c24xx-add-dma_coherent_mask-for-DMA-devices.patch \
           file://0003-ARM-s3c24xx-Add-DMA-resources-for-SDI-and-I2S.patch \
           file://0004-ARM-s3c24xx-drop-RFKILL-driver-for-H1940-bluetooth.patch \
           file://0005-ARM-s3c24xx-h1940-Add-nand-device.patch \
           file://0006-ARM-s3c24xx-h1940-don-t-touch-UPLLCON.patch \
           file://0007-ARM-s3c24xx-h1940-unlock-reset-button.patch \
           file://0008-ARM-s3c24xx-h1940-increase-oversampling-shift.patch \
           file://0009-ARM-s3c24xx-h1940-Add-DMA-device.patch \
           file://0010-ARM-s3c24xx-h1940-add-bluetooth-RF-kill-switch.patch \
           file://0011-ARM-s3c24xx-h1940-add-IR-switch.patch \
           file://0012-ARM-s3c24xx-ADC-port-to-common-clock-framework.patch \
           file://0013-ARM-s3c24xx-H1940-Move-gpiochip_add-call-into-core_i.patch \
           file://0014-i2c-s3c2410-fix-oops-in-suspend-callback-for-non-dt-.patch \
           file://0015-ASoC-uda1380-Avoid-accessing-i2c-bus-when-codec-is-d.patch \
           "
SRC_URI_append_h3600 = " \
           file://defconfig \
           file://OE-qvga-logo.patch \
           file://0002-input-driver-for-microcontroller-keys-on-the-iPaq-h3.patch \
           "
SRC_URI_append_hx4700 = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           file://hx4700-change-led-trigger-assignments.patch \
           "
SRC_URI_append_poodle = " \
           file://defconfig \
           file://OE-qvga-logo.patch \
           file://0001-ARM-pxa-add-gpio-charger-configuration-on-poodle.patch \
           file://0002-ARM-pxa-poodle-add-gpio-keys-configuration.patch \
           file://0003-ARM-pxa-declare-battery-device-on-poodle.patch \
           file://0004-power-add-poodle-battery-driver.patch \
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
           "

inherit kernel

S = "${WORKDIR}/linux-4.0"
