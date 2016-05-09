package com.entor.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.entor.model.Admin;
import com.entor.model.JS_XX;
import com.entor.utils.PageUtil;

public interface JsxxService {
	//增加
    public void addJS_XX(JS_XX jsxx);
    //删除
    public void deleteJS_XX(JS_XX jsxx);
    //更新
    public void updateJS_XX(JS_XX jsxx);
    //获取一个
    public JS_XX getJS_XX(int id);
    public List<JS_XX> getList(JS_XX jsxx);
    //根据条件得到列表
    public InputStream getJS_XXList(JS_XX jsxx,PageUtil pu) throws UnsupportedEncodingException;
    //获取所有角色
    public InputStream getJS_XXList() throws UnsupportedEncodingException;
}
