import java.util.UnknownFormatConversionException;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0 && !args[0].isEmpty()) {
            try {
                System.out.println(new AddressParser().parse(args[0]));
            } catch (UnknownFormatConversionException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
