package com.sbpms.dao;

import java.util.List;

import com.sbpms.bean.PersonInfo;
import com.sbpms.bean.VoteInfp;

public interface voteInfoDao {
	
   public  List<VoteInfp> select(PersonInfo  personInfo);
   public  boolean  select(VoteInfp voteInfp);
   public  void   insert(VoteInfp voteInfp);
   public boolean select(int date, String test);
   public boolean selectByIp(int date, String clientIp);



}
