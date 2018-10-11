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
	SqlSessionTemplate template;
	// 부서
	public List<Map> Alldepart() {
		return template.selectList("department.Alldepart");
	}
	
	// 직책
	public List<Map> Allposition() {
		return template.selectList("position.Allposition");
	}
	// id
	public String getSequenceVal() {
		return "em" + template.selectOne("employee.getSequenceVal");	
	}
	// 데이터 추가
	public int addemployee(Map map) {
		return template.insert("employee.addemployee",map);
	} 
	// 로그인
	public Map loginck(Map map) {
		return template.selectOne("employee.loginck",map);
	}
}
