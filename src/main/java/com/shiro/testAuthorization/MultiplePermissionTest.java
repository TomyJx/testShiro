	package com.shiro.testAuthorization;

	import org.junit.Test;

	/**
	 * Created by 42070 on 2017/2/16.
	 */
	public class MultiplePermissionTest extends BaseTest {
		@Test
		public void testMultiplePermission(){
			login("classpath:testAuthorization/shiro-multiple-permission.ini","zhang","123");
			/**
			 * 当配置信息为seller=seller:sell,query:bb时，只有seller:sell:*可以被查到，
			 * 其他的不包括seller:sell,query:bb,跑debug的时候WildcardPermission解析的时候只传入的了seller:sell
			 * 所以seller:sell,query:bb相当于seller:sell:*
			 */
	//		getSubject().checkPermissions("seller:sell:bb");
	//		getSubject().checkPermissions("seller:sell:cc");
	//		getSubject().checkPermissions("seller:query:bb");
			getSubject().checkPermissions("seller:sell,query:bb");
	//		getSubject().checkPermissions("seller:*:bb");
	//		getSubject().checkPermissions("*:sell:bb");
			/**
			 * 当配置信息为buyer=buyer:buy:cc,dd,只有buyer:buy:cc可以被查到，其他的不行包括buyer:buy:cc,dd
			 */
	//		getSubject().checkPermissions("buyer:buy:cc");
	//		getSubject().checkPermissions("buyer:buy:dd");
	//		getSubject().checkPermissions("buyer:sell:dd");
	//		getSubject().checkPermissions("buyer:buy:cc,dd");
	//		getSubject().checkPermissions("buyer:buy:*");
	//		getSubject().checkPermissions("*:buy:*");
			/**
			 * 配置信息为player=player:play:basketball,player:play:football,player:play:pingbang
			 */
	//		getSubject().checkPermissions("player:play:basketball");
	//		getSubject().checkPermissions("player:play:football");
	//		getSubject().checkPermissions("player:play:pingbang");
	//		getSubject().checkPermissions("player:play:tennis");
			/**
			 * 配置信息为engineer=engineer:create:ee,engineer:delete:ee,engineer:update:ee,engineer:query:ee
			 */
	//		getSubject().checkPermissions("engineer:create:ee");
	//		getSubject().checkPermissions("engineer:delete:ee");
	//		getSubject().checkPermissions("engineer:update:ee");
	//		getSubject().checkPermissions("engineer:query:ee");
	//		getSubject().checkPermissions("engineer:truncate:ee");
			/**
			 * 配置信息为sayer=sayer:hello:*,这里检查配置信息sayer:hello:*是通过的
			 * 这种Permission：sayer:no:Lucy,Anne是不允许的
			 */
	//		getSubject().checkPermissions("sayer:hello:Lilei");
	//		getSubject().checkPermissions("sayer:hello:Hanmeimei");
	//		getSubject().checkPermissions("sayer:hello:*");
	//		getSubject().checkPermissions("sayer:no:*");
	//		getSubject().checkPermissions("sayer:no:Lucy,Anne");
			/**
			 * 配置信息为entrepreneur=entrepreneur:*:mayun,同样entrepreneur:*:mayun通过check
			 */
	//		getSubject().checkPermissions("entrepreneur:*:mayun");
	//		getSubject().checkPermissions("entrepreneur:buyYouKu:mayun");
	//		getSubject().checkPermissions("entrepreneur:buySina:mayun");
	//		getSubject().checkPermissions("entrepreneur:buyYouKu:mahuateng");
			/**
			 * 配置信息为computer=computer:*:lenovo:xiaoxin,此处的computer:*:lenovo:xiaoxin竟然是通过，
			 * 对于这个表达式现在也是不理解，目前理解资源为"联想中具体为小新型号的电脑可以做任何事"
			 */
	//		getSubject().checkPermissions("computer:*:lenovo:xiaoxin");
	//		getSubject().checkPermissions("computer:playGame:lenovo:xiaoxin");
			/**
			 * 配置信息为all=*这种配置与all=*:*一样，不过没人会用这个
			 */
	//		getSubject().checkPermissions("computer:*:lenovo:xiaoxin:aa");
	//		getSubject().checkPermissions("computer:*:lenovo:xiaoxin:aa:bb");
	//		getSubject().checkPermissions("computer:*:lenovo:xiaoxin:aa:bb:cc");
	//		getSubject().checkPermissions("aa");
		}
	}
