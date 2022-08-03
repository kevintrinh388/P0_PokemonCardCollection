package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.CardCondition;

public interface CardConditionDAOInterface {
	// get card condition by its id
	public CardCondition getCardConditionById(int card_condition_id);
	
	// get all card conditions in the db
	public ArrayList<CardCondition> getAllCardConditions();
	
}
