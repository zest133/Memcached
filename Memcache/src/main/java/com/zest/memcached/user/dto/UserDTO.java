package com.zest.memcached.user.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="user")
//중요!!!!!!!!!!!!!!!!!! memcached 할때!!!!
public class UserDTO implements Serializable{
	
	@Id
	private long idx;
	@Column(unique=true,nullable=false)
	private String id;
	@Column(nullable=false)
	private String pwd;
	
	private String email;
	@Column(nullable=false)
	private String name;
	
	
	public UserDTO(){
		
	}
	public UserDTO(long idx, String id, String pwd, String email, String name){
		this.idx = idx;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.name = name;
	}
	
	public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
