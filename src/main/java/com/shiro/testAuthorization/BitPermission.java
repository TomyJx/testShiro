package com.shiro.testAuthorization;

import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.authz.Permission;

/**
 * Created by 42070 on 2017/2/17.
 */
public class BitPermission implements Permission {
	private String resourceIdentify;
	private int permissionBit;
	private String instanceId;
	public BitPermission(String permissionString) {
		String[] array = permissionString.split("\\+");
		if(array.length > 1) {
			resourceIdentify = array[1];
		}
		if(StringUtils.isEmpty(resourceIdentify)) {
			resourceIdentify = "*";
		}
		if(array.length > 2) {
			permissionBit = Integer.valueOf(array[2]);
		}
		if(array.length > 3) {
			instanceId = array[3];
		}
		if(StringUtils.isEmpty(instanceId)) {
			instanceId = "*";
		}
	}

	@Override
	public boolean implies(Permission p) {
		if(!(p instanceof BitPermission)) {
			return false;
		}
		BitPermission other = (BitPermission) p;
		if(!("*".equals(this.resourceIdentify) || this.resourceIdentify.equals(other.resourceIdentify))) {
			return false;
		}
		if(!(this.permissionBit ==0 || (this.permissionBit & other.permissionBit) != 0)) {
			return false;
		}
		if(!("*".equals(this.instanceId) || this.instanceId.equals(other.instanceId))) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "+1";
		String[] array = str.split("\\+");
		System.out.println(array.length);
		for (int i = 0; i < array.length; i++) {
			System.out.print("----------");
			System.out.print(array[i]);
		}
	}
}
