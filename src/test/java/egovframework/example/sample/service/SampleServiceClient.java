package egovframework.example.sample.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import egovframework.sample.service.impl.SampleServiceImpl;
import egovframework.sample.service.SampleService;
import egovframework.sample.service.SampleVO;

public class SampleServiceClient {
	
	public static void main(String[] args) throws Exception {
		
//		String[] configurations = {"egovframework/spring/context-common.xml", "egovframework/spring/context-datasource.xml"};
//		AbstractApplicationContext container = new GenericXmlApplicationContext(configurations);
		
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("egovframework/spring/context-*.xml");
		
		// 2. Spring 컨테이너로부터 SampleService 객체를 Lookup한다.
		SampleService sampleService = (SampleService) container.getBean("sampleService");
		SampleVO vo = new SampleVO();
		vo.setTitle("아이디 자동 생성 테스트");
		vo.setRegUser("테스터");
		vo.setContent("아이디 자동 .....");
		sampleService.insertSample(vo);
		
		List<SampleVO> sampleList = sampleService.selectSampleList(new SampleVO());
		System.out.println("[ Sample LIST ]");
		for (SampleVO sample : sampleList) {
			System.out.println("---> " + sample.toString());
		}
		
		// 3. Spring 컨테이너를 종료한다.
		container.close();
	}
}
