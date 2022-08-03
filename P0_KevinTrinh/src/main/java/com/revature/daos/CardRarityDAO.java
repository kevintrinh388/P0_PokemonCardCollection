package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.CardRarity;
import com.revature.utils.ConnectionUtil;

public class CardRarityDAO implements CardRarityDAOInterface{

	@Override
	public CardRarity getCardRarityById(int card_rarity_id) {
		//get card rarity by its id
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM card_rarities WHERE card_rarity_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, card_rarity_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CardRarity cardRarity = new CardRarity(
						rs.getInt("card_rarity_id"),
						rs.getString("card_rarity_name")
				);
				return cardRarity;
			}
			
			
		}
		catch(SQLException e) {
			System.out.println("GET CARD RARITY BY ID FAILED");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CardRarity> getAllCardRarities() {
		// get all card rarities in the db
		try(Connection conn = ConnectionUtil.getConnection()){
			ArrayList<CardRarity> rarities = new ArrayList<>();
			String sql = "SELECT * FROM card_rarities;";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				CardRarity rarity = new CardRarity(
						rs.getInt("card_rarity_id"),
						rs.getString("card_rarity_name")
				);
				rarities.add(rarity);
			}
			
			return rarities;
		}
		catch(SQLException e) {
			System.out.println("GET ALL CARD RARITIES FAILED");
			e.printStackTrace();
		}
		return null;
	}
	
	
}
