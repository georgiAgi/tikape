package Luokat;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Keskustelu {

    private Integer id;
    private String otsikko;
    private int alue;
    private String luotu;

    public Keskustelu(Integer id, String otsikko, int alue, String luotu) {
        this.id = id;
        this.otsikko = otsikko;
        this.alue = alue;
        this.luotu = luotu;

    }

    public Keskustelu(Integer id, String otsikko, String luotu) {
        this.id = id;
        this.otsikko = otsikko;
        this.luotu = luotu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOtsikko() {
        return otsikko;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public Integer getAlue() {
        return this.alue;
    }

    public void setAlue(int alue) {
        this.alue = alue;
    }

    public String getLuotu() {
        return luotu;
    }

    public void setLuotu(String luotu) {
        this.luotu = luotu;
    }

}
