#!/usr/bin/env bash
src_root=~/dev/BoltGenerator/results
dest_root=./src/main/java/com/lenny/surveyingDB

# echo $src_root $dest_root

if ! [[ -d $dest_root/adapters ]]; then
    mkdir $dest_root/adapters
fi
rm -r $dest_root/adapters/*.java
cp -t $dest_root/adapters $src_root/classes/*.java

if ! [[ -d $dest_root/interfaces ]]; then
    mkdir $dest_root/interfaces
fi
rm -r $dest_root/interfaces/*.java
cp -t $dest_root/interfaces $src_root/interfaces/*.java

if ! [[ -d $dest_root/webAPI ]]; then
    mkdir $dest_root/webAPI
fi
rm -r $dest_root/webAPI/*.java
cp -t $dest_root/webAPI $src_root/handlers/*.java

