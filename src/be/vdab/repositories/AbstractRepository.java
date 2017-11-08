package be.vdab.repositories;

import javax.sql.DataSource;

public abstract class AbstractRepository {

    DataSource dataSource;
	
	public void setDataSource(DataSource ds) {
		
		this.dataSource = ds;
		
	}
	
	
	
}
