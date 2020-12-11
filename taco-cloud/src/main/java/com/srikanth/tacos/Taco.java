package com.srikanth.tacos;
import java.util.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class Taco {
	
	@NotNull
	@Size(min=5,message="Name must be atleast 5 characters")
	private String name;
	
	@Size(min=1,message="Select atleast 1 ingredient")
	private List<String> ingredients;
}
