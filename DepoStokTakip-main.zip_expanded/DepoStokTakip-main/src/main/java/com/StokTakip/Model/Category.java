package com.StokTakip.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int user_id;
	private String name;
	private String description;
	private boolean deletable;
	private Date created_at;
	
	
	
	public Category(int user_id, String name, String description, boolean deletable) {
		super();
		
		this.user_id = user_id;
		this.name = name;
		this.description = description;
		this.deletable = deletable;
	
	}
	
	public Category(int user_id, String name, String description,Date created_at,boolean deletable) {
		super();
		
		this.user_id = user_id;
		this.name = name;
		this.description = description;
		this.created_at = created_at;
		this.deletable = deletable;
	
	}


	public Category( int user_id, String name, String description) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.description = description;
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}



	public boolean isDeletable() {
		return deletable;
	}


	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}


	

	public Date getCreated_at() {
		return created_at;
	}



	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}



	@Override
	public String toString() {
		return "Category [id=" + id + ", user_id=" + user_id + ", name=" + name + ", description=" + description
				+ ", deletable=" + deletable + ", created_at=" + created_at + "]";
	}



	

	
	
	
	
	
	
}
