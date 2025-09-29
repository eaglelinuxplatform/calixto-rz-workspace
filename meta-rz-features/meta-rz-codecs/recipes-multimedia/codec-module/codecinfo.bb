DESCRIPTION = "Application get codec information"
LICENSE = "CLOSED"

inherit autotools

do_compile[noexec] = "1"

PV="1.0.0"

SRC_URI = " \
        file://codecinfo-1.0.0.tar.gz "

S = "${WORKDIR}/codecinfo-${PV}"

do_install() {
    # Create destination directory
    install -d ${D}/${bindir}

    # Install application get codec pakage information
    install -m 755 ${S}/get_codec_information/codecinfo ${D}/${bindir}
}


FILES_${PN} += " \
    ${bindir}/codecinfo \
"

RDEPENDS_${PN}_append = "codec-user-module"

#To avoid already-stripped errors and not stripped libs from packages
INSANE_SKIP_${PN} += "already-stripped"

# Skip debug split and strip of do_package()
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
