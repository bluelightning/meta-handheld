require linux.inc

PR = "r0"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_h3600 = "1"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v2.6/linux-2.6.29.6.tar.bz2;name=kernel \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.29.6"

SRC_URI_append_h3600 = "\
    file://01_pushed_upstream/0001--ARM-5407-1-SA1100-drop-broken-for-ages-iPAQ-h380.patch \
    file://01_pushed_upstream/0002--ARM-5408-1-SA1100-update-defconfigs-after-h3800.patch \
    file://01_pushed_upstream/0003--ARM-5423-1-SA1100-remove-unused-H3600_SLEEVE-Kco.patch \
    file://01_pushed_upstream/0004--ARM-5424-1-h3600-clean-up-mtd-partitions-table.patch \
    file://01_pushed_upstream/0005--ARM-5425-1-h3600-first-stage-of-ipaq_model_ops-c.patch \
    file://01_pushed_upstream/0006--ARM-5426-1-h3600-remove-clr_h3600_egpio-set_h360.patch \
    file://01_pushed_upstream/0007--ARM-5427-1-h3600-ipaq_model_ops-final-cleanup.patch \
    file://01_pushed_upstream/0008-ALSA-drop-outdated-and-broken-sa11xx-uda1341-driver.patch \
    file://02_cleanup_wip/0009-mtd-remove-obsolete-ipaq-flash-driver.patch \
    file://02_cleanup_wip/0010-h3600-introduce-new-set-of-GPIO-defines.patch \
    file://02_cleanup_wip/0011-h3600-remove-unused-includes.patch \
    file://02_cleanup_wip/0012-h3600-add-include-linux-gpio.h.patch \
    file://02_cleanup_wip/0013-h3600-split-common-h3xxx_lcd_power.patch \
    file://02_cleanup_wip/0014-h3600-split-common-h3xxx_mach_init.patch \
    file://02_cleanup_wip/0015-h3600-remove-IRDA-tranceiver-stuff-from-serial-PM-c.patch \
    file://02_cleanup_wip/0016-h3600-switch-serial-hooks-to-use-gpiolib-functions.patch \
    file://02_cleanup_wip/0017-h3600-remove-unused-set_wake-callback-from-sa1100_p.patch \
    file://02_cleanup_wip/0018-serial-remove-unused-set_wake-from-sa1100_serial.patch \
    file://03_add_features/0019-h3600-add-gpio-keys-for-Power-and-Action-buttons.patch \
    file://03_add_features/0020-input-fix-compilation-of-h3600-touchscreen-driver.patch \
    file://03_add_features/0021-input-fix-h3600_ts_input-kconfig-dependency.patch \
    file://03_add_features/0022-MFD-driver-for-Atmel-Microcontroller-on-iPaq-h3600.patch \
    file://03_add_features/0023-input-driver-for-keys-connected-to-microcontroller.patch \
    file://03_add_features/0024-input-driver-for-touchscreen-on-iPaq-h3600-h3100.patch \
    file://03_add_features/0025-power-add-driver-for-battery-reading-on-iPaq-h3600.patch \
    file://03_add_features/0026-h3600-add-micro-platform-device.patch \
    file://03_add_features/0027-USB-add-sa1100_udc-driver.patch \
    file://03_add_features/0028-h3600-fix-suspend-HACK.patch \
    file://03_add_features/0029-pcmcia-fix-oops-on-suspend-in-sa1100_pcmcia-HACK.patch \
    file://misc/patch_needed_for_old_touchscreen_driver/0005-SA1100-enable-second-serial-port-on-h3600.patch \
	"	

SRC_URI[kernel.md5sum] = "7cd24826fd3c7b0f83d9f662731a7865"
SRC_URI[kernel.sha256sum] = "536e69548e27da1f4693867fbbd6eedf6bdaa2e7656c743ce1d0b36b1becc5f9"

do_configure_prepend() {
	# Rename getline in ./scripts/unifdef.c
	# Kernels up to 2.6.29 are currently failing to build unifdef.c,
	# clashing with exposed getline() from <stdio.h>
	# see https://patchwork.kernel.org/patch/11166/
	# committed in 2.6.29 (commit d15bd1067b1fcb2b7250d22bc0c7c7fea0b759f7)

	if [ -e ${S}/scripts/unifdef.c ]; then
		sed -i -e 's/getline/parseline/g' ${S}/scripts/unifdef.c
	fi
}
