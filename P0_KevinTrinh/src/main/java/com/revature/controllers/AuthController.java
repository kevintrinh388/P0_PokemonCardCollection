package com.revature.controllers;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {
	// we need an AuthService
	AuthService as = new AuthService();
	
	//empty HttpSession object that will be filled upon successful login
	public static HttpSession ses;
	
	public Handler loginHandler = (ctx) -> {
		String body = ctx.body();
		Gson gson = new Gson();
		
		LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
		String loginUsername = as.login(lDTO.getUsername(), lDTO.getPassword());
		
		if(loginUsername != null) {
			ses = ctx.req.getSession(); // THIS IS HOW WE CREATE NEW SESSIONS
			ctx.result("WELCOME " + loginUsername + " TO THE POKEMON CARD COLLECTION");
			ctx.status(202);
		}
		else {
			ctx.status(401); // unauthorized
		}
		
	};
}
