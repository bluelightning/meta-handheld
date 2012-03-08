require linux.inc

PR = "${INC_PR}.3"
COMPATIBLE_MACHINE = "(akita|c7x0|collie|poodle|tosa|spitz)"

SRC_URI += "${KERNELORG_MIRROR}/linux/kernel/v3.x/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/linux/kernel/v3.x/patch-${PV}.9.bz2;apply=yes;name=stablepatch \
           file://defconfig \
           file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_collie = " \
                         file://0001-pcmcia-pxa2xx_sharpsl-retain-ops-structure-on-collie.patch \
                         file://locomo_kbd_tweak-r2.patch \
                         file://collie_remove_irq_to_gpio.patch \
                         "

SRC_URI_append_poodle = " \
                         file://locomo_kbd_tweak-r2.patch \
                         "

SRC_URI[kernel.md5sum] = "7ceb61f87c097fc17509844b71268935"
SRC_URI[kernel.sha256sum] = "c881fc2b53cf0da7ca4538aa44623a7de043a41f76fd5d0f51a31f6ed699d463"
SRC_URI[stablepatch.md5sum] = "4610f3e62a5446422d1e81a90ab3cd06"
SRC_URI[stablepatch.sha256sum] = "7836685dee161a4ffaf887b8e2f8dd3cb7712e690d0942fefb1db09bb6ad3871"
