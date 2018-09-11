package com.shiro.testAuthorization;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * Created by 42070 on 2017/2/17.
 */
public class BitAndWildPermissionResolver implements PermissionResolver {
	@Override
	public Permission resolvePermission(String permissionString) {
		if(permissionString.startsWith("+")) {
			return new BitPermission(permissionString);
		}
		return new WildcardPermission(permissionString);
	}
}
