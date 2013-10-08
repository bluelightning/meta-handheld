FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.10:${THISDIR}/${PN}:${THISDIR}/files:"

COMPATIBLE_MACHINE .= "|akita|c7x0|collie|poodle|spitz|tosa"

# Zaurus machines need kernel size-check.
KERNEL_IMAGE_MAXSIZE_akita = "1294336"
KERNEL_IMAGE_MAXSIZE_c7x0 = "1294336"
KERNEL_IMAGE_MAXSIZE_collie = "1048576"
KERNEL_IMAGE_MAXSIZE_poodle = "1294336"
KERNEL_IMAGE_MAXSIZE_tosa = "1294336"
KERNEL_IMAGE_MAXSIZE_spitz = "1294336"

require linux-yocto-handhelds.inc
