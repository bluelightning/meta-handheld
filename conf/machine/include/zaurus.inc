########################
# Zaurus common settings
########################

IMAGE_FSTYPES ?= "tar.gz jffs2 jffs2.sum ubi ubifs"
IMAGE_FSTYPES:collie ?= "tar.gz jffs2 jffs2.sum"
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

ARM_INSTRUCTION_SET = "thumb"
ARM_INSTRUCTION_SET:collie = "arm"

SERIAL_CONSOLE = "115200 ttyS0"
SERIAL_CONSOLE:collie = "115200 ttySA0"

CMDLINE:akita = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1"
CMDLINE:c7x0 = "console=ttyS0,115200n8 console=tty1"
CMDLINE:collie = "console=ttySA0,115200n8 console=tty1 mem=64M fbcon=rotate:1"
CMDLINE:poodle = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1"
CMDLINE:spitz = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1"
CMDLINE:tosa = "console=ttyS0,115200n8 console=tty1"

MACHINE_FEATURES = "apm alsa pcmcia irda usbgadget keyboard touchscreen screen vfat ext2"
MACHINE_FEATURES:append:akita = " usbhost"
MACHINE_FEATURES:append:collie  = " qvga"
MACHINE_FEATURES:append:poodle  = " qvga"
MACHINE_FEATURES:append:spitz = " usbhost"
MACHINE_FEATURES:append:tosa  = " usbhost wifi"

MACHINE_EXTRA_RDEPENDS = "zaurusd mtd-utils mtd-utils-jffs2 mtd-utils-ubifs nandlogical"
MACHINE_EXTRA_RDEPENDS:collie = "zaurusd mtd-utils mtd-utils-jffs2 mtd-utils-ubifs"

BAD_RECOMMENDATIONS += "eudev-hwdb"

##################################
# Zaurus rootfs are booted by
# linux-kexecboot
##################################

# If set here, each image will also build linux-kexecboot and the updater
# EXTRA_IMAGEDEPENDS += "zaurus-installer"

# Install /boot/boot.cfg in target images and formfactor (psplash checks rotation)
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS:append = " kexecboot-cfg formfactor"

# Install kernel and symlink in /boot
MACHINE_ESSENTIAL_EXTRA_RDEPENDS:append = " kernel-base kernel-image"
