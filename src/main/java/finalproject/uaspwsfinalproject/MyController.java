/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.uaspwsfinalproject;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 * Nama : Naufal Gita Mahardika
 * NIM : 20200140124
 */
@RestController
@CrossOrigin
public class MyController {
	
	B2020wsJpaController control = new B2020wsJpaController();
	//membuat method post
	@PostMapping("/POST")
	public String sendData(HttpEntity<String> kiriman) throws Exception{
		B2020ws datas = new B2020ws();
		String d = kiriman.getBody();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		datas = mapper.readValue(d, B2020ws.class);
	        control.create(datas);
		return d;
	}
	//membuat method put
	@PutMapping("/PUT")
	public String editData(HttpEntity<String> kiriman) throws Exception{
		B2020ws datas = new B2020ws();
		String d = kiriman.getBody();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		datas = mapper.readValue(d, B2020ws.class);
	        control.edit(datas);
		return d;
	}
	//membuat method delete
	@DeleteMapping("/DELETE")
	public String deleteData(HttpEntity<String> kiriman) throws Exception{
		B2020ws datas = new B2020ws();
		String d = kiriman.getBody();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		datas = mapper.readValue(d, B2020ws.class);
	        control.destroy(datas.getId());
		return "id: "+datas.getId()+" deleted";
	}
	//membuat method get
	@GetMapping("/GET")
	public List<B2020ws> getTabel(){
		List<B2020ws> list = new ArrayList<>();
		try {
			list = control.findB2020wsEntities();
		}
		catch (Exception e){}
		return list;
	}
	
}

