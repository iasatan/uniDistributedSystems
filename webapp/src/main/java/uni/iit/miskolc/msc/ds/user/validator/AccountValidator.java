package uni.iit.miskolc.msc.ds.user.validator;

import uni.iit.miskolc.msc.ds.user.exception.IllegalCharacterException;
import uni.iit.miskolc.msc.ds.user.exception.NotLongEnoughException;
import uni.iit.miskolc.msc.ds.user.model.User;

public class AccountValidator implements Validator {

    @Override
    public boolean isValid(User user) throws NotLongEnoughException, IllegalCharacterException {
        if (user == null) {
            throw new NullPointerException();
        }
        if (user.getUsername().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (user.getUsername().length() < 6) {
            throw new NotLongEnoughException();
        }
        if (user.getUsername().contains(" ")) {
            throw new IllegalCharacterException();
        }
        return true;
    }
}
