package uni.iit.miskolc.msc.ds;

import uni.iit.miskolc.msc.ds.user.controller.UserController;
import uni.iit.miskolc.msc.ds.user.exception.IllegalCharacterException;
import uni.iit.miskolc.msc.ds.user.exception.NotLongEnoughException;
import uni.iit.miskolc.msc.ds.user.repository.UserRepositoryImpl;
import uni.iit.miskolc.msc.ds.user.serivce.UserServiceImpl;
import uni.iit.miskolc.msc.ds.user.validator.AccountValidator;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IllegalCharacterException, NotLongEnoughException {
        UserController userController = new UserController(new UserServiceImpl(new UserRepositoryImpl()), new AccountValidator());
        userController.createUser("adam01");
        try {
            userController.createUser("adam");
        } catch (NotLongEnoughException e) {
            System.out.println("Rövid");
        }
    }
}
