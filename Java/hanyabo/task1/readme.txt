项目1最终版本：
使用spring+mybatis
spring配置文件：applicationContext.xml,定义了dbcp2数据源，Mybatis的sqlsessionFactory(从Mybatis的配置文件生成),注册了
Mybatis的mapper扫描设置器，，以及自动扫描spring_mybatis.service包中的bean,实现service的自动载入。
mybatis-config:Mybatis的配置文件，指定了pojo对象别名


