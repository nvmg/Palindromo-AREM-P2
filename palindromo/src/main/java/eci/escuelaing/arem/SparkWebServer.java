package eci.escuelaing.arem;

import com.google.gson.Gson;
import static spark.Spark.get;
import static spark.Spark.port;

/**
 *
 * @author nicole.montana
 */
public class SparkWebServer {
    public static void main(String... args){
        port(getPort());
        get("/espalindromo/:value", (req,res) -> {
            res.status(200);
            res.header("Access-Control-Allow-", "*");
            res.type("application/json");
            //String salida = "{ operation: palíndromo, input: " + req.params(":value") + ", output: " + Palindromo.esPalindromo(String.valueOf(req.params(":value"))) +"}";
            return new Gson().toJson(Palindromo.esPalindromo(String.valueOf(req.params(":value"))));
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
