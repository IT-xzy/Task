#!/bin/bash

case $1 in 

resin)

name=/usr/local/resin/bin/resin.sh
   case $2 in
	start)
        $name start;;
	stop)
	$name stop;;
   esac;;
jetty)
name=/usr/local/jetty/bin/jetty.sh
   case $2 in
	start)
	$name start;;
	stop)
	$name stop;;
   esac;;
tomcat)
tomcatstart=/usr/local/tomcat-8.5/bin/startup.sh
tomcatstop=/usr/local/tomcat-8.5/bin/shutdown.sh
   case $2 in
	start)
	$tomcatstart;;
	stop)
	$tomcatstop;;
   esac;; 
esac

