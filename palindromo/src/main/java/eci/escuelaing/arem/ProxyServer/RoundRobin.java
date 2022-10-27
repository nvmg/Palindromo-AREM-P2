package eci.escuelaing.arem.ProxyServer;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author nicole.montana
 */
public class RoundRobin {
    
    String server1 = "ec2-54-174-222-199.compute-1.amazonaws.com";
    String server2 = "ec2-54-196-163-75.compute-1.amazonaws.com";
    String url = server1;
    
    private int cServer = 0;
    
    public String palindromoRes(String palabra) throws UnirestException{
        String url = cServer == 0 ? server1:server2;
        HttpResponse<String> apiRes = Unirest.get(url + "/espalindromo"+palabra).asString();
        return String.valueOf(apiRes.getBody());
    }
    
    public void change(){
        cServer = (cServer + 1) % 2;
    }
    
}
