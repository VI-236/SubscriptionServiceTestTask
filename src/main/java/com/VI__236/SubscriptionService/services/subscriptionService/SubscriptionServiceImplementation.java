package com.VI__236.SubscriptionService.services.subscriptionService;

import com.VI__236.SubscriptionService.models.SubscriptionModel;
import com.VI__236.SubscriptionService.models.UserModel;
import com.VI__236.SubscriptionService.repositories.SubscriptionsRepository;
import com.VI__236.SubscriptionService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubscriptionServiceImplementation implements SubscriptionService{

    private UserRepository userRepository;
    private UserModel userModel;
    private SubscriptionsRepository subscriptionsRepository;
    private List<SubscriptionModel> subscriptionList;

    @Autowired
    public SubscriptionServiceImplementation(UserRepository userRepository,
                                             UserModel userModel,
                                             SubscriptionsRepository subscriptionsRepository){

        this.userRepository = userRepository;
        this.userModel = userModel;
        this.subscriptionsRepository = subscriptionsRepository;
    }

    @Override
    @Transactional
    public List<SubscriptionModel> addSubscription(Long userId, Long subscriptionId) {
        userModel = userRepository.getUserById(userId);
        userModel.getUserSubscriptions().add(subscriptionsRepository.getById(subscriptionId));

        userRepository.save(userModel);

        return userModel.getUserSubscriptions();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubscriptionModel> getUserSubscriptions(Long userId) {
        userModel = userRepository.getUserById(userId);

        return userModel.getUserSubscriptions();
    }

    @Override
    @Transactional
    public List<SubscriptionModel> deleteSubscription(Long userId, Long subscriptionId) {
        userModel = userRepository.getUserById(userId);
        userModel.getUserSubscriptions().remove(subscriptionsRepository.getById(subscriptionId));

        userRepository.save(userModel);

        return userModel.getUserSubscriptions();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object[]> findTopThreeSubscriptions() {
        return subscriptionsRepository.findTopThreeSubscriptions();
    }
}
