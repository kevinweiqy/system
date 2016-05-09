package com.entor.model;

import java.util.Date;

public class Select extends ShiTi {
	private int selectid;//主键，也是外键
	private String result1;//选项1
	private String result2;//选项2
	private String result3;//选项3
	private String result4;//选项4
	private int  selectType;//选择题类型  1.单选  2.多选
	private String answer;//正确答案   1.正确 ，0.错误
	private Date sctupdate;//加入日期
	private int teacherId;//出题教师
	
	

	

	public int getSelectid() {
		return selectid;
	}
	public void setSelectid(int selectid) {
		this.selectid = selectid;
	}
	public String getResult1() {
		return result1;
	}
	public void setResult1(String result1) {
		this.result1 = result1;
	}
	public String getResult2() {
		return result2;
	}
	public void setResult2(String result2) {
		this.result2 = result2;
	}
	public String getResult3() {
		return result3;
	}
	public void setResult3(String result3) {
		this.result3 = result3;
	}
	public String getResult4() {
		return result4;
	}
	public void setResult4(String result4) {
		this.result4 = result4;
	}
	public int getSelectType() {
		return selectType;
	}
	public void setSelectType(int selectType) {
		this.selectType = selectType;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getSctupdate() {
		return sctupdate;
	}
	public void setSctupdate(Date sctupdate) {
		this.sctupdate = sctupdate;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	
	
	
	

}
