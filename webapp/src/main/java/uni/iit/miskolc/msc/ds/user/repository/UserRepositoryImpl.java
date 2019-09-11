package uni.iit.miskolc.msc.ds.user.repository;

import uni.iit.miskolc.msc.ds.user.model.User;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public void saveUser(User user) {
        System.out.println("Elmentve:" + user.getUsername());
    }
}
