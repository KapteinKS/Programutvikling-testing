import org.openjfx.InvalidEmailException;

public class PersonValidator {
    public static boolean email(String epost) throws InvalidEmailException {
        String pat = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        if(!epost.matches(pat)){
            return false;
        }
        else {
            return true;
        }
    }
}
