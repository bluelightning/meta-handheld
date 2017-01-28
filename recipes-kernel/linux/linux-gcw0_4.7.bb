DESCRIPTION = "Linux kernel for the GCW Zero"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

COMPATIBLE_MACHINE = "gcw0"

SRC_URI = "git://github.com/gcwnow/linux.git;branch=jz-4.7 \
          file://defconfig \
          "
SRCREV = "6bc18038a011e5627c2a6f00d2181a5d3e4bebc9"

inherit kernel
addtask kernel_link_images after do_compile before do_strip

S = "${WORKDIR}/git"
