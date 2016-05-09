package com.entor.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.entor.model.QX_INFO;
import com.entor.utils.PageUtil;

public interface QX_INFOService {

	public void addQxINFO(QX_INFO qxINFO) throws Exception;

	public void deleteQxINFO(QX_INFO qxINFO);

	public void updateQxINFO(QX_INFO qxINFO);

	public QX_INFO getQxINFO(int id);

	/**
	 * 根据条件查询得到一个权限信息列表
	 * 
	 * @param qxINFO
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public InputStream getAllQX_INFOList() throws UnsupportedEncodingException;

	/**
	 * 分页的方法
	 * 
	 * @param qxINFO
	 * @param pu
	 * @return
	 */
	public InputStream getQX_INFOJsonByPage(QX_INFO goods, PageUtil pu)
			throws UnsupportedEncodingException;
}
