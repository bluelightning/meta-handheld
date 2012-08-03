########################
# Zaurus common settings
########################

IMAGE_FSTYPES ?= "tar.gz jffs2 sum.jffs2 ubifs"
INITRAMFS_FSTYPES ?= "cpio.gz cpio.lzma"
IMAGE_DEVICE_TABLES = ""

ERASEBLOCKSIZE = "0x4000"
ERASEBLOCKSIZE_akita = "0x20000"
ERASEBLOCKSIZE_spitz = "0x20000"

# Warning! SL-C3000 has "0x4000" (16MiB NAND) 
# C3100 and C3200 have same 128MiB NAND device as akita
#
# SL-C3000 (16-7 MiB = 576 PEBs)
# 9 x 1024 : 16 = 576 PEBs
# MKUBIFS_ARGS_spitz = "-m 512 -e 15872 -c 576 -x zlib"
# UBINIZE_ARGS_spitz = "-m 512 -p 16384 -s 256"
# ERASEBLOCKSIZE_spitz = "0x4000"

# UBI: max collie (14.125 = 113 PEBs)
# 14.125 x 1024 : 128 = 113 PEBs
MKUBIFS_ARGS_collie = "-m 2048 -e 129024 -c 113 -x zlib"
UBINIZE_ARGS_collie = "-m 2048 -p 131072 -s 512"

# UBI: max poodle (64-7 MiB = 3648 PEBs)
# 57 x 1024 : 16 = 3648 PEBs
MKUBIFS_ARGS_poodle = "-m 512 -e 15872 -c 3648 -x zlib"
UBINIZE_ARGS_poodle = "-m 512 -p 16384 -s 256"

# UBI: max c7x0 (128-7 MiB = 7744 PEBs)
# 121 x 1024 : 16 = 7744 PEBs
MKUBIFS_ARGS_c7x0 = "-m 512 -e 15872 -c 7744 -x zlib"
UBINIZE_ARGS_c7x0 = "-m 512 -p 16384 -s 256"

# UBI: max tosa (128-7 MiB = 7744 PEBs)
# 121 x 1024 : 16 = 7744 PEBs
MKUBIFS_ARGS_tosa = "-m 512 -e 15872 -c 7744 -x zlib"
UBINIZE_ARGS_tosa = "-m 512 -p 16384 -s 256"

# UBI: max akita (128-7 MiB = 968 PEBs)
# 121 x 1024 : 128 = 968 PEBs
MKUBIFS_ARGS_akita = "-m 2048 -e 129024 -c 968 -x zlib"
UBINIZE_ARGS_akita = "-m 2048 -p 131072 -s 512"

# UBI: max spitz (128-7 MiB = 968 PEBs)
# 121 x 1024 : 128 = 968 PEBs
MKUBIFS_ARGS_spitz = "-m 2048 -e 129024 -c 968 -x zlib"
UBINIZE_ARGS_spitz = "-m 2048 -p 131072 -s 512"

# kernel now supports favourlzo
EXTRA_IMAGECMD_jffs2 = "-p -l --eraseblock=${ERASEBLOCKSIZE}"
EXTRA_IMAGECMD_sum.jffs2 = "${EXTRA_IMAGECMD_jffs2}"

EXTRA_IMAGECMD_jffs2_collie = "--pad=14680064 --little-endian --eraseblock=0x20000 -n"
EXTRA_IMAGECMD_sum.jffs2_collie = "--pad -l --eraseblock=0x20000 -n"

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
XZ_COMPRESSION_LEVEL = "-2e"

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

# Install /boot/boot.cfg in target images and formfactor (psplash checks rotation)
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS_append = " kexecboot-cfg formfactor"

# Install kernel and symlink in /boot
MACHINE_ESSENTIAL_EXTRA_RDEPENDS_append = " kernel-base kernel-image"
