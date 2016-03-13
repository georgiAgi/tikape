package Luokat;

import java.util.ArrayList;
import java.util.List;

public class Alue {

    private int id;
    private String sisalto;

    public Alue(int id, String sisalto) {
        this.id = id;
        this.sisalto = sisalto;
    }

    public String getSisalto() {
        return sisalto;
    }

    public void setSisalto(String sisalto) {
        this.sisalto = sisalto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
