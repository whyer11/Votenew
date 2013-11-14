package com.sbpms.service.impl;

import java.util.List;

import com.sbpms.bean.PersonInfo;
import com.sbpms.bean.VoteInfp;
import com.sbpms.dao.voteInfoDao;
import com.sbpms.service.votesService;

public class votesServiceImpl  implements  votesService {
	private  voteInfoDao voteinfoDao ;

	public voteInfoDao getVoteinfoDao() {
		return voteinfoDao;
	}

	public void setVoteinfoDao(voteInfoDao voteinfoDao) {
		this.voteinfoDao = voteinfoDao;
	}

	@Override
	public int countVotes(PersonInfo personInfo) {
		List<VoteInfp> votesList=voteinfoDao.select(personInfo);
		if(votesList == null){
			return 0;
		}
		return  votesList.size();
	}

	
	@Override
	public void inserte(VoteInfp voteInfp) {
		voteinfoDao.insert(voteInfp);
		
	}

	@Override
	public boolean validatee(String test) {
		return  voteinfoDao.select(test);
	}

}
