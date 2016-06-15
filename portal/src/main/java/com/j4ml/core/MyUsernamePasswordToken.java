package com.j4ml.core;

import org.apache.shiro.authc.UsernamePasswordToken;

public class MyUsernamePasswordToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 1L;
	
	private String code;
	
	public MyUsernamePasswordToken() {
		
	}
	
	public MyUsernamePasswordToken(String username, String password, boolean rememberMe, String host, String captcha) {
        super(username, password, rememberMe, host);  
        this.code = captcha;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


}
