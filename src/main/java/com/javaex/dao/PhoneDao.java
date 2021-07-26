package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;
@Repository
public class PhoneDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//전체리스트 가져오기
	public List<PersonVo> getPersonList(){
		
		//db요청
		//리스트 가져온다
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");
		System.out.println(personList);
		
		return personList;
	}
	
	//전화번호 저장
	public int personInsert(PersonVo personVo) {
		
		
		int count = sqlSession.insert("phonebook.personInsert", personVo);
		
		return count;
	}
	
	//전화번호 저장2
	public int personInsert2(String name, String hp, String company) {
		
		
		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		
		int count = sqlSession.insert("phonebook.personInsert", personMap);
		
		return count;
	}
	
	//전화번호 삭제
	public int personDelete(int personId) {
		
		int count = sqlSession.delete("phonebook.personDelete", personId);
		return count;
	}
	
	//수정폼, 전화번호 1개정보 가져오기
	public PersonVo getPerson(int personId) {
		
		PersonVo personVo = sqlSession.selectOne("phonebook.selectPerson", personId);
		return personVo;
	}
	
	//수정폼2, 전화번호 1개정보 가져오기
	public Map<String, Object> getPerson2(int personId) {
		Map<String, Object> personMap = sqlSession.selectOne("phonebook.selectPerson2", personId);
		
		return personMap;
	}
	
	//전화번호 수정
	public int personUpdate(PersonVo personVo) {
		
		int count = sqlSession.update("phonebook.personUpdate", personVo);
		
		return count;
	}
	
}
	
