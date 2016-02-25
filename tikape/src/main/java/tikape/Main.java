package tikape;

import static spark.Spark.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        get("/opiskelijat", (req, res) -> {
            return "<form method=\"POST\" action=\"/opiskelijat\">\n"
                    + "Nimi:<br/>\n"
                    + "<input type=\"text\" name=\"nimi\"/><br/>\n"
                    + "Aihe:<br/>\n"
                    + "<input type=\"text\" name=\"aihealue\"/><br/>\n"
                    + "Otsikko:<br/>\n"
                    + "<input type=\"text\" name=\"otsikko\"/><br/>\n"
                    + "<input type=\"submit\" value=\"Lähetä\"/>\n"
                    + "</form>";
        });

        post("/opiskelijat", (req, res) -> {
            String nimi = req.queryParams("nimi");
            return "Kerrotaan siitä tiedon lähettäjälle: " + nimi;
        });

    }

}
