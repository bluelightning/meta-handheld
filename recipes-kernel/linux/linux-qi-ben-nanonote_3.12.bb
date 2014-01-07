DESCRIPTION = "Linux kernel 3.12 for the Ben Nanonote"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

DEPENDS += "u-boot-mkimage-native"

SRCREV = "${AUTOREV}"

DEFAULT_PREFERENCE_ben-nanonote = "1"
COMPATIBLE_MACHINE = "ben-nanonote"

KERNEL_IMAGETYPE = "vmlinux.bin"

SRC_URI = "git://projects.qi-hardware.com/qi-kernel.git;protocol=git;branch=jz-3.12"

S = "${WORKDIR}/git"

inherit kernel

FILES_kernel-image = "/boot/uImage*"

do_configure_prepend() {
	install -m 0644 ${S}/arch/mips/configs/qi_lb60_defconfig ${S}/.config
}

do_install_append() {
	cd ${S}
	kernel_entry=`nm vmlinux | grep " kernel_entry" | cut -d' ' -f1`

	cd ${S}/arch/mips/boot
	rm -f vmlinux.bin.gz
	gzip -c9 vmlinux.bin > vmlinux.bin.gz

	mkimage -A mips -O linux -T kernel -C gzip -a 0x80010000 -e 0x${kernel_entry} \
	-n 'MIPS' -d vmlinux.bin.gz uImage-${KERNEL_VERSION}

	install -m 0644 uImage-${KERNEL_VERSION} ${D}/boot
}

pkg_postinst_kernel() {
	cd /${KERNEL_IMAGEDEST}; update-alternatives --install /${KERNEL_IMAGEDEST}/uImage uImage uImage-${KERNEL_VERSION} ${KERNEL_PRIORITY} || true
}

pkg_postrm_kernel() {
	cd /${KERNEL_IMAGEDEST}; update-alternatives --remove uImage uImage-${KERNEL_VERSION} || true
}
