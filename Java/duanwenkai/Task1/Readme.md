1.Task1使用测试方法较多，并且没有很好的分开它们，所以比较杂乱。
2.测试Spring整合mybatis时使用的是注解。运行时请为service层加上注解，放开注释掉的注解。
3.测试Druid连接池同上，放开注解的注释，加上service注解。
4.测试JDBCTemplate和基础的MyBatis使用的是读取配置文件，运行时请取消注解。
5.Main方法使用的是读取配置文件，运行时请取消注解。
6.如果需要在服务器上运行，请将package之后的targetlib文件夹改成lib。