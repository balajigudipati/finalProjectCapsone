package com.example.projectCode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectCode.entity.CardDetails;
import com.example.projectCode.repository.CardDetailsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin("*")
@RequestMapping(path = "/api/cardDetails")
public class CardDetailsController {
	
	
	@Autowired
	CardDetailsRepository cardRepository;
	
	
	
	@PostMapping("/save" )
	public org.springframework.http.ResponseEntity.BodyBuilder saveCardDetails(
			@RequestParam("cardHolderName") String cardHolderName,
			@RequestParam("cardNumber") String cardNumber,
			@RequestParam("cardExpir") String cardExpir,
			@RequestParam("cvv") String cvv){
		
		CardDetails payment=new CardDetails(
				cardHolderName,
				cardNumber,
				cardExpir,
				cvv
				);
		
		
		cardRepository.save(payment);		
		
		return null;
	}
}
