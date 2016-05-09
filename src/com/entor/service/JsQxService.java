package com.entor.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.entor.model.JS_QX;
import com.entor.model.QX_INFO;
import com.entor.utils.PageUtil;

public interface JsQxService {

	public void addJsQx(JS_QX jq) throws Exception;

	public void deleteJsQx(JS_QX jq);
	/**
	 * 根据条件查询得到一个权限信息列表
	 * 
	 * @param qxINFO
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public InputStream getAllJsQxOList() throws UnsupportedEncodingException;
	public InputStream getJsQxList(int id) throws UnsupportedEncodingException;
}
