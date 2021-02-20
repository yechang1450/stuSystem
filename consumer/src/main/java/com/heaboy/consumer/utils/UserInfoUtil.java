package com.heaboy.consumer.utils;


import com.heaboy.consumer.domain.UserDetail;
import com.heaboy.service.relation.entity.UserBind;
import com.heaboy.service.relation.service.IUserBindService;
import com.heaboy.service.sys.entity.SysUser;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Principal;

/**
 * @author heaboy
 * @date 2021年2月4日 11:04:32
 */
@Component
public class UserInfoUtil {

	@Reference
	private IUserBindService userBindService;

	/**
	 * 
	 * security 查询登陆用户
	 * 
	 * @return 登录者用户名
	 */
	public static String getCurrentUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		if (principal instanceof Principal) {
			return ((Principal) principal).getName();
		}
		return String.valueOf(principal);
	}

	/**
	 * 
	 * security 查询登陆用户
	 * 
	 * @return 登录者用户
	 */
	public static UserDetail getCurrentUser() {
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetail;
	}
	/**
	 *
	 * security 查询登陆用户
	 *
	 * @return 登录者用户id
	 */
	public static long getCurrentUserId() {
		long id = getCurrentUser().getId();
		return id;
	}

	/**
	 * 获得当前登录用户的学生账号或者教师账号
	 * @return
	 */
	public  String getUserNo() {
		long id = getCurrentUser().getId();
		 UserBind userBind = userBindService.findOneBySysUserId(id);
		return userBind.getUserNo();
	}

}
