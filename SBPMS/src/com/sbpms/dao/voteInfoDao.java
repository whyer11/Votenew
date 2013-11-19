package com.sbpms.dao;

import java.sql.Date;
import java.util.List;

import com.sbpms.bean.PersonInfo;
import com.sbpms.bean.VoteInfp;

public interface voteInfoDao {
	
   public  List<VoteInfp> select(PersonInfo  personInfo);
   public  boolean  select(VoteInfp voteInfp);
   public  void   insert(VoteInfp voteInfp);
   public boolean select(String date, String test);
   public boolean selectByIp(String date, String clientIp);
}
