#!/usr/bin/bash
eval "$(ssh-agent -s)"
ssh-add /root/mykey.txt
cd /root/javaserver/java-server
git pull --rebase