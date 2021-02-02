package org.zerock.time.dao;

import org.junit.Test;
import org.zerock.common.dao.MyBatisMaker;

import lombok.extern.log4j.Log4j;

@Log4j
public class TimeMapperTests {

	private TimeDAO dao = new TimeDAO();
	
	@Test
	public void testSqlSessioFactory() {
		//  			설정파링이 로딩이 끝난걸 확인
		System.out.println(MyBatisMaker.INSTANCE.getFactory());
		
	}
	
	@Test
	public void testTime() {
		
		log.info(dao.getTime());
		
	}
}
