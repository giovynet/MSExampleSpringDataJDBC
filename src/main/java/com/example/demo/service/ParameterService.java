package com.example.demo.service;

import com.example.demo.dto.GroupParameterDto;
import com.example.demo.dto.ParameterDto;
import com.example.demo.exception.DaoException;

public interface ParameterService {
	
	/**
	 * Update a groupParameterDto in datasource one.
	 * @param groupParameterDto
	 * @throws DaoException
	 */
	void updateGroupParameterDsOne(GroupParameterDto groupParameterDto) throws DaoException;
	
	/**
	 * Create parameterDto with groupParameterDto in datasource one. 
	 * @param groupParameterDto
	 * @param parameterDao
	 * @throws DaoException
	 */
	void createGroupParameterWithParameterDsOne(GroupParameterDto groupParameterDto, ParameterDto parameterDto ) throws DaoException;
		
	/**
	 * Create parameterDto with groupParameterDto in datasources one and two. 
	 * @param groupParameterDto
	 * @param parameterDao
	 * @throws DaoException
	 */
	void createGroupParameterWithParameterDsOneTwo(GroupParameterDto groupParameterDto, ParameterDto parameterDto ) throws DaoException;

	
}
