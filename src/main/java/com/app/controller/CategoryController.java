package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Category;
import com.app.service.CategoryService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/rest/admin")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@GetMapping("/category")
    public List<Category> findAllCategory() {
        return service.getCategory();
    }
	
	@PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category) {
        return service.saveCategory(category);
    }
	
    @GetMapping("/categoryById/{id}")
    public Category findCategoryById(@PathVariable("id") Integer id) {
        return service.getCategoryById(id);
    }
    @PutMapping("/update/{id}")
    public Category updateCategory(@RequestBody Category category) {
        return service.updateCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
    	service.deleteCategory(id);
    	 return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/category/{name}")
    public List<Category> searchCategoryByName(@PathVariable("name") String name){
    	return service.searchCategoryByName(name);
    }
	
}
