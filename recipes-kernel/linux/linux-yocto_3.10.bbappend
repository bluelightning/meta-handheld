FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.10:${THISDIR}/${PN}:${THISDIR}/files:"

# Override kernel features
#KERNEL_EXTRA_FEATURES ?= "features/netfilter/netfilter.scc"

KERNEL_EXTRA_FEATURES_akita ?= ""
KERNEL_EXTRA_FEATURES_c7x0 ?= ""
KERNEL_EXTRA_FEATURES_collie ?= ""
KERNEL_EXTRA_FEATURES_poodle ?= ""
KERNEL_EXTRA_FEATURES_spitz ?= ""
KERNEL_EXTRA_FEATURES_tosa ?= ""


require linux-yocto-handhelds.inc
