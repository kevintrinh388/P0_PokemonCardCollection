package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.CardType;
import com.revature.utils.ConnectionUtil;

public class CardTypeDAO implements CardTypeDAOInterface{

	@Override
	public CardType getCardTypeById(int card_type_id) {
		// get card type by its id
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM card_types WHERE card_type_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, card_type_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CardType cardType = new CardType(
						rs.getInt("card_type_id"),
						rs.getString("card_type_name")
				);
				return cardType;
			}

		}
		catch(SQLException e) {
			System.out.println("GET CARD TYPE BY ID FAILED");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CardType> getAllCardTypes() {
		// get all card types in the db
		try(Connection conn = ConnectionUtil.getConnection()){
			ArrayList<CardType> types = new ArrayList<>();
			String sql = "SELECT * FROM card_types;";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				CardType type = new CardType(
						rs.getInt("card_type_id"),
						rs.getString("card_type_name")
				);
				types.add(type);
			}
			
			return types;
		}
		catch(SQLException e) {
			System.out.println("GET ALL CARD TYPES FAILED");
			e.printStackTrace();
		}
		return null;
	}

}
