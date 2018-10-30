<h2>任务6的项目结构和内容与任务5类似，毕竟是在任务5基础上增加使用缓存，不过我的任务6重新采用SSM框架</h2>
<h4>service层的cache文件夹是新添内容，主要存放redis和memcached缓存工具类、通用接口以及简单的实现逻辑；</h4>
<h4>关于xml文件的配置可以参见main层级resources文件夹里内容；</h4>
<h4>aspect文件夹是aop日志记录类，记录controller层所有操作。至于if分支的日志信息，还是在代码中使用logger;；</h4>
<h4>controller文件夹是controller层代码;</h4>
<h4>interceptor文件夹存放自定义拦截器;</h4>
<h4>util文件夹存放封装的各种工具类，比如正则、DES加密、Token工具类等;</h4>
