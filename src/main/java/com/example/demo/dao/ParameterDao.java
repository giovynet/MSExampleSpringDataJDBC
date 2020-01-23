package com.example.demo.dao;

import com.example.demo.dto.GroupParameterDto;
import com.example.demo.dto.ParameterDto;
import com.example.demo.exception.DaoException;

public interface ParameterDao {
	
	/**
	 * Insert a ParameterDto in datasource one.
	 * @param parameter
	 * @return
	 * @throws DaoException
	 */
	Long insertParameterDsOne(ParameterDto parameter) throws DaoException;
	
	/**
	 * Insert a GroupParamerDto in datasource one.
	 * @param groupParameterDto
	 * @return id
	 * @throws DaoException
	 */
	Long insertGroupParameterDsOne(GroupParameterDto groupParameterDto) throws DaoException;
	
	/**
	 * Update by id a GroupParamerDto in datasource one.
	 * @param groupParameter
	 * @throws DaoException
	 */
	void updateGroupParameterDsOne(GroupParameterDto groupParameter) throws DaoException;
	
	/**
	 * Insert a ParameterDto in datasource one.
	 * @param parameter
	 * @return
	 * @throws DaoException
	 */
	Long insertParameterDsTwo(ParameterDto parameter) throws DaoException;
	
	/**
	 * Insert a GroupParamerDto in datasource one.
	 * @param groupParameterDto
	 * @return id
	 * @throws DaoException
	 */
	Long insertGroupParameterDsTwo(GroupParameterDto groupParameterDto) throws DaoException;
	
	/**
	 * Update by id a GroupParamerDto in datasource one.
	 * @param groupParameter
	 * @throws DaoException
	 */
	void updateGroupParameterDsTwo(GroupParameterDto groupParameter) throws DaoException;
	

	
}
