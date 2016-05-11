DESCRIPTION = "Linux kernel for handheld devices"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

COMPATIBLE_MACHINE = "akita|c7x0|collie|h3600|hx4700|poodle|spitz|tosa"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
           ${KERNELORG_MIRROR}/linux/kernel/v4.x/patch-${PV}.10.xz;apply=yes;name=stablepatch \
           "
SRC_URI[kernel.md5sum] = "9a78fa2eb6c68ca5a40ed5af08142599"
SRC_URI[kernel.sha256sum] = "401d7c8fef594999a460d10c72c5a94e9c2e1022f16795ec51746b0d165418b2"
SRC_URI[stablepatch.md5sum] = "1b9a296c0d0b778e8173299618f2d84f"
SRC_URI[stablepatch.sha256sum] = "df66bd2532cac85dfb85d6ca9b750689e02278442652a0b047304e3322947d17"

SRC_URI += "\
           file://ASoC-pxa-fix-module-autoload-for-platform-drivers.patch \
           file://dmaengine-mmp-pdma-add-number-of-requestors.patch \
           "

LOCOMO_PATCHES = "\
           file://locomo/0001-mfd-add-new-driver-for-Sharp-LoCoMo.patch \
           file://locomo/0002-leds-port-locomo-leds-driver-to-new-locomo-core.patch \
           file://locomo/0003-input-convert-LoCoMo-keyboard-driver-to-use-new-loco.patch \
           file://locomo/0004-input-locomokbd-differentiate-between-two-Enter-keys.patch \
           file://locomo/0005-video-backlight-add-new-locomo-backlight-driver.patch \
           file://locomo/0006-video-lcd-add-LoCoMo-LCD-driver.patch \
           file://locomo/0007-gpio-port-LoCoMo-gpio-support-from-old-driver.patch \
           file://locomo/0008-gpio-locomo-implement-per-pin-irq-handling.patch \
           file://locomo/0009-i2c-add-locomo-i2c-driver.patch \
           file://locomo/0010-ARM-sa1100-make-collie-use-new-locomo-drivers.patch \
           file://locomo/0011-ARM-sa1100-don-t-preallocate-IRQ-space-for-locomo.patch \
           file://locomo/0012-ASoC-pxa-poodle-make-use-of-new-locomo-GPIO-interfac.patch \
           file://locomo/0013-ARM-pxa-poodle-use-new-LoCoMo-driver.patch \
           file://locomo/0014-ARM-pxa-poodle-don-t-preallocate-IRQ-space-for-locom.patch \
           file://locomo/0015-video-backlight-drop-old-locomo-bl-lcd-driver.patch \
           file://locomo/0016-ARM-drop-old-LoCoMo-driver.patch \
           file://locomo/0017-input-make-LoCoMo-keyboard-driver-support-both-poodl.patch \
           file://locomo/0018-spi-add-locomo-SPI-driver.patch \
           file://locomo/0019-ARM-pxa-add-gpio-charger-configuration-on-poodle.patch \
           file://locomo/0020-ARM-pxa-poodle-add-gpio-keys-configuration.patch \
           file://locomo/0021-ARM-pxa-declare-battery-device-on-poodle.patch \
           file://locomo/0022-power-add-poodle-battery-driver.patch \
           file://locomo/0023-poodle-gpio-uart-hack.patch \
           file://locomo/0032-ARM-sa1100-add-dummy-clk_set_rate-implementation.patch \
           file://locomo/0033-mfd-ucb1x00-ts-use-gpiolib-to-access-TBL_CHK-pin-on-.patch \
           file://locomo/0034-mfd-ucb1x00-drop-old-io-accessors.patch \
           file://locomo/0035-mfd-ucb1x00-add-irq-field-to-the-platform-data.patch \
           file://locomo/0036-ARM-sa1100-populate-codec-platform-data-with-irq.patch \
           file://locomo/0037-mfd-ucb1x00-make-use-of-provided-irq.patch \
           file://locomo/0038-XXX-ucb11x0-don-t-exit-if-UCB-is-not-detected.patch \
           file://locomo/0040-input-locomokbd-provide-an-Alt-SysRQ-combination.patch \
           "
LOCOMO_PATCHES += "file://locomo/0090-locomokbd.c-fix-missing-KEY_CENTER.patch"

SRC_URI_append_akita = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           "
SRC_URI_append_c7x0 = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           "
SRC_URI_append_collie = " \
           ${LOCOMO_PATCHES} \
           file://defconfig \
           file://OE-qvga-logo.patch \
           "
SRC_URI_append_h3600 = " \
           file://defconfig \
           file://OE-qvga-logo.patch \
           "
SRC_URI_append_hx4700 = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           file://hx4700-change-led-trigger-assignments.patch \
           "
SRC_URI_append_poodle = " \
           ${LOCOMO_PATCHES} \
           file://defconfig \
           file://OE-qvga-logo.patch \
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

S = "${WORKDIR}/linux-${PV}"
