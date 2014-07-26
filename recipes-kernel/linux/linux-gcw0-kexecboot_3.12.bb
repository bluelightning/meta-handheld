require recipes-kernel/linux/linux-gcw0_3.12.bb
SUMMARY = "GCW Zero kernel embedding a minimalistic kexecboot initramfs"

PACKAGES = ""
PROVIDES = ""

KERNEL_IMAGE_BASE_NAME = "${KERNEL_IMAGETYPE}-gcw0-kexecboot-${PV}-${MACHINE}"
KERNEL_IMAGE_SYMLINK_NAME = "${KERNEL_IMAGETYPE}-gcw0-kexecboot-${MACHINE}"

# RAW for ubiboot
KERNEL_IMAGETYPE = "vmlinuz.bin"

INITRAMFS_IMAGE = "initramfs-kexecboot-klibc-image"
INITRAMFS_TASK = "${INITRAMFS_IMAGE}:do_rootfs"

# disable unneeded tasks
do_install[noexec] = "1"
do_package[noexec] = "1"
do_package_qa[noexec] = "1"
do_packagedata[noexec] = "1"
do_package_deb[noexec] = "1"
do_package_ipk[noexec] = "1"
do_package_rpm[noexec] = "1"
do_package_tar[noexec] = "1"
do_package_write_deb[noexec] = "1"
do_package_write_ipk[noexec] = "1"
do_package_write_rpm[noexec] = "1"
do_package_write_tar[noexec] = "1"
do_populate_sysroot[noexec] = "1"
