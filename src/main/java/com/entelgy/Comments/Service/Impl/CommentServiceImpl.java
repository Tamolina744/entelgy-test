package com.entelgy.Comments.Service.Impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entelgy.Comments.Service.CommentService;
import com.entelgy.Comments.View.Fecade.CommentApiResponseDto;
import com.entelgy.Comments.View.Fecade.ProcessResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	@Override
	public ProcessResponseDto ProcessComments(String url) {
		RestTemplate restTemplate = new RestTemplate();
		ProcessResponseDto processResponseDto = new ProcessResponseDto();
		CommentApiResponseDto[] commentApiResponseDto  = restTemplate.getForObject(url, CommentApiResponseDto[].class);
		ArrayList<Object> data  = ProcessData(commentApiResponseDto);
		processResponseDto.setData(data);
		return processResponseDto;
	}
	
	
	public ArrayList<Object> ProcessData(CommentApiResponseDto[] commentApiResponseDto) {
		ArrayList<Object> data = new ArrayList<Object>();
		for(int i = 0; i< commentApiResponseDto.length;i++) {
			data.add(commentApiResponseDto[i].getPostId() + "|" + 
						commentApiResponseDto[i].getId() + "|" + commentApiResponseDto[i].getEmail()); 
		}
		return data;
	}

}
