package com.sbpms.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sbpms.bean.PersonInfo;
import com.sbpms.bean.VoteInfp;
import com.sbpms.service.candidate_display_service;
import com.sbpms.service.votesService;

public class candidate_display_action extends ActionSupport  {
	private  String   clientIp;
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	private  String  candidaters;
	private  String   studentID;
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	private  String  studentName;
	private  String studentPhone;
	
	public String getCandidaters() {
		return candidaters;
	}
	public void setCandidaters(String candidaters) {
		this.candidaters = candidaters;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	private Integer id;
	private String voter_xuehao;
	private String votePhone;
	private Integer voteeId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVoter_xuehao() {
		return voter_xuehao;
	}
	public void setVoter_xuehao(String voter_xuehao) {
		this.voter_xuehao = voter_xuehao;
	}
	public String getVotePhone() {
		return votePhone;
	}
	public void setVotePhone(String votePhone) {
		this.votePhone = votePhone;
	}
	public Integer getVoteeId() {
		return voteeId;
	}
	public void setVoteeId(Integer voteeId) {
		this.voteeId = voteeId;
	}

	private   boolean  hasVote;
	public boolean isHasVote() {
		return hasVote;
	}
	public void setHasVote(boolean hasVote) {
		this.hasVote = hasVote;
	}
    
	private   candidate_display_service  service;
	private   votesService  VotesService;
	public votesService getVotesService() {
		return VotesService;
	}
	public void setVotesService(votesService votesService) {
		VotesService = votesService;
	}
	public candidate_display_service getService() {
		return service;
	}
	public void setService(candidate_display_service service) {
		this.service = service;
	}
	
	public  List<PersonInfo>  personInfoList;
	public List<PersonInfo> getPersonInfoList() {
		return personInfoList;
	}
	public void setPersonInfoList(List<PersonInfo> personInfoList) {
		this.personInfoList = personInfoList;
	}
	
	
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	private   PersonInfo   personInfo;
	private  VoteInfp  voteInfo_validate;
	
	public VoteInfp getVoteInfo_validate() {
		return voteInfo_validate;
	}
	public void setVoteInfo_validate(VoteInfp voteInfo_validate) {
		this.voteInfo_validate = voteInfo_validate;
	}

	private  VoteInfp  voteInfp=new  VoteInfp();
	public VoteInfp getVoteInfp() {
		return voteInfp;
	}
	public void setVoteInfp(VoteInfp voteInfp) {
		this.voteInfp = voteInfp;
	}
	public  String   candidate_display(){
		personInfoList=service.display();
		Iterator<PersonInfo>   itr=personInfoList.iterator();
		while(itr.hasNext()){
			PersonInfo  personInfotmp=itr.next();
			personInfotmp.setVotes(VotesService.countVotes(personInfotmp));
		}
		return "success";
		
	}
	
	public  String  vote(){
		String Can=this.getCandidaters();
	    String Candidaters[]=this.getCandidaters().split(", ");
		voteInfp.setVoterPhone(this.studentPhone);
		voteInfp.setvoter_xuehao(this.studentID);
		for(int i=0; i < Candidaters.length;i++){
			voteInfp.setVoteeId(Integer.parseInt(Candidaters[i]));
			VotesService.inserte(voteInfp);	
		}
		
		return "success";
	}
	public String  voteByIp(){
		int Date = new Date().getDay(); 
		System.out.println(Date);
		if(VotesService.validateByIp(Date,this.clientIp) == true){
			this.hasVote=false;
		}
		else{
			this.hasVote=true;
			return  "success";
			}
		
		String  ClientIp=this.getClientIp();
		String Can=this.getCandidaters();
	    String Candidaters[]=this.getCandidaters().split(", ");
	    if(this.studentPhone != null){
		voteInfp.setVoterPhone(this.studentPhone);
	    }
		voteInfp.setVoter_ip(ClientIp);
	    voteInfp.setVote_time(Date);
	    if(this.studentID != null){
		voteInfp.setvoter_xuehao(this.studentID);
	    }
		for(int i=0; i < Candidaters.length;i++){
			voteInfp.setVoteeId(Integer.parseInt(Candidaters[i]));
			VotesService.inserte(voteInfp);	
		}
		return  "success";
	}
	
	public  String validateByIp(){
		int Date = new Date().getDay(); 
		System.out.println(Date);
		if(VotesService.validateByIp( Date,this.clientIp) == true){
			this.hasVote=false;
		}
		else{
			this.hasVote=true;
			}
			return "success";
	}
	public String   validatee(){
		int Date = new Date().getDay(); 
		if(VotesService.validatee(Date,this.voter_xuehao) == true){
			
			this.hasVote=false;
		}
		else{
		this.hasVote=true;
		}
		return "success";
	}
	
	
}
