package com.shiro.testAuthentication;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by 42070 on 2017/2/15.
 * 自定义realm类
 */
public class MyRealm2 implements Realm {
	public String getName() {
		// 返回自定义的唯一的realm名称
		return "myRealm2";
	}

	public boolean supports(AuthenticationToken authenticationToken) {
		// 这里只支持用户名密码的token
		return authenticationToken instanceof UsernamePasswordToken;
	}

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String username = (String) authenticationToken.getPrincipal();
		String password = new String((char[]) authenticationToken.getCredentials());
		if (username == null || !"wang".equals(username.trim())) {
			throw new UnknownAccountException("未知用户!!!");
		}
		if (password == null || !"123".equals(password.trim())) {
			throw new IncorrectCredentialsException("密码错误");
		}
		return new SimpleAuthenticationInfo(username,password,getName());
	}
}
