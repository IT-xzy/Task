#!/bin/sh
bd=$1
cd /usr/local/tomcat/apache-tomcat-8.5.32/bin
war=/data/My-home/autoDeploy/war/"$bd"
bin=/usr/local/tomcat/apache-tomcat-8.5.32/bin

if [ ! -n "${war}" ]; then
    echo "***Usage: $0 [project.war]"
    exit 0
fi
if [ ! -f "${war}" ]; then
    echo "***Error: ${war} does not exist."
    exit 0
fi
if [ ! "${war##*.}" = "war" ]; then
    echo "***Error: ${war} is not a war file."
    exit 0
fi

echo "Deploy ${war##*/}..."
rm -rf ${bin}/../webapps/ROOT/ && unzip -qo ${war} -d ${bin}/../webapps/ROOT/
rm -rf ${bin}/../work/Catalina/localhost/
echo "Restart tomcat..."
exec ${bin}/restart.sh