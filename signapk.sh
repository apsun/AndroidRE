#!/bin/sh
/usr/bin/java -jar "tools/signapk.jar" "tools/testkey.x509.pem" "tools/testkey.pk8" "$@"
