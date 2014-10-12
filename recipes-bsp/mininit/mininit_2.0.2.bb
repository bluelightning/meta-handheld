SUMMARY = "mininit for romfs/squashfs loop images"
DESCRIPTION = "mininit is a linux-as-bootloader implementation based on losetup."
HOMEPAGE = "https://github.com/OpenDingux/mininit"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://license.txt;md5=a00f7cbb0dca244e8ae6aaa792217ecf"

SRC_URI = "https://github.com/OpenDingux/mininit/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "13c6ad344c9f29e28267c37718926d83"
SRC_URI[sha256sum] = "bdece10be16af57758e87d9be7d17a37deb7c42253966b7c06b334acea93992f"

S = "${WORKDIR}/mininit-${PV}"

LDFLAGS += '-static'

do_compile () {
        oe_runmake
}
do_install () {
        install -d ${D}${bindir}/
        install -m 0755 mininit-initramfs ${D}${bindir}/mininit
        install -d ${D}/dev
        install -d ${D}/boot
        install -d ${D}/root
        install -d ${D}/proc
        install -d ${D}/sys
}

FILES_${PN} += " ${bindir}/mininit-initramfs /init /dev /boot /root /proc /sys"

pkg_postinst_${PN} () {
        ln -sf ${bindir}/mininit $D/init
}

BBCLASSEXTEND = "klibc"

COMPATIBLE_MACHINE = "(akita|c7x0|collie|gcw0|h1940|h3600|hx4700|poodle|spitz|tosa)"
