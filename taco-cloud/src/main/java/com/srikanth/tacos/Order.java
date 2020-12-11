package com.srikanth.tacos;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Digits;
import org.hibernate.validator.constraints.CreditCardNumber;
import lombok.Data;

@Data
public class Order {
	
	@NotBlank(message="Name is required")
	private String name;
	
	@NotBlank(message="Street name is required")
	private String street;
	
	@NotBlank(message="city name is required")
	private String city;
	
	@NotBlank(message="State is required")
	private String state;
	
	@NotBlank(message="zip code is required")
	private String zip;
	
	@CreditCardNumber(message="Not a valid credit card Number")
	private String ccNumber;
	
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
			message="Expiration must be formated in MM/YY")
	private String ccExpiration;
	
	@Digits(integer=3,fraction=0,message="Invalid CVV")
	private String ccCVV;
	
}
