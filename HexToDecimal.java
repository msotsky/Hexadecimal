/**
 * This class converts hexadecimal to base 10
 * @author Maxime Sotsky    3637964
 */
import java.util.*;
public class HexToDecimal {
    /**
     * static character array representing the hexadecimal alphabet
     * static character arraylist representing the hexadecimal alphabet
     */
    static Character[] arrAlpha = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    static List<Character> alpha = Arrays.asList(arrAlpha);

    /**
     * method to be called by my to convert hexadecimal to base 10
     * @param n - the string representing a hexadimal value to be converted to base 10
     * @return integer representing the base 10 value
     */
    public static int hexToDecimal(String n){
        return hexHelp(n,0,n.length()-1,0);

    }
    /**
     * recursive helper method to convert hexadimal to base 10
     * @param n - the string representing a hexadimal value to be converted to base 10
     * @param res - the integer in base 10
     * @param pow - the decreasing power to convert to base 10 from hexadimal
     * @param i - the current index of the hexadecimal string
     * @return the integer in base 10 format
     * @throws illegalArgumentException if character is not in the hexadecimal alphabet
     */
    private static int hexHelp(String n, int res, int pow, int i){
        if(pow < 0)
            return res;
        if(!alpha.contains(Character.toUpperCase(n.charAt(i))))
            throw new IllegalArgumentException(n.charAt(i) + " is an invalid hexadecimal character.");
        else
            return res += alpha.indexOf(Character.toUpperCase(n.charAt(i))) * Math.pow(16,pow) + hexHelp(n,res,--pow,++i);
    }
    
    /**
     * main method
     * @param args - the hexadecimal value to be converted to base 10
     * @exception illegalArgumentException - invalid character argument
     * @exception ArrayIndexOutOfBoundsException -case the argument is null
     */
    public static void main(String[] args){

        try{
            System.out.println(hexToDecimal(args[0]));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Argument cannot be null");
        }
    }
}
