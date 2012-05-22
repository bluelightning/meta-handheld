require linux.inc

PR = "${INC_PR}.0"
COMPATIBLE_MACHINE = "(hx4700)"

SRC_URI += "${KERNELORG_MIRROR}/linux/kernel/v3.x/linux-${PV}.tar.bz2;name=kernel \
           file://defconfig \
           file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 \
           "

SRC_URI_append_hx4700 = " \
                        file://0001-ARM-pxa-hx4700-Add-PCMCIA-CF-platform-device.patch \
                        file://0001-ARM-pxa-hx4700-Add-Synaptics-NavPoint-touchpad.patch \
                        file://0001-ARM-pxa-hx4700-Enable-ASIC3-GPIO-as-a-wakeup-source.patch \
                        file://0001-ARM-pxa-hx4700-Initialize-DS1WM-clock_rate.patch \
                        file://0001-input-Add-Synaptics-NavPoint-PXA27x-SSP-SPI-driver.patch \
                        file://0001-mfd-asic3-Avoid-unbalanced-irq-wakeup-enables-disabl.patch \
                        file://0001-mfd-asic3-Set-DS1WM-clock_rate.patch \
                        file://0001-pxa-hx4700-Add-standard-UART-to-hx4700_pin_config.patch \
                        file://0001-video-w100fb-Reduce-sleep-mode-battery-discharge.patch \
                        file://0002-ARM-pxa-hx4700-Add-PCMCIA-CF-support.patch \
                        file://0003-mfd-asic3-Add-PCMCIA-CF-support.patch \
                        file://suspend.patch \
                        "

SRC_URI[kernel.md5sum] = "146af0160fc7a60cf9acf44aec13482b"
SRC_URI[kernel.sha256sum] = "a797a15d0b6228381507c14ecf4eec4a6cc5c77cfd521ba3b3e1325e85b5b16d"
