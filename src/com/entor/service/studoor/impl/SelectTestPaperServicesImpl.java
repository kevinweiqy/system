package com.entor.service.studoor.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



import com.entor.dao.StudentDao;
import com.entor.dao.TestAnserDao;
import com.entor.dao.studoor.SelectTestPaperDao;
import com.entor.model.Rightorwrong;
import com.entor.model.Select;
import com.entor.model.ShiTi;
import com.entor.model.Student;
import com.entor.model.TestAnser;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;
import com.entor.service.TestScoreService;
import com.entor.service.studoor.SelectTestPaperServices;
import com.entor.utils.PageUtil;

@Service("selectTestPaperServicesImpl")
public class SelectTestPaperServicesImpl implements SelectTestPaperServices{

	@Autowired @Qualifier("selectTestPaperDaoImpl")
	private SelectTestPaperDao selectTestPaperDao;
	@Autowired @Qualifier("testAnserDaoImpl")
	TestAnserDao testAnserDao;
	@Autowired @Qualifier("studentDaoImpl")
	private StudentDao studentDao;
	@Autowired @Qualifier("testScoreServiceImpl")
	private TestScoreService tss;


	public Map<String,List<ShiTi>> getTestPaperShiTiList(int id){
		// 利用if分开ShiTi
		List<ShiTi> list=selectTestPaperDao.getShiTiList(id);
		List<ShiTi> list1=new ArrayList<ShiTi>();
		List<ShiTi> list2=new ArrayList<ShiTi>();
		List<ShiTi> list3=new ArrayList<ShiTi>();
		Map<String,List<ShiTi>> map=new HashMap<String, List<ShiTi>>();
		for(ShiTi st:list){
			if(st.getType()==1){
				list1.add(st);//是1就是判断题
			}else if(st.getType()==0){
				list2.add(st);//0是单选题
			}else if(st.getType()==2){
				list3.add(st);//2是多选题
			}
		}
		map.put("pan",list1);
		map.put("danxuan", list2);
		map.put("duoxuan", list3);
		return map;
	}

    //找试卷信息
	public TestPaper getTestPaperService(int id) {
		TestPaper tp=selectTestPaperDao.getTestPaper(id);
		//System.out.println(tp.getExamination_no());
		return tp;
	}
	
	
	//添加考试答案,计算考试成绩,保存考试成绩表
	public TestScore addTestAnswer(Map<String,List<ShiTi>> map1,Map<String,Object> map2,
			TestPaper testPaper){
		int score=0;
		List<ShiTi> list1=map1.get("pan");
		List<ShiTi> list2=map1.get("danxuan");
		List<ShiTi> list3=map1.get("duoxuan");
		//学生对象
		Student student=(Student) map2.get("stu");
		int total=list1.size()+list2.size()+list3.size();
		//获取答案字符串
		String daAn=(String) map2.get("daAn");
		String dA[]=daAn.split(",");
		
		List<String> list=new ArrayList<String>();
		for(int i=1;i<dA.length;i++){
			list.add(dA[i]);
		}
	
		TestScore ts=tss.getTestScoreService(testPaper, student);
		//成绩为-1是第一次考试，需要保存考试答案，修改考试成绩，如果不是第一次考试将什么都不做
		if(ts.getScore()==-1){
		for(int i=0;i<total;i++){
			TestAnser testAnser=new TestAnser();//考试答案对象
			testAnser.setStudent(student);//设置学生
			testAnser.setTestPaper(testPaper);//设置试卷
			if(i<list2.size()){
				Select select=(Select) list2.get(i);
				//设置题目
				testAnser.setSelect(select);
				//设置学生答案
				int dan=Integer.parseInt(list.get(i));
				testAnser.setSsAnswer(dan);
				//设置标准答案
				int biaodan=Integer.parseInt(select.getAnswer());
				testAnser.setSelectAnswer(biaodan);
				//计算成绩
				if(dan==biaodan){
					score=score+testPaper.getSelect_score();
				}				
				
			}else if(i>=list2.size()&&i<(list3.size()+list2.size())){
				int a=i-list2.size();
				Select select=(Select) list3.get(a);
				//设置多选题
				testAnser.setSelect(select);
				//设置学生答案
				int duo=Integer.parseInt(list.get(i));
				testAnser.setSsAnswer(duo);
				//设置标准答案
				int biaoduo=Integer.parseInt(select.getAnswer());
				testAnser.setSelectAnswer(biaoduo);
				//计算成绩
				if(duo==biaoduo){
					score=score+testPaper.getSelects_score();
				}
			}else{
				Rightorwrong rightorwrong=(Rightorwrong) list1.get(i-list2.size()-list3.size());
				//设置判断题
				testAnser.setRightorwrong(rightorwrong);
				//设置学生答案
				int panduan=Integer.parseInt(list.get(i));
				testAnser.setRightorwrongAnswer(panduan);
				//设置标准答案
				int biaopanduan=rightorwrong.getAnswer();
				testAnser.setRwAnswer(biaopanduan);
				//计算成绩
				if(panduan==biaopanduan){
					score=score+testPaper.getRightorwrong_score();
				}
			}		
		testAnserDao.save(testAnser);
		}	
		//修改考试成绩的信息		
		ts.setScore(score);//设置成绩
		ts.setExaminationdate(testPaper.getBeginTime());//设置考试时间
		tss.updateTestScore(ts);
		}				
		return ts;
	}
	
	
	
}
