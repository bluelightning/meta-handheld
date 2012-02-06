require linux.inc
require linux-${PV}.inc

PR = "${INC_PR}.9"

COMPATIBLE_MACHINE = "(akita|c7x0|collie|poodle|tosa|spitz|h1940)"

SRC_URI_append_h1940 = " \
                        file://0001-s3c24xx-DMA-don-t-use-autoreload-feature.patch \
                        file://0002-s3cmci-minor-fixups.patch \
                        file://0003-ARM-s3c2410-drop-RFKILL-driver-for-H1940-bluetooth.patch \
                        file://0004-mtd-nand-s3c2410-add-iPAQ-specific-layout.patch \
                        file://0005-ARM-s3c2410-Add-nand-device-for-h1940.patch \
                        file://0006-ARM-s3c2410-h1940-don-t-touch-UPLLCON.patch \
                        file://0007-ARM-s3c2410-unlock-reset-button-on-H1940.patch \
                        file://0008-ARM-h1940-add-bluetooth-RF-kill-switch.patch \
                        file://0009-rfkill-add-IR-type.patch \
                        file://0010-rfkill_gpio-add-support-for-inverted-GPIOs.patch \
                        file://0011-ARM-h1940-add-IR-switch.patch \
                        file://0012-ARM-h1940-increase-oversampling-shift.patch \
                        "
