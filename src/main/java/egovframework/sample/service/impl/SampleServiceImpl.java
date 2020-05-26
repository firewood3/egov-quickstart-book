package egovframework.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.sample.service.SampleService;
import egovframework.sample.service.SampleVO;

@Service("sampleService")
public class SampleServiceImpl extends EgovAbstractServiceImpl implements SampleService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceImpl.class);
	
//	@Resource(name="daoJDBC")
//	@Resource(name="daoSpring")
	@Resource(name="daoIBatis")	
//	@Resource(name="daoMyBatis")
	private SampleDAO sampleDAO;
	
	@Resource(name="egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;
	
	public SampleServiceImpl() throws Exception {
		System.out.println("===> SampleServiceImpl 생성");
//		sampleDAO = new SampleDAOJDBC();
	}
	
	public SampleServiceImpl(SampleDAO sampleDAO) throws Exception {
		System.out.println("===> SampleServiceImpl(2) 생성");
		this.sampleDAO = sampleDAO;
	}
	
	public void insertSample(SampleVO vo) throws Exception {
		LOGGER.trace("TRACE Level Logging");
		LOGGER.debug("DEBUG Level Logging");
		LOGGER.info("INFO Level Logging");
		LOGGER.warn("WARN Level Logging");
		LOGGER.error("ERROR Level Logging");
		
//		System.out.println("SampleService---Sample 등록");
//		if(vo.getId() == 0) {
//			throw new IllegalArgumentException("0번 아이디는 등록할 수 없습니다.");
//		}
			
		String id = egovIdGnrService.getNextStringId();
		vo.setId(id);
		sampleDAO.insertSample(vo);
	}
	
	public void updateSample(SampleVO vo) throws Exception {
//		System.out.println("SampleService---Sample 수정");
		sampleDAO.updateSample(vo);
	}
	
	public void deleteSample(SampleVO vo) throws Exception {
//		System.out.println("SampleService---Sample 삭제");
		sampleDAO.deleteSample(vo);
	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception {
//		System.out.println("SampleService---Sample 상세 조회");
		return sampleDAO.selectSample(vo);
	}
	
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
//		System.out.println("SampleService---Sample 목록 검색");
		return sampleDAO.selectSampleList(vo);
	}
}
