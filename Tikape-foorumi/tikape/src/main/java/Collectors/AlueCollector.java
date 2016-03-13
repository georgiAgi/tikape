
package Collectors;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.*;
import Luokat.*;


public class AlueCollector implements Collector<Alue> {
    
    @Override
    public Alue collect(ResultSet rs) throws SQLException {
        return new Alue(rs.getInt("id"),
                        rs.getString("sisalto"));
                        
    }
  
    
}
