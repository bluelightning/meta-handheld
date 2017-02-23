DESCRIPTION = "Installkit for kexecboot-kernel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"
DEPENDS = "${@base_conditional('MACHINE', 'collie', 'linux-kexecboot', 'zaurus-updater linux-kexecboot', d)}"
DEPENDS += "${@base_conditional('MACHINE', 'spitz', 'zaurus-legacy-tar', '', d)}"
PR = "r7"

INHIBIT_DEFAULT_DEPS = "1"

do_compile() {
        :
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGES = ""

COMPATIBLE_MACHINE = "collie|poodle|c7x0|spitz|akita|tosa"

inherit deploy

addtask deploy before do_populate_sysroot after do_compile

do_deploy() {
        cd ${DEPLOYDIR}
        rm -rf ${DEPLOYDIR}/installkit-${MACHINE}/
        mkdir installkit-${MACHINE}/
        [ -f "${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-kexecboot-${MACHINE}.bin" ] && cp ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-kexecboot-${MACHINE}.bin installkit-${MACHINE}/${KERNEL_IMAGETYPE}
        if [ ! "${MACHINE}" = "collie" ]; then
                cp ${DEPLOY_DIR_IMAGE}/updater.sh installkit-${MACHINE}/updater.sh
        fi
        if [ "${MACHINE}" = "spitz" ]; then
                cp ${DEPLOY_DIR_IMAGE}/gnu-tar installkit-${MACHINE}/gnu-tar
        fi
        tar czf ${DEPLOYDIR}/installkit-${MACHINE}.tar.gz installkit-${MACHINE}/
        md5sum ${DEPLOYDIR}/installkit-${MACHINE}.tar.gz > ${DEPLOYDIR}/installkit-${MACHINE}.tar.gz.md5
        rm -rf ${DEPLOYDIR}/installkit-${MACHINE}/
}
