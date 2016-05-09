package com.entor.utils;
/**
 * 
 * @author Administrator
 * 每页 2条 size 
  第  2页  pageNo
  
  开始的位置：size*(pageNo-1)+1
  结束的位置：size*pageNo
   
  总共多少页：总的记录数/每页条数+1（？）
 oracle物理分页：
  select * from( 
  select rownum rn,s.*  from student s 
  where  rownum<=pageNo*size) a 
  where a.rn>=(size*(pageNo-1)+1) 
  
   5/2 = 3页
   代码角度：5/2=2  2+1
             4/2=2 
 */
public class PageUtil {

	private int size=2; //每页的记录数（条数）
	
	private long totalRecords; //总的记录数
	
	private long totalPages;//总的页数
	
	private int startCursor; //开始的位置
	
	private int endCursor; //结束的位置
	
	private int pageNo; //当前的页数
	
	public void setSize(int size){
		this.size=size;
	}
	
	public int getSize(){
		return this.size;
	}
	//设置总的记录数
	public void setTotalRecords(long totalRecords){
		this.totalRecords = totalRecords;
	}
	
	public long getTotalRecords(){
		return this.totalRecords;
	}
	//求总的页数 总共多少页：总的记录数/每页条数+1（？）
	public long getTotalPages(){
		if(this.totalRecords%this.size==0){
			totalPages =  this.totalRecords/this.size;
		}else{
			totalPages =  this.totalRecords/this.size+1;
		}
		
		return totalPages;
	}
	//开始的位置：size*(pageNo-1)+1
	public int getStartCursor(){
		return this.size*(this.pageNo-1);
	}
	//结束的位置：size*pageNo
	public int getEndCursor(){
		return this.size*this.pageNo;
	}

	public int getPageNo() {
		return pageNo;
	}
    //设置当前页数
	public void setPageNo(int pageNo) {
		if(pageNo<0){
			this.pageNo=1;
		}
		if(pageNo>this.getTotalPages()){
			this.pageNo=1;
		}
		this.pageNo = pageNo;
	}
	
	//上一页下一页
	//判断是否有上一页
	public boolean isHavePre(){
		if(this.pageNo-1<=0){
			return false;
		}
        return true;
	}
	//判断是否有下一页
	public boolean isHaveNext(){
		if(this.pageNo+1>this.getTotalPages()){
			return false;
		}
		return true;
	}
}
