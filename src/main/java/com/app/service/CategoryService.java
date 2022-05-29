package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Category;
import com.app.reposity.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;

	public Category saveCategory(Category category) {
		return repository.save(category);
	}

	public List<Category> getCategory() {
		return repository.findAll();
	}

	public Category getCategoryById(int id) {
		return repository.findCategoryById(id);
	}
	
	public Category updateCategory(Category categoryDetails) {
        Category existingCategory = repository.findById(categoryDetails.getId()).orElse(null);
        existingCategory.setName(categoryDetails.getName());
        existingCategory.setStatus(categoryDetails.getStatus());
        existingCategory.setCreated_date(categoryDetails.getCreated_date());
        return repository.save(existingCategory);
    }

	public void deleteCategory(int id) {
		repository.deleteById(id);
		
	}
	public List<Category> searchCategoryByName(String name) {
		return repository.searchCategoryByName(name);
	}
}
