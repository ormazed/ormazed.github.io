#!/bin/bash
source ~/.bashrc
nvm use v6.17.1
cd /home/lena/gitbook/gb
gitbook build
cp -R /home/lena/gitbook/gb/_book/* /home/lena/gitbook/gb
git clean -fx /home/lena/gitbook/gb/_book
git add /home/lena/gitbook/gb
git commit -m "gitbook update"
git push origin master

## orignal : https://co1nam.tistory.com/48
~                                              
