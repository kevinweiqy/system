package com.entor.model;

/**试卷试题信息表试题类
 * @author entor121
 *
 */
public class TestPaperShiTi {
	private int id;
	private ShiTi shiTi;//试题
	private TestPaper testPaper;//试卷
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ShiTi getShiTi() {
		return shiTi;
	}
	public void setShiTi(ShiTi shiTi) {
		this.shiTi = shiTi;
	}
	public TestPaper getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}
	
	
	
	

}
