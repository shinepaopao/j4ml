package com.j4ml.dao.mapper;

import com.j4ml.dao.bean.SysUser;

public interface SysUserMapper {
   
    int deleteByPrimaryKey(String sysUserId);

   
    int insert(SysUser record);

  
    int insertSelective(SysUser record);

   
    SysUser selectByPrimaryKey(String sysUserId);

    
    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    /**
     * 通过用户登录名称查询系统用户
     * @param userName
     * @return
     */
    public SysUser findSysUserByLoginName(String userName);
}