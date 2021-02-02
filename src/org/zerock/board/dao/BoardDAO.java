package org.zerock.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.zerock.board.domain.Board;
import org.zerock.board.domain.PageInfo;
import org.zerock.common.dao.MyBatisMaker;



public class BoardDAO {
	
	private static final String NAMESPACE = "org.zerock.board.dao.BoardMapper";

	public List<Board> getList(PageInfo pageInfo) throws Exception {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectList(NAMESPACE + ".getList", pageInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Board getOne(Long bno) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".getOne", bno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Board board) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.insert(NAMESPACE + ".insert", board);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Long bno) {
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.delete(NAMESPACE + ".delete", bno);

			session.commit();
		} catch (Exception e) {
			// session.rollback();
			e.printStackTrace();
		}
	}

	public void update(Board board) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.update(NAMESPACE + ".update", board);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

