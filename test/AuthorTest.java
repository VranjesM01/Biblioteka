import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.sql.*;

public class AuthorTest {

    private Connection con;

    @Before
    public void setUp() throws Exception {
        // Setup the database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/SLibrary", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            fail("Database connection setup failed: " + e.getMessage());
        }
    }

    @Test
    public void testAddAuthor() {
        String name = "Test Author";
        String address = "123 Test Street";
        String phone = "1234567890";

        try {
            // Prepare the statement to insert the author
            PreparedStatement pst = con.prepareStatement("INSERT INTO author(name, address, phone) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, phone);

            int affectedRows = pst.executeUpdate();

            // Check if the insert was successful
            assertEquals("Author insertion failed.", 1, affectedRows);

            // Retrieve the inserted record
            ResultSet generatedKeys = pst.getGeneratedKeys();
            assertTrue("No ID returned for the inserted author.", generatedKeys.next());

            int insertedId = generatedKeys.getInt(1);

            // Verify the data in the database
            PreparedStatement checkPst = con.prepareStatement("SELECT * FROM author WHERE id = ?");
            checkPst.setInt(1, insertedId);
            ResultSet rs = checkPst.executeQuery();

            assertTrue("Inserted author not found in the database.", rs.next());
            assertEquals("Name does not match.", name, rs.getString("name"));
            assertEquals("Address does not match.", address, rs.getString("address"));
            assertEquals("Phone does not match.", phone, rs.getString("phone"));

         

        } catch (SQLException e) {
            fail("Database operation failed: " + e.getMessage());
        }
    }
}
