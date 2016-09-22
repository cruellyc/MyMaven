package com.lyc.IDao;
/**
 *
 * @author  liyc
 * @date 2016年9月20日 下午2:48:56
*/

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lyc.entity.UserInfo;

@Repository
public interface UserInfoDao {
	public UserInfo getUserByMobile(@Param("mobile")String mobile);
	public UserInfo getUserById(@Param("id")int id);
}
