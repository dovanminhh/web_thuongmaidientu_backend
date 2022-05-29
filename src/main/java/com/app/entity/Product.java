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
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "image")
	private String image;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "price")
	private double price;
	@Column(name = "sale_price")
	private double sale_price;
	@Column(name = "description")
	private String description;
	@Column(name = "insurance")
	private String insurance;
	@Column(name = "status")
	private short status;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@CreationTimestamp
	@Column(name = "created_date")
	private Date created_date;
	
	@ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category objCat;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, String image, int quantity, double price, double sale_price, String description,
			String insurance, short status, Date created_date, Category objCat) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.quantity = quantity;
		this.price = price;
		this.sale_price = sale_price;
		this.description = description;
		this.insurance = insurance;
		this.status = status;
		this.created_date = created_date;
		this.objCat = objCat;
	}

	public Product(String name, String image, int quantity, double price, double sale_price, String description,
			String insurance, short status, Date created_date, Category objCat) {
		super();
		this.name = name;
		this.image = image;
		this.quantity = quantity;
		this.price = price;
		this.sale_price = sale_price;
		this.description = description;
		this.insurance = insurance;
		this.status = status;
		this.created_date = created_date;
		this.objCat = objCat;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSale_price() {
		return sale_price;
	}

	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Category getObjCat() {
		return objCat;
	}

	public void setObjCat(Category objCat) {
		this.objCat = objCat;
	}

	
	

	
	
}
