package com.j4ml.core;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import com.j4ml.dao.bean.SysUser;
import com.j4ml.service.admin.SysUserService;

public class MyRealm extends AuthorizingRealm{
	
	@Resource SysUserService sysUserService;

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
		MyUsernamePasswordToken userToken = (MyUsernamePasswordToken) token;
        String userName = userToken.getUsername();
        if (userName == null) {
            throw new AccountException();
        }
        
        SysUser sysUser = sysUserService.findSysUserByLoginName(userName);
        
        if(sysUser != null) {//用户用户名及密码验证
        		SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(sysUser.getSysUserName(),sysUser.getSysUserPwd(),getName());
        		//当前登录用户放入SESSION
        		Subject subjuct = SecurityUtils.getSubject();
        		subjuct.getSession().setAttribute("sysUser", sysUser);
        		//subjuct.getSession().setAttribute("lastLoginTime", sysUser.getLastLoginTime());
        		//用户名填盐
        		saInfo.setCredentialsSalt(ByteSource.Util.bytes(userName));
        		return saInfo;
        }
        return null;
	}
	


	
	
}
