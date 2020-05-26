package egovframework.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import egovframework.sample.service.SampleVO;

@Repository("daoSpring")
public class SampleDAOSpring implements SampleDAO{
	@Resource(name="jdbcTemplate")
	private JdbcTemplate spring;
	
	private final String SAMPLE_INSERT = "INSERT INTO SAMPLE (ID, TITLE, REG_USER, CONTENT, REG_DATE) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
	private final String SAMPLE_UPDATE = "UPDATE SAMPLE SET TITLE=?, REG_USER=?, CONTENT=? WHERE ID=?";
	private final String SAMPLE_DELETE = "DELETE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_GET = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_LIST = "SELECT ID, TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE ORDER BY REG_DATE DESC";
	private final String SAMPLE_LIST_TITLE = "select * from sample where title like ? order by reg_date DESC";
	private final String SAMPLE_LIST_CONTENT = "select * from sample where content like ? order by reg_date desc";
	
	public SampleDAOSpring() {
		System.out.println("===> SampleDAOSpring 생성");
	}
	
	public void insertSample(SampleVO vo) throws Exception {
		System.out.println("===> Spring으로 insertSample() 기능 처리");
		Object[] args = {vo.getId(), vo.getTitle(), vo.getRegUser(), vo.getContent()};
		spring.update(SAMPLE_INSERT, args);
	}
	
	public void updateSample(SampleVO vo) throws Exception {
		System.out.println("===> Spring으로 updateSample() 기능 처리");
		System.out.println(vo.toString());
		Object[] args = {vo.getTitle(), vo.getRegUser(), vo.getContent(), vo.getId()};
		spring.update(SAMPLE_UPDATE, args);
	}
		
	public void deleteSample(SampleVO vo) throws Exception {
		System.out.println("===> Spring으로 deleteSample() 기능 처리");
		spring.update(SAMPLE_DELETE, vo.getId());
	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception {
		System.out.println("===> Spring으로 selectSample() 기능 처리");
		Object[] args = {vo.getId()};
		return spring.queryForObject(SAMPLE_GET, args, new SampleRowMapper());
	}
	
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
		System.out.println("===> Spring으로 selectSampleList() 기능 처리");
		Object[] args = {"%" + vo.getSearchKeyword() + "%"};
		if(vo.getSearchCondition().equals("TITLE")) {
			return spring.query(SAMPLE_LIST_TITLE, args, new SampleRowMapper());
		} else if(vo.getSearchCondition().equals("CONTENT")) {
			return spring.query(SAMPLE_LIST_CONTENT, args, new SampleRowMapper());
		}
		return null;
	}
}
