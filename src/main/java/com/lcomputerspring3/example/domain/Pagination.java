package com.lcomputerspring3.example.domain;

import org.springframework.stereotype.Service;

@Service
public class Pagination {

	//pathvariable, localhost/list/3 이런 식으로 만들기(기존 get 방식에서 uri를 통해 파라미터 처리하기)
		//+Optional
	/*
	 * PathVariable : RESTful에서 URL 경로에 있는 변수 값 추출에 사용됨. 페이징과 함께 사용하여 동적으로
	 * 페이지 번호를 전달하고 해당 페이지의 데이터를 가져올 수 있음.
	 * */
	
	
	int count; 		//테이블에 등록된 총 레코드 수
	int page;		//현재 페이지 번호
	int pageNum;		//count / page = 화면에 나타날 index 번호
					//현재 페이지 번호를 기반으로 한 페이지에서의 첫 번째 게시물의 인덱스
	int startPage;		//pagination의 시작(ex. 1,11,21)
	int endPage;			//pagination의 끝(ex. 10,20,30)
	int lastPage;		//(count/화면에표시할갯수), pagination 마지막 번호
	int prevPage;		//pagination의 이전 목록
	int nextPage;		//pagination의 다음 목록
	
	

	public static final int pageUnit=5; //한번에 불러올 pagination 수
	public static final int perPage=20;	//한번에 불러올 자료(count) 수
	
	
	
	
	public Pagination() {
		
	}
	
	public void init() {
		pageNum = (page-1)*perPage;
		startPage = ((page-1)/pageUnit)*pageUnit+1;
		lastPage = (int)Math.ceil(count / (float)perPage);
		endPage = startPage+pageUnit-1;
		endPage = endPage < lastPage ?  endPage : lastPage;
		prevPage = (startPage-pageUnit);
		nextPage = (startPage+pageUnit);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public static int getPageunit() {
		return pageUnit;
	}

	public static int getPerpage() {
		return perPage;
	}
	
	
	
	
	
	
	
	
	
	
	
}
