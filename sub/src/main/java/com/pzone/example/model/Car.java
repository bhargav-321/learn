package com.pzone.example.model;

public class Car {

	Integer cid;

	String name;

	String owner;

	public Car(Integer cid, String name, String owner) {
		super();
		this.cid = cid;
		this.name = name;
		this.owner = owner; 
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Car [cid=" + cid + ", name=" + name + ", owner=" + owner + "]";
	}

}
