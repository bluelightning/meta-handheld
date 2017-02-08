require recipes-kernel/linux/linux-gcw0_${PV}.bb
SUMMARY = "GCW Zero kernel embedding a minimalistic kexecboot initramfs"

# disable packaging related tasks
inherit nopackages

PACKAGES = ""
PROVIDES = ""

KERNEL_IMAGE_BASE_NAME = "gcw0-kexecboot-${PV}-${MACHINE}"
KERNEL_IMAGE_SYMLINK_NAME = "gcw0-kexecboot-${MACHINE}"

# RAW for ubiboot
KERNEL_IMAGETYPE = "vmlinuz.bin"

INITRAMFS_IMAGE = "initramfs-kexecboot-klibc-image"
INITRAMFS_TASK = "${INITRAMFS_IMAGE}:do_image_complete"

# disable unneeded tasks
do_install[noexec] = "1"
