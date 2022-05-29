package com.app.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "or_der")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "phone")
	private String phone;
	@Column(name = "status")
	private int status;
	@Column(name = "note")
	private String note;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@CreationTimestamp
	@Column(name = "created_date")
	private Date created_date;
	
	@ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer objCus;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, String name, String address, String phone, int status, String note, Date created_date,
			Customer objCus) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.note = note;
		this.created_date = created_date;
		this.objCus = objCus;
	}

	public Order(String name, String address, String phone, int status, String note, Date created_date,
			Customer objCus) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.note = note;
		this.created_date = created_date;
		this.objCus = objCus;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Customer getObjCus() {
		return objCus;
	}

	public void setObjCus(Customer objCus) {
		this.objCus = objCus;
	}

	
	
	
}
