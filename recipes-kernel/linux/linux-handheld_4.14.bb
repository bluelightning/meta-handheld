DESCRIPTION = "Linux kernel for handheld devices"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

COMPATIBLE_MACHINE = "akita|c7x0|spitz|tosa"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v4.x/linux-${PV}.tar.xz;name=kernel \
           ${KERNELORG_MIRROR}/linux/kernel/v4.x/patch-${PV}.62.xz;apply=yes;name=stablepatch \
           "
SRC_URI[kernel.md5sum] = "bacdb9ffdcd922aa069a5e1520160e24"
SRC_URI[kernel.sha256sum] = "f81d59477e90a130857ce18dc02f4fbe5725854911db1e7ba770c7cd350f96a7"
SRC_URI[stablepatch.md5sum] = "725687486363ba8f6b21e7c56e8066ea"
SRC_URI[stablepatch.sha256sum] = "2595a071c6253fb579fa0401b3deb9a9d1ddb74dd1dcd1e668ed4d8726dc4b6c"

SRC_URI += "\
           file://sharpslpart/0001-mtd-sharpslpart-Add-sharpslpart-partition-parser.patch \
           file://sharpslpart/0006-ARM-pxa-corgi-Remove-hardcoded-partitioning-use-shar.patch \
           file://sharpslpart/0007-ARM-pxa-tosa-Remove-hardcoded-partitioning-use-sharp.patch \
           file://sharpslpart/0008-ARM-pxa-spitz-Remove-hardcoded-partitioning-use-shar.patch \
           file://sharpslpart/0009-ARM-pxa-poodle-Remove-hardcoded-partitioning-use-sha.patch \
           "

DEPENDS += "lz4-native"

SRC_URI:append:akita = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           "
SRC_URI:append:c7x0 = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           "
SRC_URI:append:spitz = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           "
SRC_URI:append:tosa = " \
           file://defconfig \
           file://OE-vga-logo.patch \
           file://0001-HACK-video-move-backlight-to-the-end-of-Makefile.patch \
           file://0002-tosa-bl-correct-backlight-calculations.patch \
           file://0003-tmio-call-tmiofb_set_par-in-tmiofb_probe.patch \
           "

inherit kernel

S = "${WORKDIR}/linux-${PV}"
