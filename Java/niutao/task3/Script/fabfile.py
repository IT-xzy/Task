#!/usr/bin/env python
# -*- coding: utf-8 -*-

from fabric.api import *

env.port = '22'
env.user = 'root'
env.password ='N{f63hvCkX3bQzU['

TOMCAT_PATH = '/root/apache-tomcat-8.5.24/webapps'
PAGE_NAME = 'springmvcdemo-1.0-SNAPSHOT'
PATH_WAR = r'C:\Users\Blue\Desktop\project\task2\springmvcdemo\target'
WAR_NAME = 'springmvcdemo-1.0-SNAPSHOT.war'

@hosts(['207.148.67.85'])
def packege():
    #删除服务器上原来的项目
    with cd('/usr/local'):
        run('rm -f {}'.format(WAR_NAME))
        run('rm -rf {}'.format(PAGE_NAME))
    #传本地war包到服务器
    with lcd(PATH_WAR):
        put(WAR_NAME,TOMCAT_PATH)
        
@hosts(['207.148.67.85'])
def start():
    #启动tomcat
    with cd('/root/apache-tomcat-8.5.24/bin'):
        run('./startup.sh',pty=False)
    #启动nginx
    run('/usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf')
        
@hosts(['207.148.67.85'])
def end():
    #关闭nginx
    run('killall -9 nginx')
    #关闭tomcat
    with cd('/root/apache-tomcat-8.5.24/bin'):
        run('set -m;./shutdown.sh')


