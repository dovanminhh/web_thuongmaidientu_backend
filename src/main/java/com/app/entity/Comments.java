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


@Entity
@Table(name = "comments")

public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "note")
	private String note;
	@Column(name = "start")
	private int start;
	@Column(name = "status")
	private int status;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@CreationTimestamp
	@Column(name = "created_date")
	private Date created_date;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer objCus;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product objProduct;

	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comments(int id, String note, int start, int status, Date created_date, Customer objCus,
			Product objProduct) {
		super();
		this.id = id;
		this.note = note;
		this.start = start;
		this.status = status;
		this.created_date = created_date;
		this.objCus = objCus;
		this.objProduct = objProduct;
	}

	public Comments(String note, int start, int status, Date created_date, Customer objCus, Product objProduct) {
		super();
		this.note = note;
		this.start = start;
		this.status = status;
		this.created_date = created_date;
		this.objCus = objCus;
		this.objProduct = objProduct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public Product getObjProduct() {
		return objProduct;
	}

	public void setObjProduct(Product objProduct) {
		this.objProduct = objProduct;
	}

	
}
