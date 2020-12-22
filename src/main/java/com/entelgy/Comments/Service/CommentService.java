package com.entelgy.Comments.Service;

import org.springframework.stereotype.Service;

import com.entelgy.Comments.View.Fecade.ProcessResponseDto;

@Service
public interface CommentService {
	
	public ProcessResponseDto ProcessComments(String url);
	
}
