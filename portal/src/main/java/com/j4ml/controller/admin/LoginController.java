package com.j4ml.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.j4ml.core.MyUsernamePasswordToken;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
	@RequestMapping("/login")
	public String loginPage(){
		return "admin/login";
	}
	
	/**
	 * 后台登录
	 * @return
	 */
	@RequestMapping(value = "/loginSubmit")
	public @ResponseBody Map<String, Object> login(final String userName,final String password,final String code){
		Map<String, Object> map = new HashMap<String, Object>();
		Subject currentUser = SecurityUtils.getSubject();
		MyUsernamePasswordToken token = new MyUsernamePasswordToken();
		token.setRememberMe(true); 
		token.setUsername(userName);
		token.setPassword(password.toCharArray());
		token.setCode(code);
		
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return map;
		}
		
		if(currentUser.isAuthenticated()){
			
		}else{
			
		}
		return map;
	}
	

}
