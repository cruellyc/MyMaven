package com.lyc.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author  liyc
 * @date 2016年9月19日 下午4:59:35
*/
@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserAction {
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView save(String name, String password) {
		System.out.println("接收到的用户信息：" + name);

		ModelAndView mov = new ModelAndView();
		mov.setViewName("../jsp/saveUserSuccess");
		mov.addObject("msg", "保存成功了");

		return mov;
	}
}
