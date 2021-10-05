DESCRIPTION = "Kernel boot parameters for HH.org bootldr"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

COMPATIBLE_MACHINE = "h3600"

SRC_URI = "file://params"

S = "${WORKDIR}"

do_install() {
        install -d ${D}/boot
        install -m 0644 ${WORKDIR}/params ${D}/boot/
}

FILES:${PN} = "/boot/params"
PACKAGE_ARCH = "${MACHINE_ARCH}"
