package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.CardRarity;

public interface CardRarityDAOInterface {
	// get card rarity by its id
	public CardRarity getCardRarityById(int card_rarity_id);
	
	// get all card rarities in the db
	public ArrayList<CardRarity> getAllCardRarities();
}
