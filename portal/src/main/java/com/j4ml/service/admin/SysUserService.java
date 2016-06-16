package com.j4ml.service.admin;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.j4ml.dao.bean.SysUser;
import com.j4ml.dao.mapper.SysUserMapper;

@Service("sysUserService")
public class SysUserService {
	
	@Resource SysUserMapper sysUserMapper;
	
	public SysUser findSysUserByLoginName(final String userName){
		return sysUserMapper.findSysUserByLoginName(userName);
	}
	

}
