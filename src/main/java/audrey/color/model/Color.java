package audrey.color.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Color {
    private int red;
    private int green;
    private int blue;
    private String hexValue;

    private final String intervalNbError = "Les paramètres doivent être compris entre 0 et 255.";
    public Color(int red, int green, int blue) throws IllegalArgumentException {
        if(!checkNbInterval(red) ||!checkNbInterval(green) || !checkNbInterval(blue)){
            throw new IllegalArgumentException(intervalNbError);
        }
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.hexValue = String.format("#%02X%02X%02X", red, green, blue);
    }

    public Color(String hexValue) throws  IllegalArgumentException {
        if(!checkHexValue(hexValue)){
            throw new IllegalArgumentException("Le paramètre donné n'est pas un code héxadécimal.");
        }
        this.hexValue = hexValue;
        this.red = Integer.valueOf( hexValue.substring( 1, 3 ), 16 );
        this.green = Integer.valueOf( hexValue.substring( 3, 5 ), 16 );
        this.blue = Integer.valueOf( hexValue.substring( 5, 7 ), 16 );
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red)throws IllegalArgumentException {
        if(!checkNbInterval(red) ){
            throw new IllegalArgumentException(intervalNbError);
        }
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green)throws IllegalArgumentException {
        if(!checkNbInterval(green)){
            throw new IllegalArgumentException(intervalNbError);
        }
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue)throws IllegalArgumentException {
        if(!checkNbInterval(blue)){
            throw new IllegalArgumentException(intervalNbError);
        }
        this.blue = blue;
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) throws IllegalArgumentException{
        if(!checkHexValue(hexValue)){
            throw new IllegalArgumentException("Le paramètre donné n'est pas un code héxadécimal.");
        }
        this.hexValue = hexValue;
    }

    public String toString(){
        return "[value="+this.hexValue+", r="+this.red+", g="+this.green+", b="+this.blue+"]";
    }


    private boolean checkHexValue(String hexValue){
        Pattern pattern = Pattern.compile("^#([A-F0-9]{6})$");
        Matcher matcher = pattern.matcher(hexValue);
        return matcher.matches();
    }

    private boolean checkNbInterval(int numberColor){
        return numberColor > 0 && numberColor < 255;
    }
}
