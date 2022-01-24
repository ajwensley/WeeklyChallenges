import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validPin {

    public static void main(String[] args) {
        System.out.println(validate("121317"));
        System.out.println(validate("1234"));
        System.out.println(validate("45135"));
        System.out.println(validate("89abc1"));
        System.out.println(validate("900876"));
        System.out.println(validate(" 4983"));
    }

    public static boolean validate(String input) {
        Pattern pattern = Pattern.compile("^\\d{4}$|^\\d{6}$");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
