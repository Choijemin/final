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
	// 비밀번호 변경
	public int setchange(Map map) {
		return template.update("employee.setchange",map);
	}
	// 메세지 
	public int addmail(Map map) {
		return template.insert("mail.addmail",map);
	}
	
	public Map getEmployee(String id) {
		return template.selectOne("employee.getEmployee", id);
	}
}
