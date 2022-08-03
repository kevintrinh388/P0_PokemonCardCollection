package com.revature.models;

public class CardCondition {
	private int card_condition_id;
	private String card_condition_name;
	
	
	public CardCondition() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CardCondition(int card_condition_id, String card_condition_name) {
		super();
		this.card_condition_id = card_condition_id;
		this.card_condition_name = card_condition_name;
	}
	public CardCondition(String card_condition_name) {
		super();
		this.card_condition_name = card_condition_name;
	}
	public int getCard_condition_id() {
		return card_condition_id;
	}
	public void setCard_condition_id(int card_condition_id) {
		this.card_condition_id = card_condition_id;
	}
	public String getCard_condition_name() {
		return card_condition_name;
	}
	public void setCard_condition_name(String card_condition_name) {
		this.card_condition_name = card_condition_name;
	}
	
	@Override
	public String toString() {
		return "CardCondition [card_condition_id=" + card_condition_id + ", card_condition_name=" + card_condition_name
				+ "]";
	}
	
	
	
}
