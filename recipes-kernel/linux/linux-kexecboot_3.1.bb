require linux-kexecboot.inc
require linux-${PV}.inc

PR = "${INC_PR}.6"
S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_MACHINE = "(akita|c7x0|collie|poodle|tosa|spitz)"
