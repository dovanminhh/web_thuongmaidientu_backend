package com.app.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Product;
import com.app.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/rest/admin/")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("product")
	public Page<Product> findAllProduct(@RequestParam(name = "pageNo", required = false,defaultValue = "0") int pageNo, @RequestParam(name="pageSize", required = false, defaultValue = "3") int pageSize){
		return service.getProduct(pageNo, pageSize);
	}
	
	@PostMapping("product/addProduct")
    @ResponseBody
    public Product save(@RequestParam("pro")String pro, @RequestParam("file") MultipartFile file) throws IOException{
		Product prod = new ObjectMapper().readValue(pro,Product.class);
		String path_Directory = "C:\\Users\\T450\\eclipse-workspace\\demo-1\\src\\main\\resources\\static\\images\\";
		String fileName = file.getOriginalFilename();
		Files.copy(file.getInputStream(), Paths.get(path_Directory + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		prod.setImage(fileName);
		return service.saveProduct(prod);
	}
	@GetMapping("product/getImage/{filename}")
	public ResponseEntity<byte[]> getImage(@PathVariable("filename")String filename){
		String path_Directory = "C:\\Users\\T450\\eclipse-workspace\\demo-1\\src\\main\\resources\\static\\images\\";
		byte[] image = new byte[0];
		try {
			image = FileUtils.readFileToByteArray(new File(path_Directory + filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
		
	}
	
    @GetMapping("product/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PutMapping("product/update/{id}")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
    	service.deleteProduct(id);
    	 return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("getProductByCategory/{categoryId}")
    public List<Product> findProductByCategoryId(@PathVariable("categoryId") int categoryId) {
        return service.getProductByCategory(categoryId);
    }
    @GetMapping("product/{name}")
    public List<Product> searchProductByName(@PathVariable("name") String name){
    	return service.searchProductName(name);
    }
    @GetMapping("product/findNewProduct")
    public List<Product> findNewProduct(){
    	return service.findNewProduct();
    }
    
    @GetMapping("product/{min}/{max}")
    public List<Product> findByPriceBetween(@PathVariable("min") int min, @PathVariable("max") int max){
    	return service.findByPriceBetween(min, max);
    }
    @GetMapping("product/sale_price")
    public List<Product> findByBestSalePrice(){
    	return service.findByBestSalePrice();
    }
    @GetMapping("product/new-home")
    public List<Product> findNewHomeProduct(){
    	return service.findByNewHomeProduct();
    }
}
