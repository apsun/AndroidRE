#!/bin/sh
mydir=`dirname "$0"`
/usr/bin/java -jar "$mydir/tools/signapk.jar" "$mydir/tools/testkey.x509.pem" "$mydir/tools/testkey.pk8" "$@"
