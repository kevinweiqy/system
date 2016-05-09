package com.entor.service.studoor;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.entor.model.ShiTi;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;
import com.entor.utils.PageUtil;
@Service
public interface SelectTestPaperServices {

	/**
	 * 给试卷添加试题
	 * @param shiTi
	 */
	public Map<String,List<ShiTi>> getTestPaperShiTiList(int id);
	
	/**
	 * 根据学生找到试卷
	 */
	public TestPaper getTestPaperService(int id);
	
	public TestScore addTestAnswer(Map<String,List<ShiTi>> map1,Map<String,Object> map2,
			TestPaper testPaper);
}
