require initramfs-kexecboot-image.bb

IMAGE_INSTALL = "kexecboot-klibc"

export IMAGE_BASENAME = "initramfs-kexecboot-klibc-image"
