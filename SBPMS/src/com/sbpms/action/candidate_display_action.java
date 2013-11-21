package com.sbpms.action;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sbpms.bean.PersonInfo;
import com.sbpms.bean.VoteInfp;
import com.sbpms.service.candidate_display_service;
import com.sbpms.service.votesService;
import com.sbpms.util.UdpGetClientMacAddr;
public class candidate_display_action extends ActionSupport implements ServletRequestAware  {
	  private HttpServletRequest request;
	  
	public void setServletRequest(HttpServletRequest request){
		 
		        this.request = request;
		 
		       }

	 ActionContext context=ActionContext.getContext();  
	public ActionContext getContext() {
		return context;
	}
	public void setContext(ActionContext context) {
		this.context = context;
	}
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
	
	public  String  vote() throws Exception{
		String  clientMac=this.getClientMac();
		String Can=this.getCandidaters();
	    String Candidaters[]=this.getCandidaters().split(", ");
	    voteInfp.setVoter_ip(clientMac);
		voteInfp.setVoterPhone(this.studentPhone);
		voteInfp.setvoter_xuehao(this.studentID);
		voteInfp.setVote_time(this.getCurrentDay());
		for(int i=0; i < Candidaters.length;i++){
			voteInfp.setVoteeId(Integer.parseInt(Candidaters[i]));
			VotesService.inserte(voteInfp);	
		}
		
		return "success";
	}
	public String  voteByIp() throws Exception{
		String  clientMac=this.getClientMac();
		if(VotesService.validateByIp(this.getCurrentDay(),clientMac) == true){
			this.hasVote=false;
		}
		else{
			this.hasVote=true;
			return  "success";
			}
		String Can=this.getCandidaters();
	    String Candidaters[]=this.getCandidaters().split(", ");
	  
	    if(this.studentPhone != null){
		voteInfp.setVoterPhone(this.studentPhone);
	    }
		voteInfp.setVoter_ip(clientMac);
	    voteInfp.setVote_time(this.getCurrentDay());
	 /*   if(this.studentID != null){
		voteInfp.setvoter_xuehao(this.studentID);
	    }
	    */
		for(int i=0; i < Candidaters.length;i++){
			voteInfp.setVoteeId(Integer.parseInt(Candidaters[i]));
			VotesService.inserte(voteInfp);	
		}
		return  "success";
	}
	
	public  String validateByIp(){
		 Date dateU=new Date();
	     java.sql.Date date=new java.sql.Date(dateU.getTime());
		System.out.println(date);
		if(VotesService.validateByIp( this.getCurrentDay(),this.clientIp) == true){
			this.hasVote=false;
		}
		else{
			this.hasVote=true;
			}
			return "success";
	}
	public String   validatee() throws Exception{
		String  clientMac=this.getClientMac();
		if(VotesService.validatee(this.getCurrentDay(),this.voter_xuehao) == true && VotesService.validateByIp( this.getCurrentDay(),clientMac) == true){
			
			this.hasVote=false;
		}
		else{
		this.hasVote=true;
		}
		return "success";
	}
	
	public  String  getCurrentDay(){
		 Date dateU=new Date();
	     java.sql.Date date=new java.sql.Date(dateU.getTime());
	     String date_str=String.valueOf(date);
	     String dd = date_str.substring(8,10);
         System.out.println(dd);
         return  dd;
		
	}
	
	public  String  getClientMac() throws Exception {
		String smac = ""; 
		String  sip=this.getIpAddr(request);
		if(sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) { 
		sip = request.getHeader("Proxy-Client-IP"); 
		} 
		if(sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) { 
		sip = request.getHeader("WL-Proxy-Client-IP"); 
		} 
		if(sip == null || sip.length() == 0 || "unknown".equalsIgnoreCase(sip)) { 
		sip = request.getRemoteAddr(); 
		} 
		UdpGetClientMacAddr umac = new UdpGetClientMacAddr(sip); 
		smac = umac.GetRemoteMacAddr();
		return  smac;
	}
	
	public String getIpAddr(HttpServletRequest request) { 
		String ip=null;
	     //  String ip = request.getHeader("x-forwarded-for"); 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getHeader("WL-Proxy-Client-IP"); 
	       } 
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	           ip = request.getRemoteAddr(); 
	       } 
	       return ip; 
	   } 
	
	
}
