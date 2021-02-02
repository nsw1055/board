package org.zerock.time.dao;

import org.apache.ibatis.session.SqlSession;
import org.zerock.common.dao.MyBatisMaker;


public class TimeDAO {

	private static final String NAMESPACE = "org.zerock.time.dao.TimeMapper";

	public String getTime() {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".getTime");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
