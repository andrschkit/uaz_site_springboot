#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/uazProdServerRoot \
    target/Site_UAZ-1.0-SNAPSHOT.jar \
    root@87.239.29.132:/usr/local/host/

echo 'Restart server...'

ssh -i ~/.ssh/uazProdServerRoot root@87.239.29.132 /bin/bash << EOF

pgrep java | xargs kill -9
nohup java -jar /usr/local/host/Site_UAZ-1.0-SNAPSHOT.jar > log.txt 2>errLog.txt &

EOF

echo 'Bye'
read -p "Press Enter to continue" </dev/tty
