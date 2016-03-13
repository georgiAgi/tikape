
package Collectors;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.*;
import Luokat.*;


public class ViestiCollector implements Collector<Viesti> {
    
    @Override
    public Viesti collect(ResultSet rs) throws SQLException {
        return new Viesti(rs.getInt("id"),
                        rs.getString("sisalto"),
                        rs.getInt("keskustelutunnus"),
                        rs.getInt("edellinenviesti"),
                        rs.getString("luotu")
        );
    }
}
