package uni.iit.miskolc.msc.ds.user.validator;

import uni.iit.miskolc.msc.ds.user.exception.IllegalCharacterException;
import uni.iit.miskolc.msc.ds.user.exception.NotLongEnoughException;
import uni.iit.miskolc.msc.ds.user.model.User;

public interface Validator {
    boolean isValid(User user) throws NotLongEnoughException, IllegalCharacterException;
}
