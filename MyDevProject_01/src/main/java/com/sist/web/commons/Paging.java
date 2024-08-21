package com.sist.web.commons;

import org.springframework.stereotype.Component;

@Component
public class Paging {

	public int start(int rowsize, int page) {
		return (page*rowsize)-rowsize;
	}

	public int startpage(int BLOCK, int page) {
		return ((page-1)/BLOCK*BLOCK)+1;
	}
	
	public int endpage(int BLOCK,int page,int totalpage) {
		int endpage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endpage>totalpage) {
			endpage=totalpage;
		}
		
		return endpage;
		
	}
}
