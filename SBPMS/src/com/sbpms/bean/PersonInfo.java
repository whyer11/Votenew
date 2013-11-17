package com.sbpms.bean;

/**
 * PersonInfo entity. @author MyEclipse Persistence Tools
 */

public class PersonInfo implements java.io.Serializable {

	// Fields
	private  String  link;
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	private  String  affiliation;
    public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	private  Integer  votes;
	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	private Integer id;
	private String name;
	private Integer pic;
	private String description;
	private Integer aget;
	private String hoppy;

	// Constructors

	/** default constructor */
	public PersonInfo() {
	}

	/** minimal constructor */
	public PersonInfo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public PersonInfo(Integer id, String name, Integer pic, String description,
			Integer aget, String hoppy) {
		this.id = id;
		this.name = name;
		this.pic = pic;
		this.description = description;
		this.aget = aget;
		this.hoppy = hoppy;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPic() {
		return this.pic;
	}

	public void setPic(Integer pic) {
		this.pic = pic;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAget() {
		return this.aget;
	}

	public void setAget(Integer aget) {
		this.aget = aget;
	}

	public String getHoppy() {
		return this.hoppy;
	}

	public void setHoppy(String hoppy) {
		this.hoppy = hoppy;
	}

}