DESCRIPTION = "User-space keyboard daemon for external keyboards"
HOMEPAGE = "http://projects.linuxtogo.org/projects/kbdd"
SECTION = "console/utils"
DEPENDS = "virtual/kernel"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRCREV = "8"
PV = "0.12+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://projects.linuxtogo.org/svn/kbdd;module=trunk;protocol=svn \
           file://nostrip.patch \
           file://kbdd.init \
           file://kbdd.conf \
           file://kbdd-modules"
S = "${WORKDIR}/trunk"

inherit update-rc.d

do_compile() {
	oe_runmake CFLAGS="${CFLAGS} -DVERSION=\\\"${PV}\\\""
}

do_install() {
	install -d ${D}${sbindir}
	install -d ${D}${docdir}/kbdd/
	install -m 0755 kbdd ${D}${sbindir}/
	install -m 0644 README ${D}${docdir}/kbdd/
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/kbdd.conf ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/kbdd.init ${D}${sysconfdir}/init.d/kbdd
	install -d ${D}${sysconfdir}/modutils
	install -m 0644 ${WORKDIR}/kbdd-modules ${D}${sysconfdir}/modutils/
}

pkg_postinst_${PN} () {
	update-modules
}

pkg_postrm_${PN} () {
	update-modules
}

INITSCRIPT_NAME = "kbdd"
INITSCRIPT_PARAMS = "defaults"

RRECOMMENDS_${PN} = "kernel-module-keybdev kernel-module-uinput"
