package app.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmplyoeeDao {

	@Autowired
	SqlSessionFactory factory;
	
	@Autowired
	SqlSessionTemplate template;
	// 부서
	public List<String> Alldepart() {
		return template.selectList("department.Alldepart");
	}
	
	// 직책
	public List<String> Allposition() {
		/*SqlSession session = factory.openSession();
		try {
			return session.selectList("position.Allposition");
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}*/
		return template.selectList("position.Allposition");
	}
	
	public int getSequenceVal() {
		SqlSession session = factory.openSession();
		try {
			 Integer i = session.selectOne("employee.getSequenceVal");
			 return i;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	public int addemployee(Map map) {
		SqlSession session = factory.openSession();
		try {
			int i = session.insert("employee.addemployee",map);
			if(i == 1) 
				session.commit();
			return i;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
} 
