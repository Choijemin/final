package app.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmplyoeeDao {

	@Autowired
	SqlSessionTemplate template;
	
	public List<String> Alldepart() {
		return template.selectList("department.Alldepart");
	}
	
	public List<String> Allposition() {
		return template.selectList("position.Allposition");
	}
} 
