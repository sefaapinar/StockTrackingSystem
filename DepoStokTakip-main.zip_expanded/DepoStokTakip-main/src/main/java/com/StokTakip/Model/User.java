package com.StokTakip.Model;

  
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name = "findByEmail",query = "select u from User u where u.email= ?1")
@NamedQuery(name = "User.isExists",query = "select count(u) from User u where u.email= ?1")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private Date created_at;
	private Date updated_at;
	
	
	

	public User(int id, String name, String email, String password, Date updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.updated_at = updated_at;
	}

	public User( String name, String email, String password, Date updated_at) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.updated_at = updated_at;
	}
	
	public User( String name, String email, String password,Date created_at ,Date updated_at) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.updated_at = updated_at;
		this.created_at = created_at;
	}
	
	public User() {
	
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", created_at="
				+ created_at + ", updated_at=" + updated_at + "]";
	}
	
	
	
	

}
