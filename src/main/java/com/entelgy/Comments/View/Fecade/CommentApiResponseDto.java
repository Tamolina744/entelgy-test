package com.entelgy.Comments.View.Fecade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentApiResponseDto {
	
	 private int postId;
	 private int id;
	 private String name;
	 private String email;
	 private String body;
	 
}
