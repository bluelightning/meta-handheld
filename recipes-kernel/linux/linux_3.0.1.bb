require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_hx4700 = "1"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v3.0/linux-${PV}.tar.bz2;name=kernel \
           file://defconfig "

SRC_URI[kernel.md5sum] = "aed949984b878b7fb77ffe9cbee8ce0c"
SRC_URI[kernel.sha256sum] = "8603c451d6779f55175c2c96a92a40177c89ed4e0217501258214a64c9c4e127"

SRC_URI_append_hx4700 = " \
  file://0001-Add-LED-support-for-the-HTC-ASIC3.-Underlying-suppor.patch \
  file://0002-tmio_mmc_irq-race.patch \
  file://0003-Only-compile-tmio_mmc_dma.o-when-CONFIG_MMC_SDHI-is-.patch \
  file://0004-Add-PCMCIA-CF-support-for-the-HTC-ASIC3.-Underlying-.patch \
  file://0005-Suspend-unbalanced-irqs.patch \
  file://0006-suspend.patch \
  file://0007-hx4700-change-led-trigger-assignments.patch \
  "

