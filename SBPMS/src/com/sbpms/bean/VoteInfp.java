package com.sbpms.bean;

import java.sql.Date;

/**
 * VoteInfp entity. @author MyEclipse Persistence Tools
 */

public class VoteInfp implements java.io.Serializable {

	// Fields
	private  int   vote_time;
	

	public int getVote_time() {
		return vote_time;
	}

	public void setVote_time(int vote_time) {
		this.vote_time = vote_time;
	}

	private String voter_ip;
	public String getVoter_ip() {
		return voter_ip;
	}

	public void setVoter_ip(String voter_ip) {
		this.voter_ip = voter_ip;
	}

	private Integer id;
	private String voter_xuehao;
	private String voterPhone;
	public String getVoter_xuehao() {
		return voter_xuehao;
	}

	public void setVoter_xuehao(String voter_xuehao) {
		this.voter_xuehao = voter_xuehao;
	}

	public String getVoterPhone() {
		return voterPhone;
	}

	public void setVoterPhone(String voterPhone) {
		this.voterPhone = voterPhone;
	}

	private Integer voteeId;

	// Constructors

	/** default constructor */
	public VoteInfp() {
	}

	/** minimal constructor */
	public VoteInfp(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public VoteInfp(Integer id, String voter_xuehao, String votePhone,
			Integer voteeId) {
		this.id = id;
		this.voter_xuehao = voter_xuehao;
		this.voterPhone = votePhone;
		this.voteeId = voteeId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getvoter_xuehao() {
		return this.voter_xuehao;
	}

	public void setvoter_xuehao(String voter_xuehao) {
		this.voter_xuehao = voter_xuehao;
	}

	

	public Integer getVoteeId() {
		return this.voteeId;
	}

	public void setVoteeId(Integer voteeId) {
		this.voteeId = voteeId;
	}

}