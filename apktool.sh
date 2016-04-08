#!/bin/sh
mydir=`dirname "$0"`
/usr/bin/java -jar "$mydir/tools/apktool.jar" "$@"
