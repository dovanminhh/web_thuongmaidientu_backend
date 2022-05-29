package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Comments;
import com.app.reposity.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository repository;
	
	public List<Comments> getAllCommentsList(){
		return repository.findAll();
	}
	
	public Comments getCommentsById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Comments addComments(Comments comments) {
		return  repository.save(comments);
	}
	
	public Comments updateComments(Comments comments) {
		Comments existingComments = repository.findById(comments.getId()).orElse(null);
		existingComments.setNote(comments.getNote());
		existingComments.setStart(comments.getStart());
		existingComments.setStatus(comments.getStatus());
		existingComments.setObjCus(comments.getObjCus());
		existingComments.setObjProduct(comments.getObjProduct());
		return repository.save(existingComments);
	}
	
	public void deleteCommnets(int id) {
		repository.deleteById(id);
	}
	
	public List<Comments> getCommentsByProduct(int product_id){
		return repository.getCommentsByProduct(product_id);
	}
	
	
}
