package database;

import Luokat.*;
import java.sql.SQLException;
import java.util.List;
import Collectors.*;

public class AlueDAO implements DAO<Alue, Integer> {

    private Database database;

    public AlueDAO(Database base) {
        this.database = base;
    }

    @Override
    public Alue findOne(Integer key) throws SQLException {
        List<Alue> keskustelut = this.database.queryAndCollect("SELECT * FROM Alue WHERE id = ?",
                new AlueCollector(), key);
        if (keskustelut.isEmpty()) {
            return null;
        }

        return keskustelut.get(0);
    }

    @Override
    public List<Alue> findAll() throws SQLException {
        return this.database.queryAndCollect("SELECT * FROM Alue", new AlueCollector());
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void save(Alue alue) throws SQLException {
        this.database.update("INSERT INTO Alue (sisalto) VALUES (?)", alue.getSisalto());
    }
    
    public void save(String alue) throws SQLException {
        this.database.update("INSERT INTO Alue (sisalto) VALUES (?)", alue);
    }
    
    public List<Alue> viestilkm(Integer key) throws SQLException {
        return this.database.queryAndCollect("SELECT Alue.id, Alue.sisalto FROM Alue JOIN Keskustelu ON Alue.id = Keskustelu.aluetunnus JOIN Viesti ON Keskustelu.id = Viesti.keskustelutunnus WHERE Alue.id = ?", new AlueCollector(), key);
    }

}
