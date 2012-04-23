########################
# Zaurus common settings
########################

ERASEBLOCKSIZE = "0x4000"
ERASEBLOCKSIZE_akita = "0x20000"

# Warning! SL-C3000 has "0x4000" (16MiB NAND) 
# C3100 and C3200 have same 128MiB NAND device as akita
ERASEBLOCKSIZE_spitz = "0x20000"

IMAGE_FSTYPES ?= "tar.gz jffs2 sum.jffs2"
INITRAMFS_FSTYPES ?= "cpio.gz cpio.lzma"

# kernel now supports favourlzo
EXTRA_IMAGECMD_jffs2 = "-p -l --eraseblock=${ERASEBLOCKSIZE}"
EXTRA_IMAGECMD_sum.jffs2 = "${EXTRA_IMAGECMD_jffs2}"

IMAGE_DEVICE_TABLES = ""

#########
# xserver
#########

PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg-lite"
PREFERRED_PROVIDER_virtual/xserver-xf86 = "xserver-xorg-lite"
XSERVER = "xserver-xorg-lite xf86-video-fbdev xf86-input-keyboard xf86-input-mouse xf86-input-evdev"
PREFERRED_PROVIDER_virtual/libgl = "mesa-xlib"

########
# kernel
########

PREFERRED_PROVIDER_virtual/kernel = "linux-yocto"

# Default bootloader expects "zImage", use "uImage" for u-boot
# Note: kexecboot can boot both kind of images
KERNEL_IMAGETYPE ?= "zImage"

# sane defaults for devices with only 32Mb RAM (see man xz)
XZ_COMPRESSION_LEVEL = "-e -7"

# kernel bootlogo
LOGO_SIZE = '${@base_conditional("MACHINE_GUI_CLASS", "bigscreen", "vga", "qvga", d)}'

################
# machine tuning
################

SERIAL_CONSOLE = "115200 ttyS0"
SERIAL_CONSOLE_collie = "115200 ttySA0"

PCMCIA_MANAGER ?= "pcmciautils"

CMDLINE_akita = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1"
CMDLINE_c7x0 = "console=ttyS0,115200n8 console=tty1"
CMDLINE_collie = "console=ttySA0,115200n8 console=tty1 mem=64M fbcon=rotate:1"
CMDLINE_poodle = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1"
CMDLINE_spitz = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1"
CMDLINE_tosa = "console=ttyS0,115200n8 console=tty1"

MACHINE_FEATURES = "apm alsa pcmcia irda usbgadget keyboard touchscreen screen vfat ext2"
MACHINE_FEATURES_append_akita = " usbhost"
MACHINE_FEATURES_append_spitz = " usbhost"
MACHINE_FEATURES_append_tosa  = " usbhost wifi "

MACHINE_EXTRA_RDEPENDS = "zaurusd mtd-utils nandlogical"
MACHINE_EXTRA_RDEPENDS_collie = "zaurusd"

##################################
# Zaurus rootfs are booted by
# linux-yocto-tiny-kexecboot
##################################

# If set here, each image will also build linux-yocto-tiny-kexecboot and the updater
# EXTRA_IMAGEDEPENDS += "zaurus-installer"

# Install /boot/boot.cfg in target images
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS_append = " kexecboot-cfg "

# Install kernel and symlink in /boot
MACHINE_ESSENTIAL_EXTRA_RDEPENDS_append = " kernel-base kernel-image "
