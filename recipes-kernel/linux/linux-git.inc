KERNEL_RELEASE = "3.2.0-rc3"
OLD_KERNEL_RELEASE = "3.1.99"
PV = "${OLD_KERNEL_RELEASE}+${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "caca6a03d365883564885f2c1da3e88dcf65d139"

CMDLINE_DEBUG = "debug"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux-2.6.git;protocol=git;branch=master \
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
