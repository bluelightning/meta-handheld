FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:${THISDIR}/files:"

COMPATIBLE_MACHINE .= "|akita|c7x0|collie|poodle|spitz|tosa"

KMACHINE_akita = "akita"
KMACHINE_c7x0 = "c7x0"
KMACHINE_collie = "collie"
KMACHINE_poodle = "poodle"
KMACHINE_spitz = "spitz"
KMACHINE_tosa = "tosa"

SRC_URI_append_akita = " \
           file://akita-standard.scc \
           file://akita.cfg \
           file://vga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_c7x0 = " \
           file://c7x0-standard.scc \
           file://c7x0.cfg \
           file://vga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_collie = " \
           file://collie-standard.scc \
           file://collie.cfg \
           file://qvga/logo_linux_clut224.ppm.bz2 \
           file://0001-pcmcia-pxa2xx_sharpsl-retain-ops-structure-on-collie.patch \
           file://collie_remove_irq_to_gpio.patch \
           file://locomo_kbd_tweak-r2.patch \
           "

SRC_URI_append_poodle = " \
           file://poodle-standard.scc \
           file://poodle.cfg \
           file://qvga/logo_linux_clut224.ppm.bz2 \
           file://locomo_kbd_tweak-r2.patch \
           "

SRC_URI_append_spitz = " \
           file://spitz-standard.scc \
           file://spitz.cfg \
           file://vga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_tosa = " \
           file://tosa-standard.scc \
           file://tosa.cfg \
           file://vga/logo_linux_clut224.ppm.bz2 \
           "

do_configure_prepend() {

    if [ -e ${WORKDIR}/logo_linux_clut224.ppm ]; then
        install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm ${WORKDIR}/linux/drivers/video/logo/logo_linux_clut224.ppm
    fi
}
