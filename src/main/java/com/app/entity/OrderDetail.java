package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "total_price")
	private float total_price;

	@ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order objOrd;
	
	@ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product objPro;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(int id, int quantity, float total_price, Order objOrd, Product objPro) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.total_price = total_price;
		this.objOrd = objOrd;
		this.objPro = objPro;
	}

	public OrderDetail(int quantity, float total_price, Order objOrd, Product objPro) {
		super();
		this.quantity = quantity;
		this.total_price = total_price;
		this.objOrd = objOrd;
		this.objPro = objPro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public Order getObjOrd() {
		return objOrd;
	}

	public void setObjOrd(Order objOrd) {
		this.objOrd = objOrd;
	}

	public Product getObjPro() {
		return objPro;
	}

	public void setObjPro(Product objPro) {
		this.objPro = objPro;
	}
	
}
