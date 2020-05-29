import model.Address;
import model.AddressFormat;
import org.json.JSONObject;

import java.util.UnknownFormatConversionException;
import java.util.regex.Matcher;


public class AddressParser {

    /**
     * Parses a street name and house number that is supplied in an arbitrary format and returns
     * a JSON object that contains this data.
     * @param input String that contains the address data (e.g. "Am Bächle 25B")
     * @return JSON Object in format {{"street": "Am Bächle", "housenumber": "25B"}}
     * @throws UnknownFormatConversionException if the format of the input string could not be recognized
     */
    public static JSONObject parse(String input) throws UnknownFormatConversionException {
        for (AddressFormat addressFormat : AddressFormat.values()) {
            Matcher matcher = addressFormat.regexInfo.getPattern().matcher(input);
            if (matcher.matches()) {
                String streetName = matcher.group(addressFormat.regexInfo.getStreetGroup()).strip();
                String houseNumber = matcher.group(addressFormat.regexInfo.getStreetNumberGroup()).strip();
                return new JSONObject(new Address(streetName, houseNumber));
            }
        }
        throw new UnknownFormatConversionException("Unknown address format, can't parse.");
    }
}
