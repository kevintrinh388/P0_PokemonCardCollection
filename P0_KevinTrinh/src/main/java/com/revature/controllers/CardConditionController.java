package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.CardConditionDAO;
import com.revature.models.CardCondition;

import io.javalin.http.Handler;

public class CardConditionController {
	CardConditionDAO cDAO = new CardConditionDAO();
	
	public Handler getAllCardConditionsHandler = (ctx) -> {
		if(AuthController.ses != null) { // if user is logged in
			ArrayList<CardCondition> conditions = cDAO.getAllCardConditions();
			Gson gson = new Gson();
			
			String conditionsJSON = gson.toJson(conditions);
			ctx.result(conditionsJSON);
			
			ctx.status(200);
		}
		else { // if user is not logged in
			ctx.result("YOU ARE NOT LOGGED IN");
			ctx.status(401);
		}
		
	};
}
