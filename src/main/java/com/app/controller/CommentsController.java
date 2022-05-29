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

import com.app.entity.Comments;
import com.app.service.CommentService;
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/rest/admin/")
public class CommentsController {
	@Autowired
	private CommentService service;
	
	@GetMapping("comments")
	public List<Comments> findAllComments(){
		return service.getAllCommentsList();
	}
	@PostMapping(value = "comments/addComments")
	public Comments addComments(@RequestBody Comments comments) {
		return service.addComments(comments);
	}
	@GetMapping("comments/commentsById/{id}")
	public Comments findCommentsById(@PathVariable int id) {
		return service.getCommentsById(id);
	}
	@PutMapping("comments/update-comments/{id}")
	public Comments updateComments(@RequestBody Comments comments) {
		return service.updateComments(comments);
	}
	@DeleteMapping("comments/delete/{id}")
	public ResponseEntity<?> deleteComments(@PathVariable int id){
		service.deleteCommnets(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("comments/commentsByProduct/{product_id}")
	public List<Comments> getCommentsByProduct(@PathVariable int product_id){
		return service.getCommentsByProduct(product_id);
	}
	
	
}	












