package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.CardCondition;
import com.revature.utils.ConnectionUtil;

public class CardConditionDAO implements CardConditionDAOInterface{

	@Override
	public CardCondition getCardConditionById(int card_condition_id) {
		// get card condition by its id
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM card_conditions WHERE card_condition_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, card_condition_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CardCondition cardCondition = new CardCondition(
						rs.getInt("card_condition_id"),
						rs.getString("card_condition_name")
				);
				return cardCondition;
			}
			
			
		}
		catch(SQLException e) {
			System.out.println("GET CARD CONDITION BY ID FAILED");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<CardCondition> getAllCardConditions() {
		// get all card conditions in the db
		try(Connection conn = ConnectionUtil.getConnection()){
			ArrayList<CardCondition> conditions = new ArrayList<>();
			String sql = "SELECT * FROM card_conditions;";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				CardCondition condition = new CardCondition(
						rs.getInt("card_condition_id"),
						rs.getString("card_condition_name")
				);
				conditions.add(condition);
			}
			
			return conditions;
		}
		catch(SQLException e) {
			System.out.println("GET ALL CARD CONDITIONS FAILED");
			e.printStackTrace();
		}
		return null;
	}

}
