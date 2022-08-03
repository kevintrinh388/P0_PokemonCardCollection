package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.CardTypeDAO;
import com.revature.models.CardType;

import io.javalin.http.Handler;

public class CardTypeController {
	CardTypeDAO cDAO = new CardTypeDAO();
	
	public Handler getAllCardTypesHandler = (ctx) -> { 
		
		if(AuthController.ses != null) { // if user is logged in
			ArrayList<CardType> types = cDAO.getAllCardTypes();
			Gson gson = new Gson();
			String typesJSON = gson.toJson(types);
			
			ctx.result(typesJSON);
			ctx.status(200);
		}
		else { // if user is not logged in
			ctx.result("YOU ARE NOT LOGGED IN");
			ctx.status(401);
		}
		
	};
}
