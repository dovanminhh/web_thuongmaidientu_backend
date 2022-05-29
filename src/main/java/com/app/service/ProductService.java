package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.entity.Product;
import com.app.reposity.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public List<Product> listProduct(){
		return (List<Product>) repository.findAll();
	}
	//phân trang
	public Page<Product> getProduct(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
	return repository.findAll(paging);
	}
	
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Product> findNewProduct(){
		return repository.findNewProduct();
	}
	

	public List<Product> searchProductName(String name){
		return repository.searchProductByName(name);
	}
	public Product updateProduct(Product productDetails) {
        Product existingProduct = repository.findById(productDetails.getId()).orElse(null);
        existingProduct.setName(productDetails.getName());
        existingProduct.setImage(productDetails.getImage());
        existingProduct.setQuantity(productDetails.getQuantity());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setSale_price(productDetails.getSale_price());
        existingProduct.setDescription(productDetails.getDescription());
        existingProduct.setInsurance(productDetails.getInsurance());
        existingProduct.setStatus(productDetails.getStatus());
        existingProduct.setObjCat(productDetails.getObjCat());
        existingProduct.setCreated_date(productDetails.getCreated_date());
        return repository.save(existingProduct);
    }

	public void deleteProduct(int id) {
		repository.deleteById(id);	
	}
	
	public List<Product> getProductByCategory(int categoryId) {
		return repository.findProductByCategory(categoryId);
	}
	
	public List<Product> findByPriceBetween(int min, int max){
		return repository.findByPriceBetween(min, max);
	}
	
	public List<Product> findByBestSalePrice(){
		return repository.findByBestSalePrice();
	}
	
	public List<Product> findByNewHomeProduct(){
		return repository.findNewHomeProduct();
	}
	
	
	
}
