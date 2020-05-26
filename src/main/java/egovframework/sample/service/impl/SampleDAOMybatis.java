package egovframework.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.sample.service.SampleVO;

@Repository("daoMyBatis")
public class SampleDAOMybatis extends EgovAbstractMapper implements SampleDAO {
	
	public SampleDAOMybatis() {
		System.out.println("===> SampleDAOMyBatis 생성");
	}
	
	@Override
	public void insertSample(SampleVO vo) throws Exception {
		System.out.println("===> MyBatis로 insertSample() 기능 처리");
		insert("insertSample", vo);
	}

	@Override
	public void updateSample(SampleVO vo) throws Exception {
		System.out.println("===> MyBatis로 updateSample() 기능 처리");
		update("updateSample", vo);
	}

	@Override
	public void deleteSample(SampleVO vo) throws Exception {
		System.out.println("===> MyBatis로 deleteSample() 기능 처리");
		delete("deleteSample", vo);
	}

	@Override
	public SampleVO selectSample(SampleVO vo) throws Exception {
		System.out.println("===> MyBatis로 selectSample() 기능 처리");
		return (SampleVO) selectOne("selectSample", vo);
	}

	@Override
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
		System.out.println("===> MyBatis로 selectSampleList() 기능 처리");
		return selectList("selectSampleList", vo);
	}
}
