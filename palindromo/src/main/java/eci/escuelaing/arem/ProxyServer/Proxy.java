package eci.escuelaing.arem.ProxyServer;

import com.google.gson.Gson;
import static spark.Spark.get;
import static spark.Spark.port;
import eci.escuelaing.arem.Palindromo;
import eci.escuelaing.arem.ProxyServer.RoundRobin;

/**
 *
 * @author nicole.montana
 */
public class Proxy {
    
    String serverA = null;
    String serverB = null;
    static RoundRobin rr = new RoundRobin();
    
    public static void main(String[] args){
        port(getPort());
        get("espalindromo/:value", (req, res) -> {
            res.status(200);
            res.type("application/json");
            String ans = String.valueOf(rr.palindromoRes(String.valueOf(req.params(":value"))));
            String salida = "{ operation: palíndromo, input: " + req.params(":value") + ", output: " + ans +"}";
            rr.change();
            return new Gson().toJson(salida);
        });
    }
    
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 6001;
    }
 
}
