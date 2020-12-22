package com.entelgy.Comments.View.Fecade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputRequestDto {
	  
   @NotNull(message = "url no puede ser NULL")
   @NotBlank(message = "url no puede estar en blanco")
   private String url;
}
