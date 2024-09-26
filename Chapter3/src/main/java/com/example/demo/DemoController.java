package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.UserRepository;
import javax.annotation.PostConstruct;



@Controller
public class DemoController {
	
	@Autowired	// 他のクラスを使えるようにしてくれるもの、わざわざnewしなくて良い
	UserRepository repos;	// JpaRepositoryを継承しているため、データベース操作ができるようになる
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(
			@ModelAttribute("formModel") User user,		// このアノテーションがついたメソッドの返り値は、自動でModelに追加される
			ModelAndView mav) {
		mav.setViewName("index");
		Iterable<User> list = repos.findAll();	// Iterableインタフェース：オブジェクトを[for-each]文の対象にすることができる
		mav.addObject("data", list);
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	@Transactional(readOnly=false)		// ロールバックする処理、今回の場合は読み取りのみはfalseとなりロールバックされる
	public ModelAndView form(
			@ModelAttribute("formModel") User user,
			ModelAndView mav) {
		repos.saveAndFlush(user);	// 引数のエンティティを保存し、データベースへ反映させる
		return new ModelAndView("redirect:/");
	}
	
	@PostConstruct
	public void init() {
		// 初期データ作成
		User user1 = new User();
		user1.setName("島根 花子");
		repos.saveAndFlush(user1);
		
		user1 = new User();
		user1.setName("大阪 太郎");
		repos.saveAndFlush(user1);
	}

}
