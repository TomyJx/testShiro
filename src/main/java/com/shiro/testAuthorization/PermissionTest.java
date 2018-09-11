package com.shiro.testAuthorization;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 42070 on 2017/2/16.
 */
public class PermissionTest extends BaseTest {
	/**
	 * 在这里我自己遇到了一个问题，就是当Assert.assertFalse(getSubject().isPermitted("user:delete"));
	 * 执行到这句的时候就会抛出一个异常(java.lang.AssertionError: null)，这里没找到原因。需要以后查找
	 */
	@Test
	public void testIsPermitted(){
		login("classpath:testAuthorization/shiro-permission.ini","zhang","123");
		Assert.assertTrue(getSubject().isPermitted("user:create"));
		Assert.assertTrue(getSubject().isPermittedAll("user:create","user:update"));
		Assert.assertFalse(getSubject().isPermitted("user:view"));
		Assert.assertFalse(getSubject().isPermitted("user:delete"));
	}

	@Test(expected = UnauthorizedException.class)
	public void testCheckPermitted(){
		login("classpath:testAuthorization/shiro-permission.ini","zhang","123");
		getSubject().checkPermission("user:create");
		getSubject().checkPermissions("user:create","user:update");
		getSubject().checkPermission("user:delete");
	}
}
