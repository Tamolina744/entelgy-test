package com.entelgy.Comments.View.Rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entelgy.Comments.Common.Constants;
import com.entelgy.Comments.Service.CommentService;
import com.entelgy.Comments.View.Fecade.InputRequestDto;
import com.entelgy.Comments.View.Fecade.ProcessResponseDto;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping(value = "/process", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProcessResponseDto> ProcessComments(@Valid @RequestBody InputRequestDto inputRequestDto) {
		 
		ProcessResponseDto processResponseDto = new ProcessResponseDto();
		HttpStatus httpStatus;
		
		if(inputRequestDto.getUrl().equals(Constants.URL_VALIDATION)) {
			processResponseDto= commentService.ProcessComments(inputRequestDto.getUrl());
			httpStatus = HttpStatus.OK;	
		}
		else {
			ArrayList < Object > tempArray = new ArrayList<>();
			tempArray.add("Ingrese una URL correcta");
			processResponseDto.setData(tempArray);
			httpStatus = HttpStatus.BAD_REQUEST;	
		}
		
		return new ResponseEntity<>(processResponseDto, httpStatus);
	}
}
