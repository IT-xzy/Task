#encoding:utf-8
import re
import chardet

PATH_HOME =r"/usr/local/logs/log.log4j"


def read():
    with open(PATH_HOME,'r') as f:
        page = f.read()
        s = page.decode("gb2312").encode("utf-8")
    return s

def do_re(page):
    p1 = r"getallController耗时\(ms\)\:[0-9]+"#正则表达式规则
    #p1 = r"doSomeBusinessStuffDB耗时\(ms\)\:[0-9]+"
    pattern1 = re.compile(p1)#编译正则表达式
    all = pattern1.findall(page)
    return all

def index(all):
    a = []
    for i in all:
        num = i.split(":")
        p = num[-1]
        a.append(p)
    return a
    
if __name__ =='__main__':
    a=[]
    b=[]
    c=[]
    page = read()
    all = do_re(page)
    q = index(all)
    for i in q:
        if(0<int(i)<20):
            a.append(int(i))
        elif(20<=int(i)<50):
            b.append(int(i))              
        else:
            c.append(int(i))
    print u"Controller时间统计"      
    print u"小于20ms",len(a)
    print u"20-50ms",len(b)
    print u"大于50ms",len(c)
