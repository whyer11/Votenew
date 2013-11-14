package com.sbpms.service.impl;

import java.util.List;

import com.sbpms.bean.PersonInfo;
import com.sbpms.dao.PersonInfoDao;
import com.sbpms.service.candidate_display_service;

public class candidate_display_serviceImpl  implements candidate_display_service {
	private  PersonInfoDao  personInfoDao;

	public PersonInfoDao getPersonInfoDao() {
		return personInfoDao;
	}

	public void setPersonInfoDao(PersonInfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}

	
	@Override
	public List<PersonInfo> display() {
		// TODO Auto-generated method stub
		return  personInfoDao.selectPersonInfo();

}
}