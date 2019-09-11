package uni.iit.miskolc.msc.ds.user.serivce;

import uni.iit.miskolc.msc.ds.user.model.User;
import uni.iit.miskolc.msc.ds.user.repository.UserRepository;

public class UserServiceImpl implements UserService {
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.saveUser(user);
    }
}
