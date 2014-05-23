SUMMARY = "mininit for romfs/squashfs loop images"
DESCRIPTION = "mininit is a linux-as-bootloader implementation based on losetup."
HOMEPAGE = "https://github.com/pcercuei/mininit"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://init.c;md5=305bd83abb9a5aac95d48b5efbc11d58"
SRCREV = "51eaefcaea52a5dbc1addd21ba93154aa9c97d66"
PV = "1.1.0"

SRC_URI = "git://github.com/pcercuei/mininit.git"
SRC_URI[md5sum] = "62509644735a4e599e3ed0229f283faa"
SRC_URI[sha256sum] = "4d747b16c33ac64a7923a179947d5581b4e309b73a3c89824056e9c4f0749f18"

S = "${WORKDIR}/git"

do_compile () {
        oe_runmake mininit
}
do_install () {
        install -d ${D}${bindir}/
        install -m 0755 mininit ${D}${bindir}/
        install -d ${D}/dev
        install -d ${D}/boot
        install -d ${D}/root
        install -d ${D}/proc
        install -d ${D}/sys
}

FILES_${PN} += " ${bindir}/mininit /init /dev /boot /root /proc /sys"

pkg_postinst_${PN} () {
        ln -sf ${bindir}/mininit $D/init
}

BBCLASSEXTEND = "klibc"

COMPATIBLE_MACHINE = "(akita|c7x0|collie|gcw0|h1940|h3600|hx4700|poodle|spitz|tosa)"
