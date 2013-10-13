require linux.inc

PR = "${INC_PR}.11"
COMPATIBLE_MACHINE = "h1940"

SRC_URI += "${KERNELORG_MIRROR}/linux/kernel/v3.x/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/linux/kernel/v3.x/patch-${PV}.10.bz2;apply=yes;name=stablepatch \
           file://defconfig \
           file://qvga/logo_linux_clut224.ppm.bz2 \
           "

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

SRC_URI[kernel.md5sum] = "8d43453f8159b2332ad410b19d86a931"
SRC_URI[kernel.sha256sum] = "2573d2378c754b0c602b57586e9311e5b38c5d1e6c137f02873833633a4b9359"
SRC_URI[stablepatch.md5sum] = "a8e1c25a93a685ec2a1c3a808715fe9d"
SRC_URI[stablepatch.sha256sum] = "f25126052d1a083a415ddd313b40c7fcdb3742f40474cb4a826af7e43fee29d3"
