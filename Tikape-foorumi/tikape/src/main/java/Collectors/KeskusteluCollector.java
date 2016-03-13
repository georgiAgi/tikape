package Collectors;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.*;
import Luokat.*;


public class KeskusteluCollector implements Collector<Keskustelu> {
    
    @Override
    public Keskustelu collect(ResultSet rs) throws SQLException {
        return new Keskustelu(rs.getInt("id"),
                        rs.getString("otsikko"),
                        rs.getInt("aluetunnus"),                        
                        rs.getString("luotu")
        );
    }
}