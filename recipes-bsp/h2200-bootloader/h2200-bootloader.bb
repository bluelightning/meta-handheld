DESCRIPTION = "Bootloader firmware extractor for the h2200 iPAQ"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
ALLOW_EMPTY = "1"
PR = "r4"

COMPATIBLE_MACHINE = "h2200"
#it is a shell script, but lets protect the innocent some more
PACKAGE_ARCH = "h2200"

pkg_postinst() {
#!/bin/sh
mkdir -p /lib/firmware
dd if=/dev/mtdblock0 of=/lib/firmware/h2200_bootloader.bin 2>/dev/null
}
