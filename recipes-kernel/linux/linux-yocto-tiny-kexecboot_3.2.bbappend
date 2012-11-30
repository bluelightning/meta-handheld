FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-3.2:${THISDIR}/${PN}:${THISDIR}/files:"

COMPATIBLE_MACHINE .= "|akita|c7x0|collie|poodle|spitz|tosa"

KMACHINE_akita = "akita"
KMACHINE_c7x0 = "c7x0"
KMACHINE_collie = "collie"
KMACHINE_poodle = "poodle"
KMACHINE_spitz = "spitz"
KMACHINE_tosa = "tosa"

# Zaurus machines need kernel size-check.
KERNEL_IMAGE_MAXSIZE_akita = "1294336"
KERNEL_IMAGE_MAXSIZE_c7x0 = "1294336"
KERNEL_IMAGE_MAXSIZE_collie = "1048576"
KERNEL_IMAGE_MAXSIZE_poodle = "1294336"
KERNEL_IMAGE_MAXSIZE_tosa = "1294336"
KERNEL_IMAGE_MAXSIZE_spitz = "1294336"

SRC_URI_append_akita = " \
           file://akita-tiny.scc \
           file://akita-kexecboot.cfg \
           file://vga/logo_linux_clut224.ppm.bz2 \
           file://revert-check-on-console-device.patch \
           "

SRC_URI_append_c7x0 = " \
           file://c7x0-tiny.scc \
           file://c7x0-kexecboot.cfg \
           file://vga/logo_linux_clut224.ppm.bz2 \
           file://revert-check-on-console-device.patch \
           "

SRC_URI_append_collie = " \
           file://collie-tiny.scc \
           file://collie-kexecboot.cfg \
           file://qvga/logo_linux_clut224.ppm.bz2 \
           file://0001-pcmcia-pxa2xx_sharpsl-retain-ops-structure-on-collie.patch \
           file://locomo_kbd_tweak-r2.patch \
           file://collie_remove_irq_to_gpio.patch \
           file://revert-check-on-console-device.patch \
           "

SRC_URI_append_poodle = " \
           file://poodle-tiny.scc \
           file://poodle-kexecboot.cfg \
           file://qvga/logo_linux_clut224.ppm.bz2 \
           file://locomo_kbd_tweak-r2.patch \
           file://revert-check-on-console-device.patch \
           "

SRC_URI_append_spitz = " \
           file://spitz-tiny.scc \
           file://spitz-kexecboot.cfg \
           file://vga/logo_linux_clut224.ppm.bz2 \
           file://revert-check-on-console-device.patch \
           "

SRC_URI_append_tosa = " \
           file://tosa-tiny.scc \
           file://tosa-kexecboot.cfg \
           file://vga/logo_linux_clut224.ppm.bz2 \
           file://revert-check-on-console-device.patch \
           "

do_configure_prepend() {

    if [ -e ${WORKDIR}/logo_linux_clut224.ppm ]; then
        install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm ${WORKDIR}/linux/drivers/video/logo/logo_linux_clut224.ppm
    fi
}
