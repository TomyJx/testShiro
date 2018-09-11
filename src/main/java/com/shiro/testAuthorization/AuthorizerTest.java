package com.shiro.testAuthorization;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 42070 on 2017/2/17.
 */
public class AuthorizerTest extends BaseTest{
	@Test
	public void testIsPermitted() {
		this.
		login(getClass().getResource("../../../") + "testAuthorization//shiro-authorizer.ini", "zhang", "123");
		//判断拥有权限：user:create
		Assert.assertTrue(getSubject().isPermitted("user1:update"));
		Assert.assertTrue(getSubject().isPermitted("user2:update"));
		//通过二进制位的方式表示权限
		Assert.assertTrue(getSubject().isPermitted("+user1+2"));//新增权限
		Assert.assertTrue(getSubject().isPermitted("+user1+8"));//查看权限
		Assert.assertTrue(getSubject().isPermitted("+user2+10"));//新增及查看

		Assert.assertFalse(getSubject().isPermitted("+user1+4"));//没有删除权限

		Assert.assertTrue(getSubject().isPermitted("menu:view"));//通过MyRolePermissionResolver解析得到的权限
	}

	public static void main(String[] args) {
		System.out.println(new AuthorizerTest().getClass().getResource("/").getFile().toString());
		System.out.println(new AuthorizerTest().getClass().getResource("").getFile().toString());
		System.out.println(new AuthorizerTest().getClass().getResource(".").getFile().toString());
		System.out.println(new AuthorizerTest().getClass().getResource("."));
	}
}
