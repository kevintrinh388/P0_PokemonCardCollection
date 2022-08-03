package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.CardType;

public interface CardTypeDAOInterface {
	// get card type by its id
	public CardType getCardTypeById(int card_type_id);
	
	// get all card types in the db
	public ArrayList<CardType> getAllCardTypes();
}
