package uni.iit.miskolc.msc.ds.user.controller;

import org.junit.jupiter.api.Test;
import uni.iit.miskolc.msc.ds.user.exception.IllegalCharacterException;
import uni.iit.miskolc.msc.ds.user.exception.NotLongEnoughException;
import uni.iit.miskolc.msc.ds.user.model.User;
import uni.iit.miskolc.msc.ds.user.serivce.UserService;
import uni.iit.miskolc.msc.ds.user.validator.Validator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Test
    void register_notValidUser_saveCalledOnce() throws IllegalCharacterException, NotLongEnoughException {
        Validator validator = mock(Validator.class);
        when(validator.isValid(any())).thenReturn(false);
        UserService userService = mock(UserService.class);

        UserController userController = new UserController(userService, validator);
        userController.createUser("asdas");
        verify(userService, never()).saveUser(any(User.class));
    }

    @Test
    void register_validUser_saveCalledOnce() throws IllegalCharacterException, NotLongEnoughException {
        Validator validator = mock(Validator.class);
        when(validator.isValid(any())).thenReturn(true);
        UserService userService = mock(UserService.class);

        UserController userController = new UserController(userService, validator);
        userController.createUser("asdasd");
        verify(userService, times(1)).saveUser(any(User.class));
    }
}