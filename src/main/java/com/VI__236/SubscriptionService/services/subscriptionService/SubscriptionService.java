package com.VI__236.SubscriptionService.services.subscriptionService;

import com.VI__236.SubscriptionService.models.SubscriptionModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubscriptionService {

    List<SubscriptionModel>addSubscription(Long userId, Long subscriptionId);
    List<SubscriptionModel> getUserSubscriptions(Long userId);
    List<SubscriptionModel> deleteSubscription(Long userId, Long subId);
    List<Object[]> findTopThreeSubscriptions();
}
