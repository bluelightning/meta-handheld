DESCRIPTION = "Linux kernel for the GCW Zero"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

COMPATIBLE_MACHINE = "gcw0"

SRC_URI = "git://github.com/gcwnow/linux.git;branch=jz-4.0 \
          file://defconfig \
          "
SRCREV = "5480c81f8c145a06a5ec1f405e5639c579d7c4ac"

inherit kernel

S = "${WORKDIR}/git"
