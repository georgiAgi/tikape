package Luokat;

import java.sql.Timestamp;

public class Viesti {

    private int id;
    private String sisalto;
    private int keskustelu;
    private int edellinenViesti;
    private String luotu;

    public Viesti(int id, String sisalto, int keskustelu, int edellinenViesti, String luotu) {
        this.id = id;
        this.sisalto = sisalto;
        this.keskustelu = keskustelu;
        this.edellinenViesti = edellinenViesti;
        this.luotu = luotu;
    }

    public Viesti(int id, String sisalto, int keskustelu, String luotu) {
        this.id = id;
        this.sisalto = sisalto;
        this.keskustelu = keskustelu;
        this.luotu = luotu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSisalto() {
        return sisalto;
    }

    public void setSisalto(String sisalto) {
        this.sisalto = sisalto;
    }

    public int getKeskustelu() {
        return keskustelu;
    }

    public void setKeskustelu(int keskustelu) {
        this.keskustelu = keskustelu;
    }

    public int getEdellinenViesti() {
        return edellinenViesti;
    }

    public void setEdellinenViesti(int edellinenViesti) {
        this.edellinenViesti = edellinenViesti;
    }

    public String getLuotu() {
        return luotu;
    }

    public void setLuotu(String luotu) {
        this.luotu = luotu;
    }

}
