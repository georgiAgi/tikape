package database;

import Luokat.*;
import java.sql.SQLException;
import java.util.List;
import Collectors.*;

public class ViestiDAO implements DAO<Viesti, Integer> {

    private Database database;

    public ViestiDAO(Database database) {
        this.database = database;
    }

    @Override
    public Viesti findOne(Integer key) throws SQLException {
        List<Viesti> viestit = this.database.queryAndCollect("SELECT * FROM Viesti WHERE id = ?",
                new ViestiCollector(), key);
        if (viestit.isEmpty()) {
            return null;
        }

        return viestit.get(0);
    }

    @Override
    public List<Viesti> findAll() throws SQLException {
        return this.database.queryAndCollect("SELECT * FROM Viesti", new ViestiCollector());
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void save(Viesti viesti) throws SQLException {
        this.database.update("INSERT INTO Viesti (sisalto, keskustelutunnus) VALUES (?,?)", viesti.getSisalto(), viesti.getKeskustelu());
    }
    
    public void save(String sisalto, int keskustelutunnus) throws SQLException {
        this.database.update("INSERT INTO Viesti (sisalto, keskustelutunnus) VALUES (?,?)", sisalto, keskustelutunnus);
    }

    public List<Viesti> uusinEka() throws SQLException {
        return this.database.queryAndCollect("SELECT * FROM VIESTI ORDER BY luotu DESC", new ViestiCollector());
    }

    public List<Viesti> findKeskustelunKaikki(Integer key) throws SQLException {
        return this.database.queryAndCollect("SELECT * FROM Viesti WHERE keskustelutunnus = ?", new ViestiCollector(), key);

    }

}
