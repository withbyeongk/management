package conn;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j;


@Log4j
class JDBCTests {
	
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	@Test
	void test() {
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:20049/irondb",
				"root",
				"iron0000")){
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
