DESCRIPTION = "Linux kernel 3.12 for the GCW Zero"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

COMPATIBLE_MACHINE = "gcw0"

SRC_URI = "git://github.com/gcwnow/linux.git;branch=jz-3.12 \
	file://defconfig"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit kernel
