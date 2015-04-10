DESCRIPTION = "Linux kernel for the GCW Zero"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

COMPATIBLE_MACHINE = "gcw0"

SRC_URI = "git://github.com/gcwnow/linux.git;branch=jz-3.19 \
          file://defconfig \
          "
SRCREV = "9482cbbce300c7ae7ff3faa99abc7d5cb319d915"

inherit kernel

S = "${WORKDIR}/git"
