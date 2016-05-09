package com.entor.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.entor.model.Admin;
import com.entor.utils.PageUtil;

public interface AdminService {
	//增加
    public void addAdmin(Admin admin);
    //删除
    public void deleteAdmin(Admin admin);
    //更新
    public void updateAdmin(Admin admin);
    //获取一个
    public Admin getAdmin(int id);
    public InputStream getAdminList() throws UnsupportedEncodingException;
    public List<Admin> getAdminByName(Admin admin);
    //根据条件得到列表
    public InputStream getAdminListByPage(Admin admin,PageUtil pu) throws UnsupportedEncodingException;
    
    public boolean getBoolean(String loginName,String pwd);
    
    public InputStream getQxList(String loginName,int id) throws UnsupportedEncodingException;
    public Admin getAdminName(String loginName);
}
