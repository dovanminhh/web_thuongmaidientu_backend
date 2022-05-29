package com.app.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
		
	@Query("select c from Category c where c.name like %:name%")
	List<Category> searchCategoryByName(@Param("name") String name);
	@Transactional
	Category findCategoryById(Integer id);
}
