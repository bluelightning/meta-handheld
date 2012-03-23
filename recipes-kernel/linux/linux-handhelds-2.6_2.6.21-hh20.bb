SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel 2.6 for PocketPCs and other consumer handheld devices."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PR = "r27"

DEFAULT_PREFERENCE = "-1"

# Override where to look for defconfigs and patches,
# we have per-kernel-release sets.
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-handhelds-2.6-2.6.21:"

SRC_URI = "http://sources.openembedded.org/linux.kernel26_anoncvs.handhelds.org_K2-6-21-hh20_.tar.gz;name=kernelsrc \
           file://linux-2.6.git-9d20fdd58e74d4d26dc5216efaaa0f800c23dd3a.patch \
           http://www.rpsys.net/openzaurus/patches/archive/export_atags-r0a.patch;name=rppatch35 \
           file://gcc4x-limits.patch \
           file://0001-time-prevent-the-loop-in-timespec_add_ns-from-bei.patch \
           file://makefile-implicit.patch \
	   file://defconfig"

require linux-handhelds-2.6.inc

#           ${RPSRC}/export_atags-r0a.patch;status=pending;name=rppatch35 \
SRC_URI[rppatch35.md5sum] = "8ab51e8ff728f4155db64b9bb6ea6d71"
SRC_URI[rppatch35.sha256sum] = "75d4c6ddbfc5e4fff7690a3308e2574f89a0e2709fb91caccb29067a9dad251a"
SRC_URI[kernelsrc.md5sum] = "1098aed5ccce21d880d98b4ed71b9bcd"
SRC_URI[kernelsrc.sha256sum] = "033abe5cc3350ff3627ce2cb8cb9d1a5067823f3c196b3b90d6b428d8e9d4f4b"
