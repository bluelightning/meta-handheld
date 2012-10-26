
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PRINC := "${@int(PRINC) + 1}"

# check only for ABS_X (0x00) and ABS_Y (0x01), ignore ABS_PRESSURE (0x18)
do_configure_append () {
        sed -i -e 's/"input:*-e0*,3,*a0,1,*18,*"/"input:*-e0*,3,*a0,1,*"/' ${WORKDIR}/local.rules
}
