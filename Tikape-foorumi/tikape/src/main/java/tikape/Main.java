package tikape;

import Luokat.Keskustelu;
import Luokat.Viesti;
import java.util.HashMap;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import database.Database;
import database.AlueDAO;
import database.KeskusteluDAO;
import database.ViestiDAO;

public class Main {

    public static void main(String[] args) throws Exception {
        if (System.getenv("PORT") != null) {
            port(Integer.valueOf(System.getenv("PORT")));
        }
        
        Database database = new Database("org.sqlite.JDBC", "jdbc:sqlite:chatkanta.db");

        AlueDAO alueDao = new AlueDAO(database);
        KeskusteluDAO keskusteluDao = new KeskusteluDAO(database);
        ViestiDAO viestiDao = new ViestiDAO(database);

        get("/", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("alueet", alueDao.findAll());
//            map.put("viestejä", alueDao.viestilkm(Integer.SIZE));
            return new ModelAndView(map, "index");
        }, new ThymeleafTemplateEngine());

        get("/keskustelut/:id", (req, res) -> {
            HashMap map = new HashMap<>();

            map.put("keskustelut", keskusteluDao.findAlueenKaikki(Integer.parseInt(req.params("id"))));

            return new ModelAndView(map, "keskustelut");
        }, new ThymeleafTemplateEngine());
        
        get("/viestit/:id", (req, res) -> {
            HashMap map = new HashMap<>();

            map.put("viestit", viestiDao.findKeskustelunKaikki(Integer.parseInt(req.params("id"))));

            return new ModelAndView(map, "viestit");
        }, new ThymeleafTemplateEngine());

        get("/testi", (req, res) -> {
            HashMap map = new HashMap<>();

            map.put("testit", viestiDao.findAll());

            return new ModelAndView(map, "testi");
        }, new ThymeleafTemplateEngine());
        
        get("/uusialue", (req, res) -> {
            HashMap map = new HashMap<>();
            return new ModelAndView(map, "uusialue");
        }, new ThymeleafTemplateEngine());
        
        post("/uusialue", (req, res) -> {
            String nimi = req.queryParams("nimi");
            alueDao.save(nimi);
            return "Uusi alue " + nimi + " luotiin."; //Saisko tänne viel jotenkin back-nappulan?
        });

        post("/uusiviesti", (req, res) -> {
            String nimi = req.queryParams("nimi");
            String viesti = req.queryParams("viesti");
            String sisalto = viesti + " T. " + nimi;
            int keskustelutunnus = Integer.parseInt(req.queryParams("keskustelutunnus"));
            
            viestiDao.save(sisalto, keskustelutunnus);

            return "Lähetit viestin:\n" + sisalto;
        });

        get("/uusikeskustelu", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("alueet", alueDao.findAll());
            
            return new ModelAndView(map, "uusikeskustelu");
        }, new ThymeleafTemplateEngine());

        post("/uusikeskustelu", (req, res) -> {
            String nimi = req.queryParams("nimi");
            String otsikko = req.queryParams("otsikko");
            String viesti = req.queryParams("viesti");
            int alue = Integer.parseInt(req.queryParams("alue"));

            String sisalto = viesti + " T. " + nimi;
            Object keskustelutunnus = keskusteluDao.save(otsikko, alue); //vaatii aluetunnuksen
            
            viestiDao.save(sisalto, (int) keskustelutunnus); //vaatii keskustelutunnuksen
            
            return sisalto;
        });
    }
}
