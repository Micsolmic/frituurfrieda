package be.vdab.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import be.vdab.entities.Pizza;
import be.vdab.entities.Saus;

public class SausRepository extends AbstractRepository {

	
	public final static String JNDI = "jdbc/frituurfrieda";
	private final static String SELECT_ALL = "select id,naam,ingredienten from sauzen";
	
	
	
	
	
	
	public Optional<List<Saus>> getAlleSauzen(){
		
		ArrayList<Saus> sauzen = null;
		
		try(Connection connection = dataSource.getConnection()){
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_ALL);
		    while(resultSet.next()) {
		    	
		    	
		    	sauzen = new ArrayList<>();
		    	
		    	sauzen.add(resultSetRijNaarSaus(resultSet));
		    	
		    }
		    
		    Optional<List<Saus>> optSauzen = Optional.of(sauzen);
		    return optSauzen;
			
		}
		
		
		catch(SQLException ex) {
			
			throw new CustomDBException(ex);
			
		}
		
		
	}
	
	private Saus resultSetRijNaarSaus(ResultSet resultSet) throws SQLException {
		return new Saus(resultSet.getLong("id"), resultSet.getString("naam"),  Arrays.asList(resultSet.getString("ingredienten").split(",")));
				
	}

	
}
