package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.CardRarityDAO;
import com.revature.models.CardRarity;

import io.javalin.http.Handler;

public class CardRarityController {
	CardRarityDAO cDAO = new CardRarityDAO();
	
	public Handler getAllCardRaritiesHandler = (ctx) -> {
		if(AuthController.ses != null) { // if user is logged in
			ArrayList<CardRarity> rarities = cDAO.getAllCardRarities();
			Gson gson = new Gson();
			String raritiesJSON = gson.toJson(rarities);
			
			ctx.result(raritiesJSON);
			ctx.status(200);
		}
		else { // if user is not logged in
			ctx.result("YOU ARE NOT LOGGED IN");
			ctx.status(401);
		}
		
	};
}
