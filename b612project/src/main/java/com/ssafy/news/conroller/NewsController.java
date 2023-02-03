package com.ssafy.news.conroller;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ssafy.news.model.dto.News;
import com.ssafy.news.service.NewsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/server")
@Api("News 컨트롤러  네이버 API")
public class NewsController {
	@Autowired
	private NewsService service;
	
	
	
	@PostMapping("/saveone")
	@ApiOperation(value = "db에 부동산 검색 기사를 삽입", response = Integer.class)
	public ResponseEntity<?> saveone() {
		System.out.println("들어오나요?");
		
		String query="부동산";
		ByteBuffer buffer=StandardCharsets.UTF_8.encode(query);
		String encode=StandardCharsets.UTF_8.decode(buffer).toString();
		
		URI uri=UriComponentsBuilder
				.fromUriString("https://openapi.naver.com")
				.path("v1/search/news.json")
				.queryParam("query", encode)
				.queryParam("display", 10)
				.queryParam("start", 1)
				.encode()
				.build()
				.toUri();
		RestTemplate restTemplate= new RestTemplate();
		
		RequestEntity<Void> req=RequestEntity
				.get(uri)
				.header("X-Naver-Client-Id", "_sC5wkLt3V2yGI59BPFc")
				.header("X-Naver-Client-Secret", "Pbe541AIFk")
				.build();
		
		ResponseEntity<String> result=restTemplate.exchange(req, String.class);
		
//		JSONObject jObj = new JSONObject(result.getBody());
//        JSONArray array = jObj.getJSONArray("items");
//        int res=-1;
//        News news=null;
//        
//        for(int i=0; i<array.length(); i++) {
//            jObj = (JSONObject) array.get(i);
//
//            String title = jObj.get("title").toString();
//            String description = jObj.get("description").toString();
//            
//            title = title.replace("<b>", "").replace("</b>", "").replace("&quot;", "").replace("&apos;", "");
//            description = description.replace("<b>", "").replace("</b>", "").replace("&quot;", "").replace("&apos;", "");
//            
//            news =new News(title, jObj.get("originallink").toString(),jObj.get("link").toString(),description, jObj.get("pubDate").toString());
//            System.out.println(news.toString());
//        }
		
        
		
		try {
			JSONObject jObj = new JSONObject(result.getBody());
	        JSONArray array = jObj.getJSONArray("items");
	        int res=-1;
	        
	        for(int i=0; i<array.length(); i++) {
	            jObj = (JSONObject) array.get(i);

	            String title = jObj.get("title").toString();
	            String description = jObj.get("description").toString();
	            
	            title = title.replace("<b>", "").replace("</b>", "").replace("&quot;", "").replace("&apos;", "");
	            description = description.replace("<b>", "").replace("</b>", "").replace("&quot;", "").replace("&apos;", "");
	            
	            News news =new News(title, jObj.get("originallink").toString(),jObj.get("link").toString(),description, jObj.get("pubDate").toString());
	            
	            res=service.saveone(news);
	        }
	        
	        
	        /////////////////
//	        for(int i=0; i<array.length(); i++) {
//	            res=service.saveone(news);
//	        }
	        
	        ///////////////////
	        
	        
	        return new ResponseEntity<Integer>(res, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Integer>(-1, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@DeleteMapping("/deleteAll")
	@ApiOperation(value = "db를 비운다.", response = Integer.class)
	public ResponseEntity<?> deleteAll() {
		System.out.println("delete 실행");
		try {
			int result = service.deleteAll();
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Integer>(-1, HttpStatus.FAILED_DEPENDENCY);
		} 
	}
	
	@GetMapping("/naver")
	@ApiOperation(value = "네이버 창 가져오기", response = Integer.class)
	public ResponseEntity<?> naver() {
		try {
			this.deleteAll();
			return this.saveone(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Integer>(-1, HttpStatus.FAILED_DEPENDENCY);
		} 
	}
	
	@GetMapping("/getnews")
	@ApiOperation(value = "뉴스 데이터 가져오기", response = News.class)
	public ResponseEntity<?> getNews() {
		try {
			return new ResponseEntity<List<News>>(service.getNews(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Integer>(-1, HttpStatus.FAILED_DEPENDENCY);
		} 
	}
}
