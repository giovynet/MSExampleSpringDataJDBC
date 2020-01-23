package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GroupParameterDto;
import com.example.demo.dto.ParameterDto;
import com.example.demo.service.ParameterService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class ParameterController {

	@Autowired
	private ParameterService parameterService;

//	@PostMapping("/find/paymentPlan/{filingNumber}")
	@GetMapping("/actualizar/dsone/grupoParametro")
	public void updateGroupDsOne(@RequestParam(value = "groupParameter") String groupParamter) {		
		try {
			if(groupParamter != null) {
				GroupParameterDto groupParamterDto = new ObjectMapper().readValue(groupParamter, GroupParameterDto.class);
				System.out.println(groupParamterDto);	
				parameterService.updateGroupParameterDsOne(groupParamterDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@GetMapping("/crear/dsone/grupoParametroConParametro")
	public void crearGrupoParametroDsOne(@RequestParam(value = "groupParameter") String groupParameter, @RequestParam(value = "parameter") String parameter) {
		try {
			GroupParameterDto groupParameterDto = new ObjectMapper().readValue(groupParameter, GroupParameterDto.class);
			ParameterDto parameterDto = new ObjectMapper().readValue(parameter, ParameterDto.class);
			
			System.out.println(groupParameter);
			System.out.println(parameter);
			
			parameterService.createGroupParameterWithParameterDsOne(groupParameterDto, parameterDto);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
	@GetMapping("/crear/dsonetwo/grupoParametroConParametro")
	public void crearGrupoParametroDsOneTwo(@RequestParam(value = "groupParameter") String groupParameter, @RequestParam(value = "parameter") String parameter) {
		try {
			GroupParameterDto groupParameterDto = new ObjectMapper().readValue(groupParameter, GroupParameterDto.class);
			ParameterDto parameterDto = new ObjectMapper().readValue(parameter, ParameterDto.class);
			
			System.out.println(groupParameter);
			System.out.println(parameter);
			
			parameterService.createGroupParameterWithParameterDsOneTwo(groupParameterDto, parameterDto);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}