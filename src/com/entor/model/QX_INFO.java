package com.entor.model;

/**
 * 权限信息表
 * @author entor116
 *
 */
public class QX_INFO {

	
	private int id;    //id
	private int qx_code;//权限编号
	private String qx_name;//权限名
	private String qx_url;  //权限路径
	public String getQx_url() {
		return qx_url;
	}
	public void setQx_url(String qxUrl) {
		qx_url = qxUrl;
	}
	private int state; // 状态  0是不再用  1是 再用
	private int menu; //菜单  1 是菜单 0 不是菜单//有没有上级权限：
	private int qx_sort; //序号
	private QX_INFO father;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQx_code() {
		return qx_code;
	}
	public void setQx_code(int qxCode) {
		qx_code = qxCode;
	}
	public String getQx_name() {
		return qx_name;
	}
	public void setQx_name(String qxName) {
		qx_name = qxName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getMenu() {
		return menu;
	}
	public void setMenu(int menu) {
		this.menu = menu;
	}
	public int getQx_sort() {
		return qx_sort;
	}
	public void setQx_sort(int qxSort) {
		qx_sort = qxSort;
	}
	public QX_INFO getFather() {
		return father;
	}
	public void setFather(QX_INFO father) {
		this.father = father;
	}			
}
