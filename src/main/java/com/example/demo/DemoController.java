package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;	// 2-2で使用
import org.springframework.stereotype.Controller;

// @RestController	 // このクラスがWEBアプリケーションとして操作できるコントローラプログラムとして動作できるようになる
@Controller
public class DemoController {	
	@RequestMapping("/")  // リクエストを受けたときの処理を記述
							  // このプログラムの場合、"/"(ルート)にアクセスが来た場合の処理
	public String index() {
		return "index";
	}

}
