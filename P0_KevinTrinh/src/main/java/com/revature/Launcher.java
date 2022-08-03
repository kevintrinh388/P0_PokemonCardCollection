package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.CardConditionController;
import com.revature.controllers.CardRarityController;
import com.revature.controllers.CardTypeController;
import com.revature.controllers.PokemonCardController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		System.out.println("POKEMON CARD COLLECTION TRACKER APP");
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL :)");
		}
		catch(SQLException e) {
			// if connection fails, catch the SQLexception and print the stack trace(error log)
			System.out.println("CONNECTION NOT SUCCESSFUL :( ");
			e.printStackTrace();
		}
		
		Javalin app = Javalin.create(
					config -> {
						config.enableCorsForAllOrigins();
					}
		).start(3000);
		
		// CONTROLLERS
		AuthController ac = new AuthController();
		
		PokemonCardController pc = new PokemonCardController();
		CardConditionController cc = new CardConditionController();
		CardRarityController cr = new CardRarityController();
		CardTypeController ct = new CardTypeController();
		
		// ENDPOINTS
		app.post("/login", ac.loginHandler);
		
		app.get("/cards", pc.getAllCardsHandler);
		app.get("/cards/:card_id", pc.getCardByIdHandler);
		app.get("/cards/user/:user_id", pc.getAllUserCardsHandler);
		
		app.get("/conditions", cc.getAllCardConditionsHandler);
		app.get("/rarities", cr.getAllCardRaritiesHandler);
		app.get("/types", ct.getAllCardTypesHandler);
		
		app.post("/cards", pc.insertPokemonCardHandler);
		
		app.put("/cards/condition/:card_id", pc.updatePokemonCardConditionHandler);
		
		app.delete("/cards/:card_id", pc.deletePokemonCardHandler);

	}

}
