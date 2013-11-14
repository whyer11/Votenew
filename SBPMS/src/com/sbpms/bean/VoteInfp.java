package com.sbpms.bean;

/**
 * VoteInfp entity. @author MyEclipse Persistence Tools
 */

public class VoteInfp implements java.io.Serializable {

	// Fields

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