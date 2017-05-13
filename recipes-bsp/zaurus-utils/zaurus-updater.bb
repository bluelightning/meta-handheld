DESCRIPTION = "Encrypted shellscript for the Zaurus ROM update"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://updater.sh;endline=69;md5=0d6bbac0e2abe4edc46690fe4efbaa9b"
DEPENDS = "encdec-updater-native"
PV = "2017.05"

INHIBIT_DEFAULT_DEPS = "1"

SRC_URI = "file://updater.sh"

S = "${WORKDIR}"

do_configure() {
        sed -i "s/ZAURUS_UPDATER_VERSION/${PV}/" "${S}/updater.sh"
}
do_compile() {
        encdec-updater -e updater.sh
}

# even though the package is not machine-specific
# we have to force it there to allow multimachine builds
PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGES = ""

COMPATIBLE_MACHINE = "(poodle|c7x0|spitz|akita|tosa)"

inherit deploy

addtask deploy before do_populate_sysroot after do_compile

do_deploy() {
        install -d ${DEPLOYDIR}
        install -m 0755 updater.sh ${DEPLOYDIR}/updater.sh
}
