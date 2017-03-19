FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

do_install_prepend () {
	# provide machine-specific /etc/rotation for psplash
	sed -n 's/^[ \t]*DISPLAY_ORIENTATION[ \t]*//p' ${S}/machconfig | tr -dc '[0-9]' > ${S}/rotation
}

do_install_append () {
	# Only install file if it has a content
	if [ -s "${S}/rotation" ]; then
	install -d ${D}${sysconfdir}
	install -m 0644 ${S}/rotation ${D}${sysconfdir}/rotation
	fi
}
