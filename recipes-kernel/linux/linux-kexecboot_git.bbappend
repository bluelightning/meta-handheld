FILESEXTRAPATHS_prepend := "${THISDIR}/linux-kexecboot-${PV}:${THISDIR}/files:"

DEFAULT_PREFERENCE = "-2"
#COMPATIBLE_MACHINE = "(akita|c7x0|collie|poodle|tosa|spitz)"
COMPATIBLE_MACHINE = "(spitz)"

# Note we set loglevel=3 and master console on serial to protect bootlogo.
CMDLINE_c7x0 = "console=tty1 console=ttyS0,115200n8"
CMDLINE_tosa = "console=tty1 console=ttyS0,115200n8"
CMDLINE_poodle = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1"
CMDLINE_akita = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1"
CMDLINE_collie = "console=tty1 console=ttySA0,115200n8 fbcon=rotate:1 mem=64M"
CMDLINE_spitz = "console=tty1 console=ttyS0,115200n8 fbcon=rotate:1"

# Zaurus machines need kernel size-check.
KERNEL_IMAGE_MAXSIZE_akita = "1294336"
KERNEL_IMAGE_MAXSIZE_c7x0 = "1294336"
KERNEL_IMAGE_MAXSIZE_collie = "1048576"
KERNEL_IMAGE_MAXSIZE_poodle = "1294336"
KERNEL_IMAGE_MAXSIZE_tosa = "1294336"
KERNEL_IMAGE_MAXSIZE_spitz = "1294336"

LOGO_SIZE ?= "."

SRC_URI += "file://defconfig \
           file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_collie = " \
                         file://0001-pcmcia-pxa2xx_sharpsl-retain-ops-structure-on-collie.patch \
                         file://locomo_kbd_tweak-r2.patch \
                         "

SRC_URI_append_poodle = " \
                         file://locomo_kbd_tweak-r2.patch \
                         "


