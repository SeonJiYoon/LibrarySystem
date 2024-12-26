package com.test.edu;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.min.edu.support.SqlDaoSupport;

public class SessionCreate_JUnitTest {

	@Test
	public void test() {
		SqlSessionFactory factory = SqlDaoSupport.getFactory();
		SqlSession session = factory.openSession();
		assertNotNull(session);
	}

}
