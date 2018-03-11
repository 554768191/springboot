package org.demo.spring;

import org.demo.spring.core.weixin.MenuManager;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("org.demo.spring.dao")
public class Application {
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		MenuManager menuManager = new MenuManager();
		logger.info("menuManager.initMenu start");
		menuManager.initMenu();
		logger.info("menuManager.initMenu finsh");

	}
}
