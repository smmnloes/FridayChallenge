import model.Address;
import org.json.JSONObject;
import org.junit.Test;

import java.util.UnknownFormatConversionException;

import static org.junit.Assert.assertTrue;

public class FridayChallengeMainTest {
    @Test
    public void testSimpleCase1() {
        JSONObject expected = new JSONObject(new Address("Winterallee", "3"));
        assertTrue(AddressParser.parse("Winterallee 3").similar(expected));
    }

    @Test
    public void testSimpleCase2() {
        JSONObject expected = new JSONObject(new Address("Musterstrasse", "45"));
        assertTrue(AddressParser.parse("Musterstrasse 45").similar(expected));
    }

    @Test
    public void testSimpleCase3() {
        JSONObject expected = new JSONObject(new Address("Blaufeldweg", "123B"));
        assertTrue(AddressParser.parse("Blaufeldweg 123B").similar(expected));
    }

    @Test
    public void testAdvancedCase1() {
        JSONObject expected = new JSONObject(new Address("Am Bächle", "23"));
        assertTrue(AddressParser.parse("Am Bächle 23").similar(expected));
    }

    @Test
    public void testAdvancedCase2() {
        JSONObject expected = new JSONObject(new Address("Auf der Vogelwiese", "23 b"));
        assertTrue(AddressParser.parse("Auf der Vogelwiese 23 b").similar(expected));
    }

    @Test
    public void testForeignCase1() {
        JSONObject expected = new JSONObject(new Address("rue de la revolution", "4"));
        assertTrue(AddressParser.parse("4, rue de la revolution").similar(expected));
    }

    @Test
    public void testForeignCase2() {
        JSONObject expected = new JSONObject(new Address("Broadway Av", "200"));
        assertTrue(AddressParser.parse("200 Broadway Av").similar(expected));
    }

    @Test
    public void testForeignCase3() {
        JSONObject expected = new JSONObject(new Address("Calle Aduana", "29"));
        assertTrue(AddressParser.parse("Calle Aduana, 29").similar(expected));
    }

    @Test
    public void testForeignCase4() {
        JSONObject expected = new JSONObject(new Address("Calle 39", "No 1540"));
        assertTrue(AddressParser.parse("Calle 39 No 1540").similar(expected));
    }

    @Test(expected = UnknownFormatConversionException.class)
    public void testUnkonwnFormat() {
        AddressParser.parse("This 123 input has unkown format 12345");
    }

}