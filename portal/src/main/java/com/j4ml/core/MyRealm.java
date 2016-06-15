package com.j4ml.core;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm{

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/*Subject subjuct = SecurityUtils.getSubject();
		UserInfo userInfo = (UserInfo) subjuct.getSession().getAttribute("userInfo");
		if("fmcgadministrator".equals(userInfo.getLoginName()) && SYSTEM_TYPE.OMS.equals(userInfo.getUserSystem())){
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
            info.addStringPermission("User:administrator");  
            info.addStringPermission("/sys/**");
            return info;
		}*/
		return null;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		/*MyUsernamePasswordToken userToken = (MyUsernamePasswordToken) token;
        String userName = userToken.getUsername();
        if (userName == null) {
            throw new AccountException();
        }
        
        UserInfo userInfo = realmService.findByLoginName(userName);
        
        if(userInfo != null) {//用户用户名及密码验证
        	if(SYSTEM_TYPE.FMCG.equals(userInfo.getUserSystem()) || SYSTEM_TYPE.OMS.equals(userInfo.getUserSystem())){ //帐号所属系统为企业销售平台
        		SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(userInfo.getLoginName(),userInfo.getLoginPwd(),getName());
        		//当前登录用户放入SESSION
        		Subject subjuct = SecurityUtils.getSubject();
        		subjuct.getSession().setAttribute("userInfo", userInfo);
        		subjuct.getSession().setAttribute("lastLoginTime", userInfo.getLastLoginTime());
        		userInfo.setLastLoginTime(new Date());
        		realmService.updateUserInfo(userInfo);
        		//用用户名填盐
        		saInfo.setCredentialsSalt(ByteSource.Util.bytes(userName));
        		return saInfo;
        	}else{
        		throw new AuthenticationException();
        	}
        }*/
        return null;
	}
	


	
	
}
