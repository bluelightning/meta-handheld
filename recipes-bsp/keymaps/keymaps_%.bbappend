FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:c7x0         = " file://keymap-2.6.map"
SRC_URI:append:tosa         = " file://keymap-2.6.map"
SRC_URI:append:akita        = " file://keymap-2.6.map"
SRC_URI:append:spitz        = " file://keymap-2.6.map"
SRC_URI:append:collie       = " file://keymap-2.6.map"
SRC_URI:append:poodle       = " file://keymap-2.6.map"
SRC_URI:append:hx4700       = " file://keymap-2.6.map"

# we still use keymap-2.6.map files
do_configure:append () {
    sed -i -e 's/KERNEL_MAJMIN=.*$/KERNEL_MAJMIN="2.6"/' ${WORKDIR}/keymap.sh
}

do_install:append () {
    case ${MACHINE} in
        c7x0 | tosa | akita | spitz | collie | poodle | hx4700 )
            install -d ${D}${sysconfdir}
            install -m 0644 ${WORKDIR}/keymap-*.map	${D}${sysconfdir}
            ;;
        *)
            ;;
    esac
}
