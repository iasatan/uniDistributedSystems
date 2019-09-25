package uni.iit.miskolc.msc.ds.user.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uni.iit.miskolc.msc.ds.user.exception.IllegalCharacterException;
import uni.iit.miskolc.msc.ds.user.exception.NotLongEnoughException;
import uni.iit.miskolc.msc.ds.user.model.User;

class AccountValidatorTest {
    private Validator validator;
    private User user;

    @BeforeEach
    void setUp() {
        validator = new AccountValidator();
        user = new User("iasatan");
    }

    @org.junit.jupiter.api.Test
    void isValid() throws IllegalCharacterException, NotLongEnoughException {
        validator.isValid(user);
    }

    @Test
    void lenghtValidator() throws IllegalCharacterException, NotLongEnoughException {
        user = new User("asd");
        Assertions.assertThrows(NotLongEnoughException.class, () -> {
            validator.isValid(user);
        });
    }

    @Test
    void SpaceValidator() throws IllegalCharacterException, NotLongEnoughException {
        user = new User("asd asd");
        Assertions.assertThrows(IllegalCharacterException.class, () -> {
            validator.isValid(user);
        });

    }
}