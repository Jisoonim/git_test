package org.zerock.dao;

import java.util.stream.IntStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.zerock.dao.util.MyBatisLoader;
import org.zerock.domain.BoardVO;

public class BoardDAOimpl implements BoardDAO {
	
	private SqlSessionFactory factory = MyBatisLoader.INSTANCE.getFactory(); 

	@Override
	public boolean insert(BoardVO vo) {
		boolean result = false;

		try (SqlSession session = factory.openSession()) {

			int count = session.insert("org.zerock.dao.BoardMapper.insert", vo);
			
			session.commit();
			
			result = count == 1 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public static void main(String[] args) throws Exception {
		
		BoardDAO dao = new BoardDAOimpl();
		
		IntStream.range(1, 5).forEach(i -> {
			
			BoardVO vo = new BoardVO();
			vo.setTitle("제목" + i);
			vo.setContent("내용" + i);
			vo.setWriter("user" + i);
			
			
			System.out.println(dao.insert(vo));
			
			});
	}

}
