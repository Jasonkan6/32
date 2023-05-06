package src.main.java;

import javafx.scene.control.TextField;
import org.junit.Test;
import static org.junit.Assert.*;

public class compInitTest {
    @Test
    public void test_WeekOfYear_Valid() {
        compInit initializer = new compInit();
        TextField textField = new TextField();
        textField.setText("2301");
        boolean result = initializer.component_init(textField, true, true, 2315, true, 2301);
        assertTrue(result);
    }

    @Test
    public void test_WeekOfYear_Invalid_Num() {
        compInit initializer = new compInit();
        TextField textField = new TextField();
        textField.setText("15");
        boolean result = initializer.component_init(textField, true, true, 2315, true, 2301);
        assertFalse(result);
    }

}