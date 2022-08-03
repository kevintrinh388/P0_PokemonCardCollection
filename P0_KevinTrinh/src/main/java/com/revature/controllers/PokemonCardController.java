package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.PokemonCardDAO;
import com.revature.models.PokemonCard;

import io.javalin.http.Handler;

public class PokemonCardController {
	PokemonCardDAO pDAO = new PokemonCardDAO();
	
	public Handler getAllCardsHandler = (ctx) -> {
		if(AuthController.ses != null) { // if user is logged in
			ArrayList<PokemonCard> cards = pDAO.getAllPokemonCards();
			Gson gson = new Gson();
			String jsonCards = gson.toJson(cards);
			
			ctx.result(jsonCards);
			ctx.status(200);
		}
		else { // if user is not logged in
			ctx.result("YOU ARE NOT LOGGED IN");
			ctx.status(401);
		}
		
	};
	
	public Handler getCardByIdHandler = (ctx) -> {
		if(AuthController.ses != null) { // if user is logged in
			int pokemon_card_id = Integer.parseInt(ctx.pathParam("card_id"));
			Gson gson = new Gson();
			PokemonCard pokemonCard = pDAO.getPokemonCardById(pokemon_card_id);
			String pokemonCardJSON = gson.toJson(pokemonCard);
			
			ctx.result(pokemonCardJSON);
			ctx.status(200);
		}
		else { // if user is not logged in
			ctx.result("YOU ARE NOT LOGGED IN");
			ctx.status(401);
		}
		
	};
	
	public Handler getAllUserCardsHandler = (ctx) -> {
		if(AuthController.ses != null) { // if user is logged in
			int user_id = Integer.parseInt(ctx.pathParam("user_id"));
		
			ArrayList<PokemonCard> cards = pDAO.getUserPokemonCards(user_id);
			Gson gson = new Gson();
			String jsonCards = gson.toJson(cards);
			
			ctx.result(jsonCards);
			ctx.status(200);
		}
		else { // if user is not logged in
			ctx.result("YOU ARE NOT LOGGED IN");
			ctx.status(401);
		}
		
	};
	
	public Handler updatePokemonCardConditionHandler = (ctx) -> {
		if(AuthController.ses != null) { // if user is logged in
			int card_id = Integer.parseInt(ctx.pathParam("card_id"));
			int condition_id = Integer.parseInt(ctx.body());
			
			if(pDAO.updatePokemonCardCondition(card_id, condition_id)) {
				ctx.status(202);
			}
			else {
				ctx.status(406);
			}
		}
		else { // if user is not logged in
			ctx.result("YOU ARE NOT LOGGED IN");
			ctx.status(401);
		}
		
	};
	
	public Handler insertPokemonCardHandler = (ctx) -> {
		if(AuthController.ses != null) { // if user is logged in
			String body = ctx.body();
			Gson gson = new Gson();
			
			PokemonCard pokemonCard = gson.fromJson(body, PokemonCard.class);
			
			if(pDAO.insertPokemonCard(pokemonCard)) {
				ctx.status(202);
			}
			else {
				ctx.status(406);
			}
		}
		else { // if user is not logged in
			ctx.result("YOU ARE NOT LOGGED IN");
			ctx.status(401);
		}
		
	};
	
	public Handler deletePokemonCardHandler = (ctx) -> {
		if(AuthController.ses != null) { // if user is logged in
			int pokemon_card_id = Integer.parseInt(ctx.pathParam("card_id"));
		
			if(pDAO.deletePokemonCard(pokemon_card_id)) {
				ctx.status(202);
			}
			else {
				ctx.status(406);
			}
		}
		else { // if user is not logged in
			ctx.result("YOU ARE NOT LOGGED IN");
			ctx.status(401);
		}

	};
}
