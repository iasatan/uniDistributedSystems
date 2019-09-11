package uni.iit.miskolc.msc.ds.user.serivce;

import uni.iit.miskolc.msc.ds.user.model.User;

public class UserServiceImpl implements UserService {
    public void saveUser(User user) {
        System.out.println("Elmentve:" + user.getUsername());
    }
}
