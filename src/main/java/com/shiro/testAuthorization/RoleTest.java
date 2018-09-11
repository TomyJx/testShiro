package com.shiro.testAuthorization;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 42070 on 2017/2/16.
 */
public class RoleTest extends BaseTest {
	@Test
	public void testHasRole(){
		login("classpath:testAuthorization/shiro-role.ini","zhang","123");
		Assert.assertTrue(getSubject().hasRole("role1"));
		Assert.assertTrue(getSubject().hasAllRoles(Arrays.asList("role1","role2")));
		boolean[] booleans = getSubject().hasRoles(Arrays.asList("role1", "role2", "role3"));
		Assert.assertTrue(booleans[0]);
		Assert.assertTrue(booleans[1]);
		Assert.assertFalse(booleans[2]);
	}

	@Test(expected = UnauthorizedException.class)
	public void testCheckRole(){
		login("classpath:testAuthorization/shiro-role.ini","zhang","123");
		getSubject().checkRole("role1");
		getSubject().checkRoles("role1","role3");
	}
}
