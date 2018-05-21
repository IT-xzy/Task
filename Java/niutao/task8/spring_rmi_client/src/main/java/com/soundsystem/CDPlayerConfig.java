package com.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration   //申明配置类
@ComponentScan   //启用组件扫描，默认路径为本包。 <context:component-scan base-package="soundsystem">
public class CDPlayerConfig {
}
