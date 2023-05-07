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
    public void test_WeekOfYear_Valid()
    { // valid integer, has lower bound and higher bound
        compInit initializer = new compInit();
        TextField textField = new TextField("2301");
        boolean result = initializer.component_init(textField, true, true, 2315, true, 2301);
        assertTrue(result);
    }


}