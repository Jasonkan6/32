package src.main.java;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TextField;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class compInitTest {

    @BeforeClass
    public static void initToolkit() {
        new JFXPanel();
    }

    @Test
    public void test_Week_Valid()
    { // valid integer, has lower bound and higher bound
        String expected = "desired";
        compInit initializer = new compInit();
        TextField textField = new TextField("2301");
        String result = initializer.component_init(textField, true, true, 2315, true, 2301);
        assertEquals(expected, result);
    }

    @Test
    public void test_Week_Invalid_Out1()
    { // invalid integer that is out of range, has lower bound and higher bound
        String expected = "Please enter an integer >= 2301 and <= 2315";
        compInit initializer = new compInit();
        TextField textField = new TextField("2300");
        String result = initializer.component_init(textField, true, true, 2315, true, 2301);
        assertEquals(expected, result);
    }

    @Test
    public void test_Week_Invalid_Out2()
    { // invalid integer that is out of range, has lower bound and higher bound
        String expected = "Please enter an integer >= 2301 and <= 2315";
        compInit initializer = new compInit();
        TextField textField = new TextField("2316");
        String result = initializer.component_init(textField, true, true, 2315, true, 2301);
        assertEquals(expected, result);
    }

    @Test
    public void test_Week_Invalid_Notnum()
    {
        String expected = "Please enter an integer.";
        compInit initializer = new compInit();
        TextField textField = new TextField("not a number");
        String result = initializer.component_init(textField, true, true, 2315, true, 2301);
        assertEquals(expected, result);
    }

    @Test
    public void test_Cap_Valid()
    { // valid integer, has lower bound but not higher bound
        String expected = "desired";
        compInit initializer = new compInit();
        TextField textField = new TextField("1500");
        String result = initializer.component_init(textField, true, false, 0, true, 0);
        assertEquals(expected, result);
    }

    @Test
    public void test_Cap_Invalid_out()
    { // invalid integer, has lower bound but not higher bound
        String expected = "Please enter an integer >= 0.";
        compInit initializer = new compInit();
        TextField textField = new TextField("-1");
        String result = initializer.component_init(textField, true, false, 0, true, 0);
        assertEquals(expected, result);
    }

    @Test
    public void test_Cap_Invalid_Decimal()
    {
        String expected = "Please enter an integer.";
        compInit initializer = new compInit();
        TextField textField = new TextField("3.3");
        String result = initializer.component_init(textField, true, false, 0, true, 0);
        assertEquals(expected, result);
    }

    @Test
    public void test_Cap_Invalid_Notnum()
    {
        String expected = "Please enter an integer.";
        compInit initializer = new compInit();
        TextField textField = new TextField("not a number");
        String result = initializer.component_init(textField, true, false, 0, true, 0);
        assertEquals(expected, result);
    }

    @Test
    public void test_Prc_Valid()
    { // valid decimal number, has lower bound but not higher bound
        String expected = "desired";
        compInit initializer = new compInit();
        TextField textField = new TextField("55.5");
        String result = initializer.component_init(textField, false, false, 0, true, 0);
        assertEquals(expected, result);
    }

    @Test
    public void test_Prc_Invalid_out()
    { // invalid decimal number, has lower bound but not higher bound
        String expected = "Please enter a number >= 0.0.";
        compInit initializer = new compInit();
        TextField textField = new TextField("-1");
        String result = initializer.component_init(textField, false, false, 0, true, 0);
        assertEquals(expected, result);
    }

    @Test
    public void test_Prc_Invalid_Notnum()
    { // invalid decimal number, has lower bound but not higher bound
        String expected = "Please enter a number.";
        compInit initializer = new compInit();
        TextField textField = new TextField("not a number");
        String result = initializer.component_init(textField, false, false, 0, true, 0);
        assertEquals(expected, result);
    }
}