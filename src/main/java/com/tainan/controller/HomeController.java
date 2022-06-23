package com.tainan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 控制畫面MVC
@Controller
public class HomeController {

	// 方法 as Action
	@GetMapping("/") //根目錄
	public String home() {
		// 調用一個View Page(使用thymeleaf 預設為xxx.html)
		return "index";
	}
	
	// 登入畫面
	@GetMapping("/login")
	public String login() {
		// 調用一個View Page(使用thymeleaf 預設為xxx.html)
		return "login";
	}
	
	// 登入成功 //沒用到
	@GetMapping("/member")
	public String member() {
		// 調用一個View Page(使用thymeleaf 預設為xxx.html)
		return "member";
	}
	
	// 填寫註冊會員資料
	@GetMapping("/signup")
	public String signup() {
		// 調用一個View Page(使用thymeleaf 預設為xxx.html)
		return "signup";
	}
	
	//---測試多選頁面---//
	@GetMapping("/test2") 
	public String test2()
	{
		return "test2";
	}

	
	
}
