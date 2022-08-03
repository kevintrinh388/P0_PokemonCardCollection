package com.revature.models;

public class CardType {
	private int card_type_id;
	private String card_type_name;
	
	public CardType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardType(int card_type_id, String card_type_name) {
		super();
		this.card_type_id = card_type_id;
		this.card_type_name = card_type_name;
	}

	public CardType(String card_type_name) {
		super();
		this.card_type_name = card_type_name;
	}

	public int getCard_type_id() {
		return card_type_id;
	}

	public void setCard_type_id(int card_type_id) {
		this.card_type_id = card_type_id;
	}

	public String getCard_type_name() {
		return card_type_name;
	}

	public void setCard_type_name(String card_type_name) {
		this.card_type_name = card_type_name;
	}

	@Override
	public String toString() {
		return "CardType [card_type_id=" + card_type_id + ", card_type_name=" + card_type_name + "]";
	}
	
	
}
