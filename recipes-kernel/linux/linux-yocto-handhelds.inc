KMACHINE_akita = "akita"
KMACHINE_c7x0 = "c7x0"
KMACHINE_collie = "collie"
KMACHINE_poodle = "poodle"
KMACHINE_spitz = "spitz"
KMACHINE_tosa = "tosa"

SRC_URI_append_akita = " \
           file://feature-top.scc \
           file://vga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_c7x0 = " \
           file://feature-top.scc \
           file://vga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_collie = " \
           file://feature-top.scc \
           file://qvga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_poodle = " \
           file://feature-top.scc \
           file://qvga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_spitz = " \
           file://feature-top.scc \
           file://vga/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_tosa = " \
           file://feature-top.scc \
           file://vga/logo_linux_clut224.ppm.bz2 \
           "

do_configure_prepend() {

    if [ -e ${WORKDIR}/logo_linux_clut224.ppm ]; then
        install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm ${WORKDIR}/linux/drivers/video/logo/logo_linux_clut224.ppm
    fi
}
