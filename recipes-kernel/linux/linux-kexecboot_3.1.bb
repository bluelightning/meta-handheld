require linux-kexecboot.inc

PR = "${INC_PR}.2"
S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_MACHINE = "(akita|c7x0|collie|poodle|tosa|spitz)"

SRC_URI += "${KERNELORG_MIRROR}/linux/kernel/v3.x/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/linux/kernel/v3.x/patch-${PV}.4.bz2;apply=yes;name=stablepatch \
           file://defconfig \
           file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_collie = " \
                         file://0001-pcmcia-pxa2xx_sharpsl-retain-ops-structure-on-collie.patch \
                         file://locomo_kbd_tweak-r2.patch \
                         "

SRC_URI_append_poodle = " \
                         file://locomo_kbd_tweak-r2.patch \
                         "

SRC_URI[kernel.md5sum] = "8d43453f8159b2332ad410b19d86a931"
SRC_URI[kernel.sha256sum] = "2573d2378c754b0c602b57586e9311e5b38c5d1e6c137f02873833633a4b9359"
SRC_URI[stablepatch.md5sum] = "b8b14bdfbf76cfef8e042e7d1a385fca"
SRC_URI[stablepatch.sha256sum] = "7fab9b4984bdc00781450ae3cdee7b1218a07d5ed8081da115316f17392a8d5f"
