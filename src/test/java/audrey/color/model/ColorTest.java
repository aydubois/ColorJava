package audrey.color.model;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ColorTest {
    private Color color1;
    private Color color2;
    @Before
    public void setUp() {
        try{
            color1 = new Color(100,150,200);
            color2 = new Color("#6496C8");
        }catch(IllegalArgumentException e){
            System.out.println("ERROR ====> "+e.getMessage());
        }
    }

    /////////// TESTS CONSTRUCTORS EXCEPTION ///////////////
    @Test(expected=IllegalArgumentException.class)
    public void testColor_exceptionRed(){
        Color color = new Color(300, 150, 200);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testColor_exceptionGreen(){
        Color color = new Color(150, 300, 200);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testColor_exceptionBlue(){
        Color color = new Color(150, 150, 300);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testColor_exceptionHexaHash(){
        Color color = new Color("6496C8");
    }
    @Test(expected=IllegalArgumentException.class)
    public void testColor_exceptionHexaNumberCharacter(){
        Color color = new Color("#96C8");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testColor_exceptionHexaNotExpectedCharacter(){
        Color color = new Color("#PM96C8");
    }
    ////////////////////////////////////////////


    /////////// TESTS SETTERS EXCEPTION ////////////////////
    @Test(expected=IllegalArgumentException.class)
    public void testSetRed_exception(){
        color1.setRed(300);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testSetGreen_exception(){
        color1.setGreen(300);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testSetBlue_exception(){
        color1.setBlue(300);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testSetHexValue_exceptionHash(){
        color1.setHexValue("6496C8");
    }
    @Test(expected=IllegalArgumentException.class)
    public void testSetHexValue_exceptionNumberCharacter(){
        color1.setHexValue("#96C8");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSetHexValue_exceptionNotExpectedCharacter(){
        color1.setHexValue("#PM96C8");
    }
    ///////////////////////////////////////////////

    /////////// TESTS SETTERS OK //////////////////
    @Test
    public void testSetRed(){
        color1.setRed(100);
        assertEquals(100, color1.getRed());
    }
    @Test
    public void testSetGreen(){
        color1.setGreen(100);
        assertEquals(100, color1.getGreen());
    }
    @Test
    public void testSetBlue(){
        color1.setBlue(100);
        assertEquals(100, color1.getBlue());
    }
    @Test
    public void testSetHexValue(){
        color1.setHexValue("#5496C8");
        assertEquals("#5496C8", color1.getHexValue());
    }
    ///////////////////////////////////////////////

    /////////// TESTS GETTERS OK //////////////////
    @Test
    public void testGetRed(){
        assertEquals(100, color1.getRed());
        //assertEquals(150, color1.getGreen());
        //assertEquals(200, color1.getBlue());

        assertEquals(100, color2.getRed());
        //assertEquals(150, color2.getGreen());
        //assertEquals(200, color2.getBlue());
    }

    @Test
    public void testGetGreen(){
        //assertEquals(100, color1.getRed());
        assertEquals(150, color1.getGreen());
        //assertEquals(200, color1.getBlue());

        //assertEquals(100, color2.getRed());
        assertEquals(150, color2.getGreen());
        //assertEquals(200, color2.getBlue());
    }

    @Test
    public void testGetBlue(){
        //assertEquals(100, color1.getRed());
        //assertEquals(150, color1.getGreen());
        assertEquals(200, color1.getBlue());

        //assertEquals(100, color2.getRed());
        //assertEquals(150, color2.getGreen());
        assertEquals(200, color2.getBlue());
    }

    @Test
    public void testGetHexValue(){
        assertEquals("#6496C8", color1.getHexValue());
        assertEquals("#6496C8", color2.getHexValue());
    }
    ///////////////////////////////////////////////


    /////////// TESTS GETTERS OK //////////////////
    @Test
    public void testToString(){
        assertEquals("[value=#6496C8, r=100, g=150, b=200]", color1.toString());
    }
    ///////////////////////////////////////////////

    @After
    public void tearDown() {
        color1 = null;
        color2 = null;
    }
}
