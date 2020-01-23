package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.config.DataSourceConfig.ChainedTransaction;
import com.example.demo.dao.ParameterDao;
import com.example.demo.dto.GroupParameterDto;
import com.example.demo.dto.ParameterDto;
import com.example.demo.exception.DaoException;

@Service
public class ParameterServiceImpl implements ParameterService {

	@Autowired
	private ParameterDao parameterDao;

	@Autowired
	private ParameterHelper parameterHelper;

	@Override
	public void updateGroupParameterDsOne(GroupParameterDto groupParameterDto) throws DaoException {
		try {
			parameterDao.updateGroupParameterDsOne(groupParameterDto);

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}

	}

	// Applies rollback for Exception type throw too...
	// because by default spring applies undo transactions only for Runtime
	// Exceptions...
	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = { "Exception" })
	@Override
	public void createGroupParameterWithParameterDsOne(GroupParameterDto groupParameterDto, ParameterDto parameterDto)
			throws DaoException {
		try {

			// validate fields to groupParameter
			this.parameterHelper.validarCamposGroupParameter(groupParameterDto, false);

			// insert groupParameter
			Long idGroupParameter = this.parameterDao.insertGroupParameterDsOne(groupParameterDto);

			// validate fields to parameterDto
			parameterDto.setIdGroupParameter(idGroupParameter);
			this.parameterHelper.validarCamposParameter(parameterDto, false);

			// insert parameterDto
			Long idParameter = parameterDao.insertParameterDsOne(parameterDto);

			// Uncomment code below to test transaction rollback
//			if(idParameter != null) {
//				throw new DaoException();
//			}

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}

	}

	@ChainedTransaction
	@Override
	public void createGroupParameterWithParameterDsOneTwo(GroupParameterDto groupParameterDto,
			ParameterDto parameterDto) throws DaoException {
		try {

			/*****************************
			 * INSERT IN DATASOURCE ONE
			 ****************************/

			// validate fields to groupParameter
			this.parameterHelper.validarCamposGroupParameter(groupParameterDto, false);

			// insert groupParameter in datasource one
			Long idGroupParameterDsOne = this.parameterDao.insertGroupParameterDsOne(groupParameterDto);

			// validate fields to parameterDto
			parameterDto.setIdGroupParameter(idGroupParameterDsOne);
			this.parameterHelper.validarCamposParameter(parameterDto, false);

			// insert parameterDto
			Long idParameterDsOne = parameterDao.insertParameterDsOne(parameterDto);

			/*****************************
			 * INSERT IN DATASOURCE TWO
			 ****************************/
			// insert groupParameter in datasource one
			Long idGroupParameterDsTwo = this.parameterDao.insertGroupParameterDsTwo(groupParameterDto);

			// insert parameterDto
			parameterDto.setIdGroupParameter(idGroupParameterDsTwo);
			parameterDao.insertParameterDsTwo(parameterDto);

			// Uncomment code below to test transaction rollback
//			if (idParameterDsOne != null) {
//				throw new DaoException();
//			}

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e.getCause());
		}

	}

}
