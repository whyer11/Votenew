package com.sbpms.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sbpms.bean.PersonInfo;
import com.sbpms.bean.User;
import com.sbpms.dao.PersonInfoDao;

public class PersonInfoDaoImpl extends HibernateDaoSupport  implements  PersonInfoDao  {


	@Override
	public List<PersonInfo> selectPersonInfo() {
		 String sqlString = "from PersonInfo ";
		 List<PersonInfo>  personInfoList=this.getHibernateTemplate().find(sqlString);
		 return  personInfoList;
	}

}
