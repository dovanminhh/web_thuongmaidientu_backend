package com.app.reposity;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Product;

@Transactional
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{
	
	@Query("select p from Product p where p.name like %:name%")
	List<Product> searchProductByName(@Param("name") String name);
	
	@Query(nativeQuery = true, value = "SELECT * FROM product p WHERE p.category_id =:categoryId")
	List<Product> findProductByCategory(@Param("categoryId") int categoryId);
	
	@Query(nativeQuery = true, value = "select top 3 p.* from Product p order by p.id desc")
	List<Product> findNewProduct();
	
	@Query(nativeQuery = true, value = "SELECT * FROM product p WHERE p.price BETWEEN :min AND :max ORDER BY p.price ASC")
	List<Product> findByPriceBetween(@Param("min") int min, @Param("max") int max);
	
	@Query(nativeQuery = true, value = "select * from product p where p.sale_price > 1000000")
	List<Product> findByBestSalePrice();
	
	@Query(nativeQuery = true, value = "select top 4 p.* from Product p order by p.id desc")
	List<Product> findNewHomeProduct();
	
	
}
