package uni.iit.miskolc.msc.ds.user.controller;

import uni.iit.miskolc.msc.ds.user.exception.IllegalCharacterException;
import uni.iit.miskolc.msc.ds.user.exception.NotLongEnoughException;
import uni.iit.miskolc.msc.ds.user.model.User;
import uni.iit.miskolc.msc.ds.user.serivce.UserServiceImpl;
import uni.iit.miskolc.msc.ds.user.validator.AccountValidator;
import uni.iit.miskolc.msc.ds.user.validator.Validator;

public class UserController {
    private UserServiceImpl userServiceImpl = new UserServiceImpl();
    private Validator validator = new AccountValidator();

    public void saveUser(User user) throws IllegalCharacterException, NotLongEnoughException {
        validator.isValid(user);
        userServiceImpl.saveUser(user);
    }

}
