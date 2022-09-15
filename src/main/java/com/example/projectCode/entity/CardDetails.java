package com.example.projectCode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cardPayment")
public class CardDetails {
	
	
	@Id
	@Column(name="payId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="cardHolderName")
	private String cardHolderName;
	
	@Column(name="cardNumber")
	private String cardNumber;
	
	@Column(name="cardExpir")
	private String cardExpir;
	
	@Column(name="cvv")
	private String cvv;
	
	
	//No field constructor
	public CardDetails() {}
	
	//field constructor
	public CardDetails(String cardHolderName, String cardNumber, String cardExpir, String cvv) {
		super();
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.cardExpir = cardExpir;
		this.cvv = cvv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardExpir() {
		return cardExpir;
	}

	public void setCardExpir(String cardExpir) {
		this.cardExpir = cardExpir;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	
	
	
	

}
