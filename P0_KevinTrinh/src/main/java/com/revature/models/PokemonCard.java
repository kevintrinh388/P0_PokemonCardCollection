package com.revature.models;

public class PokemonCard {
	private int pokemon_card_id;
	private String pokemon_card_name;
	private double pokemon_card_price;
	private String pokemon_card_number;
	private String pokemon_card_set;
	private int pokemon_card_rarity_fk;
	private int pokemon_card_condition_fk;
	private int pokemon_card_type_fk;
	private int pokemon_card_user_fk;
	
	private CardRarity pokemon_card_rarity;
	private CardCondition pokemon_card_condition;
	private CardType pokemon_card_type;
	
	// CONSTRUCTORS
	public PokemonCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PokemonCard(int pokemon_card_id, String pokemon_card_name, double pokemon_card_price,
			String pokemon_card_number, String pokemon_card_set, int pokemon_card_rarity_fk,
			int pokemon_card_condition_fk, int pokemon_card_type_fk, int pokemon_card_user_fk) {
		super();
		this.pokemon_card_id = pokemon_card_id;
		this.pokemon_card_name = pokemon_card_name;
		this.pokemon_card_price = pokemon_card_price;
		this.pokemon_card_number = pokemon_card_number;
		this.pokemon_card_set = pokemon_card_set;
		this.pokemon_card_rarity_fk = pokemon_card_rarity_fk;
		this.pokemon_card_condition_fk = pokemon_card_condition_fk;
		this.pokemon_card_type_fk = pokemon_card_type_fk;
		this.pokemon_card_user_fk = pokemon_card_user_fk;
	}
	public PokemonCard(String pokemon_card_name, double pokemon_card_price, String pokemon_card_number,
			String pokemon_card_set, CardRarity pokemon_card_rarity, CardCondition pokemon_card_condition,
			CardType pokemon_card_type, int pokemon_card_user_fk) {
		super();
		this.pokemon_card_name = pokemon_card_name;
		this.pokemon_card_price = pokemon_card_price;
		this.pokemon_card_number = pokemon_card_number;
		this.pokemon_card_set = pokemon_card_set;
		this.pokemon_card_rarity = pokemon_card_rarity;
		this.pokemon_card_condition = pokemon_card_condition;
		this.pokemon_card_type = pokemon_card_type;
		this.pokemon_card_user_fk = pokemon_card_user_fk;
	}
	
	public PokemonCard(int pokemon_card_id, String pokemon_card_name, double pokemon_card_price,
			String pokemon_card_number, String pokemon_card_set, CardRarity pokemon_card_rarity,
			CardCondition pokemon_card_condition, CardType pokemon_card_type, int pokemon_card_user_fk) {
		super();
		this.pokemon_card_id = pokemon_card_id;
		this.pokemon_card_name = pokemon_card_name;
		this.pokemon_card_price = pokemon_card_price;
		this.pokemon_card_number = pokemon_card_number;
		this.pokemon_card_set = pokemon_card_set;
		this.pokemon_card_rarity = pokemon_card_rarity;
		this.pokemon_card_condition = pokemon_card_condition;
		this.pokemon_card_type = pokemon_card_type;
		this.pokemon_card_user_fk = pokemon_card_user_fk;
	}
	public int getPokemon_card_id() {
		return pokemon_card_id;
	}
	public void setPokemon_card_id(int pokemon_card_id) {
		this.pokemon_card_id = pokemon_card_id;
	}
	public String getPokemon_card_name() {
		return pokemon_card_name;
	}
	public void setPokemon_card_name(String pokemon_card_name) {
		this.pokemon_card_name = pokemon_card_name;
	}
	public double getPokemon_card_price() {
		return pokemon_card_price;
	}
	public void setPokemon_card_price(double pokemon_card_price) {
		this.pokemon_card_price = pokemon_card_price;
	}
	public String getPokemon_card_number() {
		return pokemon_card_number;
	}
	public void setPokemon_card_number(String pokemon_card_number) {
		this.pokemon_card_number = pokemon_card_number;
	}
	public String getPokemon_card_set() {
		return pokemon_card_set;
	}
	public void setPokemon_card_set(String pokemon_card_set) {
		this.pokemon_card_set = pokemon_card_set;
	}
	public int getPokemon_card_rarity_fk() {
		return pokemon_card_rarity_fk;
	}
	public void setPokemon_card_rarity_fk(int pokemon_card_rarity_fk) {
		this.pokemon_card_rarity_fk = pokemon_card_rarity_fk;
	}
	public int getPokemon_card_condition_fk() {
		return pokemon_card_condition_fk;
	}
	public void setPokemon_card_condition_fk(int pokemon_card_condition_fk) {
		this.pokemon_card_condition_fk = pokemon_card_condition_fk;
	}
	public int getPokemon_card_type_fk() {
		return pokemon_card_type_fk;
	}
	public void setPokemon_card_type_fk(int pokemon_card_type_fk) {
		this.pokemon_card_type_fk = pokemon_card_type_fk;
	}
	public int getPokemon_card_user_fk() {
		return pokemon_card_user_fk;
	}
	public void setPokemon_card_user_fk(int pokemon_card_user_fk) {
		this.pokemon_card_user_fk = pokemon_card_user_fk;
	}
	public CardRarity getPokemon_card_rarity() {
		return pokemon_card_rarity;
	}
	public void setPokemon_card_rarity(CardRarity pokemon_card_rarity) {
		this.pokemon_card_rarity = pokemon_card_rarity;
	}
	public CardCondition getPokemon_card_condition() {
		return pokemon_card_condition;
	}
	public void setPokemon_card_condition(CardCondition pokemon_card_condition) {
		this.pokemon_card_condition = pokemon_card_condition;
	}
	public CardType getPokemon_card_type() {
		return pokemon_card_type;
	}
	public void setPokemon_card_type(CardType pokemon_card_type) {
		this.pokemon_card_type = pokemon_card_type;
	}
	
	@Override
	public String toString() {
		return "PokemonCard [pokemon_card_id=" + pokemon_card_id + ", pokemon_card_name=" + pokemon_card_name
				+ ", pokemon_card_price=" + pokemon_card_price + ", pokemon_card_number=" + pokemon_card_number
				+ ", pokemon_card_set=" + pokemon_card_set + ", pokemon_card_rarity_fk=" + pokemon_card_rarity_fk
				+ ", pokemon_card_condition_fk=" + pokemon_card_condition_fk + ", pokemon_card_type_fk="
				+ pokemon_card_type_fk + ", pokemon_card_user_fk=" + pokemon_card_user_fk + ", pokemon_card_rarity="
				+ pokemon_card_rarity + ", pokemon_card_condition=" + pokemon_card_condition + ", pokemon_card_type="
				+ pokemon_card_type + "]";
	}
	
	
	
	
	
	
	
}
