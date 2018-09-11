package com.shiro.testAuthorization;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by 42070 on 2017/2/17.
 */
public class MyRolePermissionResolver implements org.apache.shiro.authz.permission.RolePermissionResolver {
	@Override
	public Collection<Permission> resolvePermissionsInRole(String roleString) {
		if("role1".equals(roleString)) {
			return Arrays.asList((Permission)new WildcardPermission("menu:*"));
		}
		return null;
	}
}
