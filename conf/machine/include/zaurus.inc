########################
# Zaurus common settings
########################

IMAGE_FSTYPES ?= "tar.gz jffs2 jffs2.sum ubi ubifs"
JFFS2_SUM_EXTRA_ARGS = "-p -l -e ${JFFS2_ERASEBLOCK} -n"

INITRAMFS_FSTYPES ?= "cpio.gz cpio.xz"
IMAGE_DEVICE_TABLES = ""

#########
# xserver
#########

# Zaurus gets preferred providers settings
# from distro/include/default-providers.inc
XSERVER = "xserver-xorg xf86-video-fbdev xf86-input-keyboard xf86-input-mouse xf86-input-evdev xinput-calibrator"

########
# kernel
########

PREFERRED_PROVIDER_virtual/kernel = "linux-handheld"

# Default bootloader expects "zImage", use "uImage" for u-boot
# Note: kexecboot can boot both kind of images
KERNEL_IMAGETYPE ?= "zImage"

# sane defaults for devices with only 32Mb RAM (see man xz)
XZ_COMPRESSION_LEVEL = "-2e"

################
# machine tuning
################

SERIAL_CONSOLE = "115200 ttyS0"
SERIAL_CONSOLE_collie = "115200 ttySA0"


CMDLINE_akita = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1"
CMDLINE_c7x0 = "console=ttyS0,115200n8 console=tty1"
CMDLINE_collie = "console=ttySA0,115200n8 console=tty1 mem=64M fbcon=rotate:1"
CMDLINE_poodle = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1"
CMDLINE_spitz = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1"
CMDLINE_tosa = "console=ttyS0,115200n8 console=tty1"

MACHINE_FEATURES = "apm alsa pcmcia irda usbgadget keyboard touchscreen screen vfat ext2"
MACHINE_FEATURES_append_akita = " usbhost"
MACHINE_FEATURES_append_collie  = " qvga"
MACHINE_FEATURES_append_poodle  = " qvga"
MACHINE_FEATURES_append_spitz = " usbhost"
MACHINE_FEATURES_append_tosa  = " usbhost wifi"

MACHINE_EXTRA_RDEPENDS = "zaurusd mtd-utils mtd-utils-jffs2 mtd-utils-ubifs nandlogical"
MACHINE_EXTRA_RDEPENDS_collie = "zaurusd mtd-utils mtd-utils-jffs2 mtd-utils-ubifs"

BAD_RECOMMENDATIONS += "eudev-hwdb"

##################################
# Zaurus rootfs are booted by
# linux-kexecboot
##################################

# If set here, each image will also build linux-kexecboot and the updater
# EXTRA_IMAGEDEPENDS += "zaurus-installer"

# Install /boot/boot.cfg in target images and formfactor (psplash checks rotation)
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS_append = " kexecboot-cfg formfactor"

# Install kernel and symlink in /boot
MACHINE_ESSENTIAL_EXTRA_RDEPENDS_append = " kernel-base kernel-image"
