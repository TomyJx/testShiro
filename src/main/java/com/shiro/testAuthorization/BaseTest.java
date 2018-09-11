package com.shiro.testAuthorization;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by 42070 on 2017/2/16.
 */
public class BaseTest {
	public void login(String configFile, String username, String password) {
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<SecurityManager> factory =
				new IniSecurityManagerFactory(configFile);

		//2、得到SecurityManager实例 并绑定给SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);

		subject.login(token);
	}

	public Subject getSubject(){
		return SecurityUtils.getSubject();
	}
}
