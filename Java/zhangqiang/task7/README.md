# task7

***optimize***
主项目

>更新内容：
list修改，添加上传图片
手机注册/邮箱注册

***osimpt***
第三方迁移测试

短信需第三方jar包：

>需要手动导入，通过maven添加
mvn install:install-file -Dfile=D:\Maven\Repository\CCP_REST_SMS_SDK_JAVA_v2.6.3r.jar  -DgroupId=com.cloopen -DartifactId=cloopen-rest-sdk -Dversion=2.6.3

```
<!--荣联 短信发送-->
    <dependency>
      <groupId>com.cloopen</groupId>
      <artifactId>cloopen-rest-sdk</artifactId>
      <version>2.6.3</version>
    </dependency>
```
