#encoding:utf-8
import re

PATH_HOME =r"/usr/local/nginx/logs/myaccess.log"
HOME =r"C:\Users\Blue\Desktop\myaccess.log"

def readline():
    a = []
    with open(PATH_HOME,'r') as f:
        ngnix_f = f.readlines()
        for line in ngnix_f:
            a.append(line)
    return a

def response_time(list):
    g = {}
    for i in list:
        f = i.split()
        p = f[-1]
        if not p in g:
            g[p]=1
        else:
            g[p]=g[p]+1
    return g
    

if __name__ == '__main__':
    logs=readline()
    dic1 =  response_time(logs)
    print("访问次数"+ str(len(logs)))
    print(dic1)
