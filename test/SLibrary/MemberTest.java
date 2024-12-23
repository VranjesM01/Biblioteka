package SLibrary;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.*;

import static org.junit.Assert.*;

public class MemberTest {

    private Connection con;
    private PreparedStatement pst;

    @Before
    public void setUp() throws Exception {
        // Set up a connection to the test database
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/SLibrary", "root", "");
    }

    @After
    public void tearDown() throws Exception {
        // Clean up and close the connection
        if (pst != null) {
            pst.close();
        }
        if (con != null) {
            con.close();
        }
    }

    @Test
    public void testAddMember() throws Exception {
        String name = "Test TugaCemerjad";
        String address = "nepoznata";
        String phone = "1234567890";

        // Add the new member
        pst = con.prepareStatement("INSERT INTO member(name, address, phone) VALUES (?, ?, ?)");
        pst.setString(1, name);
        pst.setString(2, address);
        pst.setString(3, phone);

        int rowsAffected = pst.executeUpdate();
        assertEquals(1, rowsAffected); // Ensure one row was added

        // Verify that the member was added
        pst = con.prepareStatement("SELECT * FROM member WHERE name = ? AND address = ? AND phone = ?");
        pst.setString(1, name);
        pst.setString(2, address);
        pst.setString(3, phone);

        ResultSet rs = pst.executeQuery();
        assertTrue(rs.next()); // Ensure a result was returned
        assertEquals(name, rs.getString("name"));
        assertEquals(address, rs.getString("address"));
        assertEquals(phone, rs.getString("phone"));

        // Clean up by removing the test data
        //pst = con.prepareStatement("DELETE FROM member WHERE name = ? AND address = ? AND phone = ?");
       // pst.setString(1, name);
        //pst.setString(2, address);
       // pst.setString(3, phone);
       // pst.executeUpdate();
    }
}