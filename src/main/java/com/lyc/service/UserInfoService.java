package com.lyc.service;
/**
 *
 * @author  liyc
 * @date 2016年9月20日 下午2:55:52
*/

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyc.IDao.UserInfoDao;
import com.lyc.entity.UserInfo;
import com.lyc.util.Conf;
import com.lyc.util.JSONP;
import com.lyc.util.MD5Util;
import com.lyc.util.Profile;

@Service
public class UserInfoService {
	private Logger logger = Logger.getLogger(this.getClass());
	private Profile profile;
	@Autowired
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private Conf conf;
	/***
	 * 登录
	 * @param mobile
	 * @param password
	 * @param callback
	 * @return
	 */
	public JSONP<UserInfo> login(String mobile,String password,String callback){
		logger.info("login start ————"+conf.getStr("test"));
		UserInfo obj=userInfoDao.getUserByMobile(mobile);
		if(obj!=null){
			String p=MD5Util.Md5(password);
			if(!p.equals(obj.getPassword())){
				return new JSONP<UserInfo>(callback, "密码错误", false);
			}
			profile.setId(obj.getId());
			profile.setMobile(mobile);
		}else{
			return new JSONP<UserInfo>(callback, "无此用户", false);
		}
		JSONP<UserInfo> jsonp=new JSONP<UserInfo>(callback, "登录成功", true);
		jsonp.setCont(obj);
		logger.info("login end");
		return jsonp;
	}
	/***
	 * 获取用户信息
	 * @param callback
	 * @return
	 */
	public JSONP<UserInfo> getUserInfo(String callback){
		logger.info("getUserInfo start");
		if(profile.getId()<=0){
			return new JSONP<UserInfo>(callback, "未登录", false);
		}
		UserInfo obj=userInfoDao.getUserById(profile.getId());
		JSONP<UserInfo> jsonp=new JSONP<UserInfo>(callback, "加载成功", true);
		jsonp.setCont(obj);
		logger.info("getUserInfo end");
		return jsonp;
	}
	/***
	 * 退出登录
	 * @param callback
	 * @return
	 */
	public JSONP<String> logout(String callback){
		logger.info("logout start");
		profile.logout();
		JSONP<String> jsonp=new JSONP<String>(callback, "退出登录", true);
		logger.info("logout end");
		return jsonp;
	}
}
