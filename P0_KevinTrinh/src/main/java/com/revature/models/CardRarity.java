package com.revature.models;

public class CardRarity {
	private int card_rarity_id;
	private String card_rarity_name;
	
	public CardRarity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardRarity(int card_rarity_id, String card_rarity_name) {
		super();
		this.card_rarity_id = card_rarity_id;
		this.card_rarity_name = card_rarity_name;
	}

	public CardRarity(String card_rarity_name) {
		super();
		this.card_rarity_name = card_rarity_name;
	}

	public int getCard_rarity_id() {
		return card_rarity_id;
	}

	public void setCard_rarity_id(int card_rarity_id) {
		this.card_rarity_id = card_rarity_id;
	}

	public String getCard_rarity_name() {
		return card_rarity_name;
	}

	public void setCard_rarity_name(String card_rarity_name) {
		this.card_rarity_name = card_rarity_name;
	}

	@Override
	public String toString() {
		return "CardRarity [card_rarity_id=" + card_rarity_id + ", card_rarity_name=" + card_rarity_name + "]";
	}
	
	
}
