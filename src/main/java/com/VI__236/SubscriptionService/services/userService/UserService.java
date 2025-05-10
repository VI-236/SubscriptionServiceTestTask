package com.VI__236.SubscriptionService.services.userService;

import com.VI__236.SubscriptionService.models.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserModel createUser(UserModel newUserModel);
    UserModel getUser(Long userId);
    UserModel updateUser(UserModel updatedUserModel);
    void deleteUser(Long id);
}

