package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.PokemonCard;

public interface PokemonCardDAOInterface {
	// get all Pokemon cards in the database
	public ArrayList<PokemonCard> getAllPokemonCards();
	
	// get Pokemon card by id
	public PokemonCard getPokemonCardById(int pokemon_card_id);
	
	// get all of the user's Pokemon cards
	public ArrayList<PokemonCard> getUserPokemonCards(int user_id);
	
	// insert a PokemonCard into the database
	public boolean insertPokemonCard(PokemonCard pokemonCard);
	
	// delete a PokemonCard from the database
	public boolean deletePokemonCard(int pokemon_card_id);
	
	// updates a PokemonCard's condition
	public boolean updatePokemonCardCondition(int pokemon_card_id, int card_condition_id);
}
