KERNEL_RELEASE = "3.1.0-rc6"
OLD_KERNEL_RELEASE = "3.0.99"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "b6fd41e29dea9c6753b1843a77e50433e6123bcb"

#git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git
SRC_URI = "git://github.com/torvalds/linux.git;protocol=git;branch=master \
           file://defconfig"
S = "${WORKDIR}/git"

do_configure_prepend() {
#otherwise it gets extra '+' "2.6.37+"
#because:
#$ scripts/setlocalversion . => +
#$ make kernelversion => 2.6.37
#$ make kernelrelease => 2.6.37+
  rm -rf ${S}/.git
}

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-2"
