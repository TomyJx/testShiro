package com.shiro.testAuthorization;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by 42070 on 2017/2/16.
 */
public class MyRealm extends AuthorizingRealm {
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addRole("role1");
		authorizationInfo.addRole("role2");
		authorizationInfo.addObjectPermission(new BitPermission("+user1+10"));
		authorizationInfo.addObjectPermission(new WildcardPermission("user1:*"));
		authorizationInfo.addStringPermission("+user2+10");
		authorizationInfo.addStringPermission("user2:*");
		return authorizationInfo;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String username = (String) authenticationToken.getPrincipal();
		String password = new String((char[]) authenticationToken.getCredentials());
		if (username == null || !"zhang".equals(username.trim())) {
			throw new UnknownAccountException("未知用户!!!");
		}
		if (password == null || !"123".equals(password.trim())) {
			throw new IncorrectCredentialsException("密码错误");
		}
		return new SimpleAuthenticationInfo(username,password,getName());
	}
}
