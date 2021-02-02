package org.zerock.board.domain;

import lombok.Builder.Default;

public class PageInfo {
	
	@Default
	private int page = 1;
	@Default
	private int perSheet = 10;
	
	public void setPage(int page) {
		
		if(page <=0) {
			this.page = 1;
			return;
		}		
		this.page = page;
		
	}
	public void setPerSheet(int perSheet) {
		
		if(perSheet >100) {
			this.perSheet = 100;
			return;
		}
		
		if(perSheet<10) {
			this.perSheet = 10;
			return;
		}
		
		this.perSheet = perSheet;
	}
	
	
	
}
