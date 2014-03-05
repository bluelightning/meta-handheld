FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_c7x0         = " file://keymap-2.6.map"
SRC_URI_append_tosa         = " file://keymap-2.6.map"
SRC_URI_append_akita        = " file://keymap-2.6.map"
SRC_URI_append_spitz        = " file://keymap-2.6.map"
SRC_URI_append_collie       = " file://keymap-2.6.map"
SRC_URI_append_poodle       = " file://keymap-2.6.map"
SRC_URI_append_h2200        = " file://keymap-2.6.map"
SRC_URI_append_h4000        = " file://keymap-2.6.map"
SRC_URI_append_hx4700       = " file://keymap-2.6.map"

SRC_URI_append_jornada6xx   = " file://keymap-uk-620-660.map \
				file://keymap-dr_en.map \
				file://keymap-br.map \
				file://keymap-de.map \
				file://keymap-sp.map \
				file://keymap-uk.map \
				"

# we still use keymap-2.6.map files
do_configure_append () {
    sed -i -e 's/KERNEL_MAJMIN=.*$/KERNEL_MAJMIN="2.6"/' ${WORKDIR}/keymap.sh
}

do_install_append () {
    case ${MACHINE} in
        c7x0 | tosa | akita | spitz | collie | poodle | h2200 | h4000 | hx4700 | jornada6xx )
            install -m 0644 ${WORKDIR}/keymap-*.map	${D}${sysconfdir}
            ;;
        *)
            ;;
    esac
}
