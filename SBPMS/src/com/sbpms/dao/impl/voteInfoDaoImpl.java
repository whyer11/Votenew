package com.sbpms.dao.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sbpms.bean.PersonInfo;
import com.sbpms.bean.User;
import com.sbpms.bean.VoteInfp;
import com.sbpms.dao.voteInfoDao;

public class voteInfoDaoImpl extends HibernateDaoSupport  implements voteInfoDao {

	@Override
	public List<VoteInfp> select(PersonInfo personInfo) {
	        String   sqlString="from VoteInfp   where  voteeId=?";
	        Integer   voteeid=personInfo.getId();
	        List<VoteInfp>  votesList=this.getHibernateTemplate().find(sqlString, voteeid);
	        if(votesList.size() !=0){
	        	return  votesList;
	        	
	        }
	        return  null;
	}

	@Override
	public boolean select(VoteInfp voteInfp) {
		String   sqlString="from  VoteInfp  vhere voter_xuehao=?";
		String  voter_xuehao=voteInfp.getvoter_xuehao();
		 List<VoteInfp>  votesList=this.getHibernateTemplate().find(sqlString, voter_xuehao);
		 if(votesList.size() != 0){
			 return  false;
		 }
		return true;
	}

	@Override
	public void insert(VoteInfp voteInfp) {
		
		this.getHibernateTemplate().save(voteInfp);
	}

	@Override
	public boolean select(String date,String  voter_xuehao ) {
		String   sqlString="from  VoteInfp  where voter_xuehao="+voter_xuehao +" and vote_time="+date;
		 List<VoteInfp>  votesList=this.getHibernateTemplate().find(sqlString);
		 if(votesList.size() != 0){
			 return  false;
		 }
		return true;
	}

	@Override
	public boolean selectByIp(String date,String clientIp) {
		String   sqlString="from  VoteInfp  where voter_ip=? and vote_time="+date;
		System.out.print(sqlString);
		 List<VoteInfp>  votesList=this.getHibernateTemplate().find(sqlString, clientIp);
		 if(votesList.size() != 0){
			 return  false;
		 }
		return true;
	}
}
