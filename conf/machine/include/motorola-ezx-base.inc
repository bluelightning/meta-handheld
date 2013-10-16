#
# Hardware-based properties
#

require conf/machine/include/tune-xscale.inc

MACHINE_FEATURES = "alsa apm bluetooth keyboard phone screen touchscreen usbgadget usbhost vfat qvga"
MACHINE_FEATURES += " iwmmxt"

PACKAGE_EXTRA_ARCHS_tune-xscale += "iwmmxt"

#cat /proc/mtd
#dev:    size   erasesize  name
#mtd0: 00020000 00008000 "Bootloader"
#mtd1: 000e0000 00020000 "Kernel"
#mtd2: 00580000 00020000 "VFM_Filesystem"
#mtd3: 00020000 00020000 "Logo"

MACHINE_GUI_CLASS = "smallscreen"
MACHINE_DISPLAY_WIDTH_PIXELS = "240"
MACHINE_DISPLAY_HEIGHT_PIXELS = "320"

#
# Software/packages selection
#
PREFERRED_PROVIDER_virtual/kernel ?= "openezx-kernel"

IMAGE_FSTYPES ?= "jffs2"
JFFS2_ERASEBLOCK = "0x20000"
EXTRA_IMAGECMD_jffs2 = "--pad=14680064 --little-endian --eraseblock=${JFFS2_ERASEBLOCK}"

# In order to enable UIBIFS add "uibi and ubifs"
#IMAGE_FSTYPES += "ubi ubifs"

# From dmesg:
# UBI: smallest flash I/O unit:    1
# UBI: logical eraseblock size:    131072 bytes
# from ubiattach stdout:
# UBI device number 0, total 1996 LEBs
MKUBIFS_ARGS = "-m 1 -e 130944 -c 487"

# from dmesg:
# UBI: smallest flash I/O unit:    1
# UBI: physical eraseblock size:   131072 bytes (128 KiB)
# UBI: sub-page size:              512
UBINIZE_ARGS = "-m 1 -p 128KiB "


EXTRA_IMAGEDEPENDS += "moto-boot-usb-native ezx-gen-blob"

IMAGE_INSTALL_append += "\
  kernel-module-ohci-hcd \
  kernel-module-moto-usb-ipc \
  kernel-module-ts27010mux \
"

# Ezxd needs to be started very early so we need the mux devices in static /dev
IMAGE_DEVICE_TABLES = "files/device_table-minimal.txt \
                       files/device_table-ezx.txt"

SERIAL_CONSOLE = "115200 ttyS0"
