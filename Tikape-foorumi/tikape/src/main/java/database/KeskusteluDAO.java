package database;

import Luokat.*;
import java.sql.SQLException;
import java.util.List;
import Collectors.*;

public class KeskusteluDAO implements DAO<Keskustelu, Integer> {

    private Database database;

    public KeskusteluDAO(Database base) {
        this.database = base;
    }

    @Override
    public Keskustelu findOne(Integer key) throws SQLException {
        List<Keskustelu> keskustelut = this.database.queryAndCollect("SELECT * FROM Keskustelu WHERE id = ?",
                new KeskusteluCollector(), key);
        if (keskustelut.isEmpty()) {
            return null;
        }

        return keskustelut.get(0);
    }

    @Override
    public List<Keskustelu> findAll() throws SQLException {
        return this.database.queryAndCollect("SELECT * FROM Keskustelu", new KeskusteluCollector());
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void save(Keskustelu keskustelu) throws SQLException {
        this.database.update("INSERT INTO Keskustelu (otsikko, aluetunnus) VALUES (?,?)", keskustelu.getOtsikko(), keskustelu.getAlue());
    }
    
//    public void save(String otsikko, int aluetunnus) throws SQLException {
//        this.database.update("INSERT INTO Keskustelu (otsikko, aluetunnus) VALUES (?,?)", otsikko, aluetunnus);
//    }
    
    public Object save(String otsikko, int aluetunnus) throws SQLException {
        this.database.update("INSERT INTO Keskustelu (otsikko, aluetunnus) VALUES (?,?)", otsikko, aluetunnus);
        
        List<Keskustelu> keskustelut = this.database.queryAndCollect("SELECT * FROM Keskustelu ORDER BY id DESC LIMIT 1", new KeskusteluCollector());
        Keskustelu keskustelu = keskustelut.get(0);
        
        return keskustelu.getId();
    }

    public List<Keskustelu> findAlueenKaikki(Integer key) throws SQLException {
         return this.database.queryAndCollect("SELECT * FROM Keskustelu WHERE aluetunnus = ?", new KeskusteluCollector(), key);
               
        
    }
}
