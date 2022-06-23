package com.tainan.controller;

import org.springframework.web.bind.annotation.RestController;

// POJO(Plain Old Java Object)
// 當作MVC中的Controller(控制器) 設定服務控制器
@RestController
public class HelloController {
	
	// 自訂建構子
	public HelloController() {
		System.out.println("程式執行中...");
	}

}
