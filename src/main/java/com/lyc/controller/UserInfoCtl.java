package com.lyc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyc.entity.UserInfo;
import com.lyc.service.UserInfoService;
import com.lyc.util.JSONP;

/**
 *
 * @author  liyc
 * @date 2016年9月20日 下午2:58:35
*/
@Controller
@RequestMapping("userInfo")
public class UserInfoCtl {
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private UserInfoService userInfoService;
	/***
	 * 获取用户信息
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUserInfo")
	public JSONP<UserInfo> getUserInfo(@RequestParam(value="callback",required=false)String callback){
		logger.info("getUserInfo start");
		JSONP<UserInfo> jsonp=userInfoService.getUserInfo(callback);
		logger.info("getUserInfo end");
		return jsonp;
	}
	/***
	 * 登录
	 * @param callback
	 * @param mobile
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping("login")
	public JSONP<UserInfo> login(@RequestParam(value="callback",required=false)String callback,
			@RequestParam(value="mobile",required=true)String mobile,
			@RequestParam(value="password",required=true)String password){
		logger.info("login start");
		JSONP<UserInfo> jsonp=userInfoService.login(mobile,password,callback);
		logger.info("login end");
		return jsonp;
	}
	/***
	 * 退出登录
	 * @param callback
	 * @return
	 */
	@ResponseBody
	@RequestMapping("logout")
	public JSONP<String> logout(@RequestParam(value="callback",required=false)String callback){
		logger.info("logout start");
		JSONP<String> jsonp=userInfoService.logout(callback);
		logger.info("logout end");
		return jsonp;
	}
}
