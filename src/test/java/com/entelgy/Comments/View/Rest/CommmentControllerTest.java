package com.entelgy.Comments.View.Rest;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.entelgy.Comments.Common.ConstantsTest;
import com.entelgy.Comments.Service.CommentService;
import com.entelgy.Comments.View.Fecade.InputRequestDto;
import com.entelgy.Comments.View.Fecade.ProcessResponseDto;
import com.google.gson.Gson;

@SpringBootTest
@AutoConfigureMockMvc
class CommmentControllerTest {
	
	public static final String URL_VALIDATION = "https://jsonplaceholder.typicode.com/comments";
	public static final String URL_INVALID = "https://jsonplaceholder.typicode.com/post";
	public static final int STATUS_400 = 400;
	
    @Autowired
    CommentController commentController;

    @Autowired
    private MockMvc mockMvc;
    
	@Autowired
	CommentService commentService;
    
	@Test
	@DisplayName("Validar CommentController")
	public void ValidarControllerOk() {
		
		InputRequestDto inputRequestDto = new InputRequestDto();
		inputRequestDto.setUrl(URL_VALIDATION);
        String json = new Gson().toJson(inputRequestDto);
        
        try {
	        mockMvc.perform(
	                post("/comments/process")
	                        .accept(MediaType.APPLICATION_JSON)
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(json))
	                .andExpect(status().isOk())
	        		.andExpect(content().json(ConstantsTest.API_RESPONSE));
        }catch(Exception e) {
        	System.out.print(e.getMessage());
        }
		
	}
	
	@Test
	@DisplayName("Validar Url Invalido")
	public void ValidarControllerFail() {
		
		InputRequestDto inputRequestDto = new InputRequestDto();
		inputRequestDto.setUrl(URL_INVALID);
        String json = new Gson().toJson(inputRequestDto);
        
        try {
	        mockMvc.perform(
	                post("/comments/process")
	                        .accept(MediaType.APPLICATION_JSON)
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(json))
	                .andExpect(status().is(STATUS_400));
        }catch(Exception e) {
        	System.out.print(e.getMessage());
        }
		
	}
	
	@Test
	@DisplayName("Validar Response from Service")
    public void ValidarResponseFromApi() {
		ProcessResponseDto processResponseDto = commentService.ProcessComments(URL_VALIDATION);
		assertNotNull(processResponseDto);
    }

}
