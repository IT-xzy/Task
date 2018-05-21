# Task汇总
> [Task汇总地址](https://it-xzy.github.io/Task/index.html)

# 文件上传方法
## 1.网页上传
### 使用修真院学员公共账号登陆github，找到Task项目库，根据自己的职业选择相应的文件夹。<br>
* 如果已经存在自己的文件夹，那么直接`拖拽文件`或点击`Upload Files`上传即可。<br>
* 如果没有自己的文件夹，可以通过`拖拽文件`或点击`Upload Files`上传文件夹，也可以通过点击`Create new file`来创建新的文件夹，在名称后加上`/`
即可创建新的文件夹。<br>
#### 注意：github不能管理空文件夹，新建文件夹内一定要有文件，所以通过上述方法上传或者新建文件夹时要注意。<br>
## 2.客户端上传
### 下载 [github桌面版](https://desktop.github.com)，点击客户端内的`File`→`Options`，使用公共账号登陆后，点击`File`→`Clone repositor..`，在项目中找到 ptteng/Task，克隆到本地后找到Task的文件夹，在职业目录内(Web或Java)新建或者更新自己的文件夹。新增内容后客户端会有提示，点击`Commit to master`→`Pull origin`。
#### 注意：不要在别人的文件夹里操作，否则上传时候可能会覆盖别人的文件。
## 3.通过Git命令上传
### 原理和客户端上传一样，都是通过克隆项目到本地然后上传文件到远程仓库，由于操作比客户端麻烦，过程不再赘述，[Git命令克隆项目](https://www.cnblogs.com/cxk1995/p/5800196.html)
## 4.通过SSH Key密钥上传本地项目
### 这个也稍微有点麻烦，有兴趣的可以研究下 [GIT上传本地项目](https://www.cnblogs.com/chengxs/p/6297659.html)


#### 以上四种推荐第一种，简单粗暴，缺点就是有时候git的服务器链接不上，要多试几次，另外三种开始会很方便，后来内容越来越多导致其他人第一次克隆项目会非常慢。

