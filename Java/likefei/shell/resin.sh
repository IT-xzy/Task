#! /bin/bash

# resin deploy

echo delete
cd /var/resin/webapps

rm -rf /task3

rm -f task3.war

echo deploy

cd

cd ..
cp task3.war /var/resin/webapps

echo restart

cd /usr/local/share/resin-4.0.43/bin

./resin.sh restart
