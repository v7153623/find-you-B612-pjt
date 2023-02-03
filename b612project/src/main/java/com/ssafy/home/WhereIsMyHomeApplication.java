package com.ssafy.home;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ssafy")
@MapperScan(basePackages = {"com.ssafy.home.model.dao", "com.ssafy.user.model.dao", "com.ssafy.board.model.dao", "com.ssafy.qna.model.dao", "com.ssafy.answer.model.dao", "com.ssafy.news.model.dao"})
public class WhereIsMyHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhereIsMyHomeApplication.class, args);
	}

}