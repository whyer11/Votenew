package com.sbpms.service;

import com.sbpms.bean.PersonInfo;
import com.sbpms.bean.VoteInfp;

public interface votesService {

	public  int   countVotes(PersonInfo  personInfo);
	public  void  inserte(VoteInfp voteInfp);
	public boolean validatee(int date, String test);
    public boolean validateByIp(int date, String clientIp);
}
