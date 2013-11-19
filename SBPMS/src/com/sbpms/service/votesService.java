package com.sbpms.service;

import java.sql.Date;

import com.sbpms.bean.PersonInfo;
import com.sbpms.bean.VoteInfp;

public interface votesService {

	public  int   countVotes(PersonInfo  personInfo);
	public  void  inserte(VoteInfp voteInfp);
	public boolean validatee(String date, String test);
    public boolean validateByIp(String currentDay, String clientIp);
}
