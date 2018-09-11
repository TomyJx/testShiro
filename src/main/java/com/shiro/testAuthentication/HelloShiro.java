package com.shiro.testAuthentication;

import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Created by 42070 on 2017/2/15.
 */
public class HelloShiro {
	@Test // 初始测试
	public void testHello(){
		// 1.获取securityManager工厂，此处是用shiro.ini配置文件初始化securityManager
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:testAuthentication/shiro.ini");
		// 2.得到securityManager实例并绑定到securityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		// 3.获取subject及创建用户名/密码身份验证token(即用户身份/凭证)
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		try {
			// 4.登录,进行身份验证
			subject.login(token);
		}catch (LockedAccountException e){
			// 账号已锁定需要先解锁后登录
		}catch (DisabledAccountException e){
			// 禁用的账号
		}catch (ExpiredCredentialsException e){
			// 过期的账号
		}catch (IncorrectCredentialsException e){
			// 凭证错误(一般直密码，还有其他的数字凭证等)
		}catch (UnknownAccountException e){
			// 无效的账号
		}catch (ExcessiveAttemptsException e){
			// 登录次数过多
		}catch (AuthenticationException e){
			// 5.登录失败
		}
		Assert.assertEquals(true,subject.isAuthenticated());

		// 6.用户退出
		subject.logout();
	}

	@Test // 自定义单个realm
	public void testCustomRealm(){
		// 1.获取securityManager工厂，此处是用shiro.ini配置文件初始化securityManager
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:testAuthentication/shiro-realms.ini");
		// 2.得到securityManager实例并绑定到securityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		// 3.获取subject及创建用户名/密码身份验证token(即用户身份/凭证)
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		try {
			// 4.登录,进行身份验证
			subject.login(token);
		}catch (LockedAccountException e){
			// 账号已锁定需要先解锁后登录
		}catch (DisabledAccountException e){
			// 禁用的账号
		}catch (ExpiredCredentialsException e){
			// 过期的账号
		}catch (IncorrectCredentialsException e){
			// 凭证错误(一般直密码，还有其他的数字凭证等)
		}catch (UnknownAccountException e){
			// 无效的账号
		}catch (ExcessiveAttemptsException e){
			// 登录次数过多
		}catch (AuthenticationException e){
			// 5.登录失败
		}
		Assert.assertEquals(true,subject.isAuthenticated());

		// 6.用户退出
		subject.logout();
	}

	@Test // 自定义的多个realm
	/**
	 *	注意：securityManager会按照realms指定的顺序进行身份认证。此处我们使用显示指定顺序的方式指定了Realm的顺序，
	 *	#如果删除“securityManager.realms=$myRealm1,$myRealm2”，那么securityManager会按照realm声明的顺序
	 *	#进行使用（即无需设置realms属性，其会自动发现），当我们显示指定realm后，其他没有指定realm将被忽略，
	 *	#如“securityManager.realms=$myRealm1”，那么myRealm2不会被自动设置进去。
	 */
	public void testCustomMutilRealm(){
		// 1.获取securityManager工厂，此处是用shiro.ini配置文件初始化securityManager
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:testAuthentication/shiro-mutil-realms.ini");
		// 2.得到securityManager实例并绑定到securityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		// 3.获取subject及创建用户名/密码身份验证token(即用户身份/凭证)
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("wang","123");
		PrincipalCollection principals = null;
		try {
			// 4.登录,进行身份验证
			subject.login(token);
			principals = subject.getPrincipals();
		}catch (LockedAccountException e){
			// 账号已锁定需要先解锁后登录
		}catch (DisabledAccountException e){
			// 禁用的账号
		}catch (ExpiredCredentialsException e){
			// 过期的账号
		}catch (IncorrectCredentialsException e){
			// 凭证错误(一般直密码，还有其他的数字凭证等)
		}catch (UnknownAccountException e){
			// 无效的账号
		}catch (ExcessiveAttemptsException e){
			// 登录次数过多
		}catch (AuthenticationException e){
			// 5.登录失败
		}
		Assert.assertEquals(true,subject.isAuthenticated());

		// 6.用户退出
		subject.logout();
	}

	@Test // jdbcrealm
	public void testJDBCRealm(){
		// 1.获取securityManager工厂，此处是用shiro.ini配置文件初始化securityManager
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:testAuthentication/shiro-jdbc-realms.ini");
		// 2.得到securityManager实例并绑定到securityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		// 3.获取subject及创建用户名/密码身份验证token(即用户身份/凭证)
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		try {
			// 4.登录,进行身份验证
			subject.login(token);
		}catch (LockedAccountException e){
			// 账号已锁定需要先解锁后登录
		}catch (DisabledAccountException e){
			// 禁用的账号
		}catch (ExpiredCredentialsException e){
			// 过期的账号
		}catch (IncorrectCredentialsException e){
			// 凭证错误(一般直密码，还有其他的数字凭证等)
		}catch (UnknownAccountException e){
			// 无效的账号
		}catch (ExcessiveAttemptsException e){
			// 登录次数过多
		}catch (AuthenticationException e){
			// 5.登录失败
		}
		Assert.assertEquals(true,subject.isAuthenticated());

		// 6.用户退出
		subject.logout();
	}

}
