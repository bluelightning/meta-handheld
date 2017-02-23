DESCRIPTION = "Legacy GNU-tar to unpack hd images on install for Zaurus spitz"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${WORKDIR}/zaurus-legacy-tar;md5=34b647d6444a9a38e269c2793c7d0bf2"

INHIBIT_DEFAULT_DEPS = "1"

SRC_URI = "http://sources.openembedded.org/zaurus-legacy-tar.gz"
SRC_URI[md5sum] = "68e352a0cab501852c519d2a17331834"
SRC_URI[sha256sum] = "65a20b0c4d2a6d49653fcfed5ccca894060106b83b3fb88aded5146ac46dad95"

PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGES = ""

COMPATIBLE_MACHINE = "spitz"

inherit deploy

addtask deploy before do_populate_sysroot after do_compile

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_deploy() {
        install -d ${DEPLOYDIR}
        install -m 0755 ${WORKDIR}/zaurus-legacy-tar ${DEPLOYDIR}/gnu-tar
}
