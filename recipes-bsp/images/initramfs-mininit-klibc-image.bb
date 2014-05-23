SUMMARY = "Initramfs image for mininit kernel"
DESCRIPTION = "This image provides mininit (helper for booting loop images)."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"

# avoid circular dependencies
EXTRA_IMAGEDEPENDS = ""

# We only need mininit static
IMAGE_INSTALL = "mininit-klibc"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = ""

IMAGE_LINGUAS = ""

FEED_DEPLOYDIR_BASE_URI = ""
LDCONFIGDEPEND = ""

inherit image
