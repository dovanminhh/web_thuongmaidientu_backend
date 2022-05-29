package com.app.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer>{
	
	@Query(nativeQuery = true, value = "select * from comments c where c.product_id = :product_id and status = 1")
	List<Comments> getCommentsByProduct(@Param("product_id") int product_id);
	
	
}
