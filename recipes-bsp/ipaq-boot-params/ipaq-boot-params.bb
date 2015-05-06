DESCRIPTION = "Kernel boot parameters for HH.org bootldr"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

COMPATIBLE_MACHINE = "h3600"

SRC_URI = "file://params"

S = "${WORKDIR}"

do_install() {
        install -d ${D}/boot
        install -m 0644 ${WORKDIR}/params ${D}/boot/
}

FILES_${PN} = "/boot/params"
PACKAGE_ARCH = "${MACHINE_ARCH}"

