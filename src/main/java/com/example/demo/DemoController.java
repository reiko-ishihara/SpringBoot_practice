package com.example.demo;

// import org.springframework.web.bind.annotation.PathVariable;	// 2-4で使用
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;	// 2-6
// なお、4.5行目は以下のように記述することもできる (2-6)
//	import org.springframework.web.bind.annotation.GetMapping;
//	import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;	// 2-6
// import org.springframework.web.bind.annotation.RestController;	// 2-2で使用
import org.springframework.stereotype.Controller;	// 2-3
//　import org.springframework.ui.Model;	// 2-4で使用
import org.springframework.web.servlet.ModelAndView;	// 2-5

// @RestController	 // このクラスがWEBアプリケーションとして操作できるコントローラプログラムとして動作できるようになる
@Controller
public class DemoController {	
//	@RequestMapping("/") 	   // リクエストを受けたときの処理を記述
							   // このプログラムの場合、"/"(ルート)にアクセスが来た場合の処理
	
//	@RequestMapping("/{num}")	// URLにnum(整数)を入れる						// 2-5
//	public String index(@PathVariable int num, Model model) {				// Modelクラスとは、Webページで使用するデータを管理するクラス
//	public ModelAndView index(@PathVariable int num, ModelAndView mav) {	// Modelは戻り値を持たないため、Viewから値が帰ってくる場合には
//		int sum = 0;															// ModelAndViewを使用する
//		for (int i = 0; i <= num; i++) {										// そのため、戻り値にはModelAndViewを設定する
//			sum += i;
//		}
//		model.addAttribute("msg", "sum=" + sum);	// addAttribute:第一引数で名前を、第二引数で値を設定する (2-4で使用)
												// view側で第一引数で指定した名前でデータを取り出す
//		mav.addObject("msg", "sum=" + sum);
//		mav.setViewName("index");	// ModelAndViewで返す場合は、html名をsetViewNameで指定する
//		// return "index";		// メソッド名と戻り値をindexにすると、templateフォルダ内のindex.htmlを読み込む (2-4まで使用)
//		return mav;
//	}
	
//	@GetMapping("/")	// 7行目の記述の場合はこのような記述になる
	@RequestMapping(value="/", method=RequestMethod.GET)	// ブラウザからURLを指定された場合にはGETで処理されるため、 (2-6)																
	public ModelAndView index(ModelAndView mav) {			// indexメソッドが処理される
		mav.setViewName("index");
		mav.addObject("msg", "お名前を入力してください");
		return mav;
	}
	
//	@PostMapping("/")	// 8行目の記述の場合はこのような記述になる
	@RequestMapping(value="/", method=RequestMethod.POST)	// HTMLから送信された場合はPOSTメソッドが送られてくるため、
	public ModelAndView send(								// sendメソッドが処理される
			@RequestParam("text1")String str,
			ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "こんにちは" + str + "さん！");
		mav.addObject("value", str);
		return mav;
	}

}
