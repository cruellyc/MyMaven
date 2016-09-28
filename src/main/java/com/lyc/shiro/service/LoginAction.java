package com.lyc.shiro.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author  liyc
 * @date 2016年9月28日 上午11:03:55
*/
@Controller("loginAction")
@RequestMapping("/login")
public class LoginAction {
	@RequestMapping("")
	// 登录
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response, String username,
			String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		// 记录该令牌
		token.setRememberMe(false);
		System.out.println("login");
		// subject权限对象
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (UnknownAccountException ex) {// 用户名没有找到
			System.out.println("用户名没有找到");
			ex.printStackTrace();
		} catch (IncorrectCredentialsException ex) {// 用户名密码不匹配
			System.out.println("用户名密码不匹配");
			ex.printStackTrace();
		} catch (AuthenticationException e) {// 其他的登录错误
			System.out.println("其他的登录错误");
			e.printStackTrace();
		}
		// 验证是否成功登录的方法
		if (subject.isAuthenticated()) {
			return new ModelAndView("../jsp/saveUserSuccess");
		}
		return new ModelAndView("../jsp/error");
	}

	// 退出
	@RequestMapping("/logout")
	public void logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}
}