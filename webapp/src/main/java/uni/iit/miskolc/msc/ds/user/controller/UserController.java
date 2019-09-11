package uni.iit.miskolc.msc.ds.user.controller;

import uni.iit.miskolc.msc.ds.user.exception.IllegalCharacterException;
import uni.iit.miskolc.msc.ds.user.exception.NotLongEnoughException;
import uni.iit.miskolc.msc.ds.user.model.User;
import uni.iit.miskolc.msc.ds.user.serivce.UserService;
import uni.iit.miskolc.msc.ds.user.validator.Validator;

public class UserController {

    public UserController(UserService userService, Validator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    private UserService userService;
    private Validator validator;

    public void createUser(String userName) throws IllegalCharacterException, NotLongEnoughException {
        User user = new User(userName);
        validator.isValid(user);
        userService.saveUser(user);
    }

}
