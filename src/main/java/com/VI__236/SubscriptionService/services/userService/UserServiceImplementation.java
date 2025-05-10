package com.VI__236.SubscriptionService.services.userService;

import com.VI__236.SubscriptionService.models.UserModel;
import com.VI__236.SubscriptionService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImplementation implements UserService {

    private UserModel userModel;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserModel userModel, UserRepository userRepository){
        this.userModel = userModel;
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public UserModel createUser(UserModel newUserModel) {
        userModel.setId(null);
        userModel.setName(newUserModel.getName());
        userModel.setUserSubscriptions(newUserModel.getUserSubscriptions());

        userRepository.save(userModel);

        return userModel;
    }

    @Override
    @Transactional(readOnly = true)
    public UserModel getUser(Long userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    @Transactional
    public UserModel updateUser(UserModel updatedUserModel) {
        if(userRepository.existsById(updatedUserModel.getId())){
            userModel.setId(updatedUserModel.getId());
            userModel.setName(updatedUserModel.getName());
            userModel.setUserSubscriptions(updatedUserModel.getUserSubscriptions());

            userRepository.save(userModel);
        }

        return userModel;
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
