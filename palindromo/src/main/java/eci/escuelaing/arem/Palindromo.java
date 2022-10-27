package eci.escuelaing.arem;

/**
 *
 * @author nicole.montana
 */
public class Palindromo {
    
    public static String esPalindromo(String palabra){
        int mitad;
        String end = "";
        String start = "";
        if((palabra.length() % 2) == 0){
            mitad = palabra.length();
        }else{
            mitad = palabra.length() - 1;
        }
        for(int i = 0; i <= mitad; i++){
            int pos = palabra.length() - i;
            end = end + palabra.charAt(pos);
            start = start + palabra.charAt(i);
        }
        if(end.equals(start)){
            return "Si es palíndromo";
        }
        return "Si es palíndromo";
    }
}