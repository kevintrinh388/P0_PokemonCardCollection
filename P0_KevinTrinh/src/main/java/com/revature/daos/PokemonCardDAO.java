package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.PokemonCard;
import com.revature.utils.ConnectionUtil;

public class PokemonCardDAO implements PokemonCardDAOInterface{

	@Override
	public ArrayList<PokemonCard> getAllPokemonCards() {
		// get all Pokemon cards in the database
		ArrayList<PokemonCard> cards = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			CardRarityDAO cardRarityDAO = new CardRarityDAO();
			CardConditionDAO cardConditionDAO = new CardConditionDAO();
			CardTypeDAO cardTypeDAO = new CardTypeDAO();
			
			String sql = "SELECT * FROM pokemon_cards;";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				PokemonCard pokemonCard = new PokemonCard(
						rs.getInt("pokemon_card_id"),
						rs.getString("pokemon_card_name"),
						rs.getDouble("pokemon_card_price"),
						rs.getString("pokemon_card_number"),
						rs.getString("pokemon_card_set"),
						rs.getInt("pokemon_card_rarity_fk"),
						rs.getInt("pokemon_card_condition_fk"),
						rs.getInt("pokemon_card_type_fk"),
						rs.getInt("pokemon_card_user_fk")
				);
				int rarityId = rs.getInt("pokemon_card_rarity_fk");
				int conditionId = rs.getInt("pokemon_card_condition_fk");
				int typeId = rs.getInt("pokemon_card_type_fk");
				pokemonCard.setPokemon_card_rarity(cardRarityDAO.getCardRarityById(rarityId));
				pokemonCard.setPokemon_card_condition(cardConditionDAO.getCardConditionById(conditionId));
				pokemonCard.setPokemon_card_type(cardTypeDAO.getCardTypeById(typeId));
				
				cards.add(pokemonCard);
			}
			return cards;
		}
		catch(SQLException e) {
			System.out.println("GET ALL POKEMON CARDS FAILED");
			e.printStackTrace();
		}
		return null;
	}
	
	public PokemonCard getPokemonCardById(int pokemon_card_id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM pokemon_cards WHERE pokemon_card_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pokemon_card_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				PokemonCard pokemonCard = new PokemonCard(
						rs.getInt("pokemon_card_id"),
						rs.getString("pokemon_card_name"),
						rs.getDouble("pokemon_card_price"),
						rs.getString("pokemon_card_number"),
						rs.getString("pokemon_card_set"),
						rs.getInt("pokemon_card_rarity_fk"),
						rs.getInt("pokemon_card_condition_fk"),
						rs.getInt("pokemon_card_type_fk"),
						rs.getInt("pokemon_card_user_fk")
				);
				return pokemonCard;
			}
			
		}
		catch(SQLException e) {
			System.out.println("GET POKEMON CARD BY ID FAILED");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<PokemonCard> getUserPokemonCards(int user_id) {
		// get all user's cards from the database
		ArrayList<PokemonCard> cards = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			CardRarityDAO cardRarityDAO = new CardRarityDAO();
			CardConditionDAO cardConditionDAO = new CardConditionDAO();
			CardTypeDAO cardTypeDAO = new CardTypeDAO();
			
			String sql = "SELECT * FROM pokemon_cards WHERE pokemon_card_user_fk = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				PokemonCard pokemonCard = new PokemonCard(
						rs.getInt("pokemon_card_id"),
						rs.getString("pokemon_card_name"),
						rs.getDouble("pokemon_card_price"),
						rs.getString("pokemon_card_number"),
						rs.getString("pokemon_card_set"),
						rs.getInt("pokemon_card_rarity_fk"),
						rs.getInt("pokemon_card_condition_fk"),
						rs.getInt("pokemon_card_type_fk"),
						rs.getInt("pokemon_card_user_fk")
				);
				int rarityId = rs.getInt("pokemon_card_rarity_fk");
				int conditionId = rs.getInt("pokemon_card_condition_fk");
				int typeId = rs.getInt("pokemon_card_type_fk");
				pokemonCard.setPokemon_card_rarity(cardRarityDAO.getCardRarityById(rarityId));
				pokemonCard.setPokemon_card_condition(cardConditionDAO.getCardConditionById(conditionId));
				pokemonCard.setPokemon_card_type(cardTypeDAO.getCardTypeById(typeId));
				
				cards.add(pokemonCard);
			}
			return cards;
		}
		catch(SQLException e) {
			System.out.println("GET ALL USER'S POKEMON CARDS FAILED");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertPokemonCard(PokemonCard pokemonCard) {
		// inserts a pokemon card into the db
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO pokemon_cards \r\n"
				+ "(pokemon_card_name, pokemon_card_price, pokemon_card_number, pokemon_card_set,\r\n"
				+ " pokemon_card_rarity_fk, pokemon_card_condition_fk, pokemon_card_type_fk, pokemon_card_user_fk)\r\n"
				+ "VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pokemonCard.getPokemon_card_name());
			ps.setDouble(2, pokemonCard.getPokemon_card_price());
			ps.setString(3, pokemonCard.getPokemon_card_number());
			ps.setString(4, pokemonCard.getPokemon_card_set());
			ps.setInt(5, pokemonCard.getPokemon_card_rarity_fk());
			ps.setInt(6, pokemonCard.getPokemon_card_condition_fk());
			ps.setInt(7, pokemonCard.getPokemon_card_type_fk());
			ps.setInt(8, pokemonCard.getPokemon_card_user_fk());
			
			ps.executeUpdate();
			
			System.out.println("POKEMON CARD "+ pokemonCard.getPokemon_card_name()+" WAS ADDED");
			return true;
		}
		catch(SQLException e) {
			System.out.println("INSERT POKEMON CARD FAILED");
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean deletePokemonCard(int pokemon_card_id) {
		// delete a pokemon card from the db
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM pokemon_cards WHERE pokemon_card_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pokemon_card_id);
			
			ps.executeUpdate();
			System.out.println("POKEMON CARD ID:"+ pokemon_card_id + " HAS BEEN DELETED");
			return true;
		}
		catch(SQLException e) {
			System.out.println("DELETE POKEMON CARD FAILED");
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updatePokemonCardCondition(int pokemon_card_id, int card_condition_id) {
		// updates a PokemonCard's condition
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE pokemon_cards SET pokemon_card_condition_fk = ? WHERE pokemon_card_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, card_condition_id);
			ps.setInt(2, pokemon_card_id);
			ps.executeUpdate();
			
			System.out.println("Pokemon Card ID:"+pokemon_card_id+"'s condition has been updated");
			return true;
		}
		catch(SQLException e) {
			System.out.println("UPDATE POKEMON CARD CONDITION FAILED");
			e.printStackTrace();
		}
		return false;
	}

}
