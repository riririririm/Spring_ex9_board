package com.rim.util;

public class PageMaker {
	
	private int perPage=10;
	private Integer curPage;
	private String kind;
	private String search;
	
	//rownum
	private int startRow;
	private int lastRow;
	
	//page
	private int totalBlock;
	private int curBlock;
	private int startNum;
	private int lastNum;
	
	
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
		if(this.curPage==null)
			this.curPage =1;
	}
	public Integer getCurPage() {
		if(this.curPage==null)
			this.curPage=1;
		return curPage;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getKind() {
		return kind;
	}
	
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSearch() {
		if(this.search==null)
			this.search="";
		return search;
	}
	
	public int getStartRow() {
		return startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public int getStartNum() {
		return startNum;
	}
	public int getLastNum() {
		return lastNum;
	}
	
	
	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.perPage+1;
		this.lastRow = (this.curPage*perPage);
	}
	
	public void makePage(int totalCount) {
		//1. 전체 글 갯수 구하기
		int totalPage = totalCount/perPage;
		if(totalCount%perPage !=0) {
			totalPage++;
		}
		
		//2. totalBlock구하기
		int perBlock=5;
		this.totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			this.totalBlock++;
		}
		
		//3. curPage 이용해서 curBlock
		this.curBlock = curPage/perBlock;
		if(curPage%perBlock !=0)
			curBlock++;
		
		//4. startNum, lastNum
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = this.curBlock*perBlock;
		
		//5. curBlock이 totalBlock일 때
		if(this.curBlock==totalBlock)
			this.lastNum = totalPage;
	}
	
	
	

}
