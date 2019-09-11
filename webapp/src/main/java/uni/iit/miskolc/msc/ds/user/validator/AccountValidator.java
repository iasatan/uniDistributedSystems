package uni.iit.miskolc.msc.ds.user.validator;

import uni.iit.miskolc.msc.ds.user.exception.IllegalCharacterException;
import uni.iit.miskolc.msc.ds.user.exception.NotLongEnoughException;
import uni.iit.miskolc.msc.ds.user.model.User;

public class AccountValidator implements Validator {

    @Override
    public boolean isValid(User user) throws NotLongEnoughException, IllegalCharacterException {
        usernameNull(user);
        usernameEmpty(user);
        usernameShort(user);
        usernameContainsSpace(user);
        return true;
    }

    private void usernameNull(User user) {
        if (user == null) {
            throw new NullPointerException();
        }
    }

    private void usernameEmpty(User user) {
        if (user.getUsername().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void usernameShort(User user) throws NotLongEnoughException {
        if (user.getUsername().length() < 6) {
            throw new NotLongEnoughException();
        }
    }

    private void usernameContainsSpace(User user) throws IllegalCharacterException {
        if (user.getUsername().contains(" ")) {
            throw new IllegalCharacterException();
        }
    }
}
