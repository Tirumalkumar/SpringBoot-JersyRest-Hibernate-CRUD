package com.employee.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table(name="employee")
public class Employee {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="employeeid")
    private int employeeid;  
	@Column(name="ename")
    private String ename;
	@Column(name="age")	
	private int age;
	@Column(name="image")
	@Lob
	private byte[] image;
	/**
	 * @return the employeeid
	 */
	public int getEmployeeid() {
		return employeeid;
	}
	/**
	 * @param employeeid the employeeid to set
	 */
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}
	/**
	 * @return the serialversionuid
	 */
	

}
