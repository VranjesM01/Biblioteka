package SLibrary;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.event.ActionEvent;

public class LoginTest {

    private Login login;

    @Before
    public void setUp() {
        login = new Login();
        login.setVisible(false); // Ensure the UI doesn't pop up during tests
    }

  @Test
    public void testValidLoginTad() {
        login.txtusername.setText("tuga");
        login.txtpass.setText("123");
        
        login.jButton1.doClick(); // Simulate button click
        
        assertFalse("Login form should be hidden", login.isVisible());
    }
    
    

   
    }
