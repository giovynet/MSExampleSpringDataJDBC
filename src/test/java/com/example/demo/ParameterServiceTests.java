package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.dto.GroupParameterDto;
import com.example.demo.exception.ParameterException;
import com.example.demo.service.ParameterService;

@SpringBootTest
class ParameterServiceTests {

	@Autowired
	ParameterService parameterService;
	
	@Test
	void contextLoads() {
		
		try {
			List<GroupParameterDto> lst = parameterService.selectListGroupParameterDsOne();
			lst.forEach( item -> {
				System.out.println(item);
			});
			
			
			Assert.notEmpty(lst, "Group Parameter lis mustn't be empty");
			
		} catch (ParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
