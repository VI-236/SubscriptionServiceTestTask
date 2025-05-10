package com.VI__236.SubscriptionService.controllers;

import com.VI__236.SubscriptionService.models.SubscriptionModel;
import com.VI__236.SubscriptionService.models.UserModel;
import com.VI__236.SubscriptionService.services.subscriptionService.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService){
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/users/{id}/subscriptions")
    public List<SubscriptionModel> addSubscription(@PathVariable Long userId,
                                     @RequestBody Long subId){
        return subscriptionService.addSubscription(userId, subId);
    }

    @GetMapping("/users/{id}/subscriptions")
    public List<SubscriptionModel> getUserSubscriptions (@PathVariable Long userId){
        return subscriptionService.getUserSubscriptions(userId);
    }

    @DeleteMapping("/users/{id}/subscriptions/{subId}")
    public List<SubscriptionModel> deleteSubscription(@PathVariable Long id,
                                        @PathVariable Long subId){
        return subscriptionService.deleteSubscription(id, subId);
    }

    @GetMapping("/subscriptions/top")
    public List<Object[]> findTopThreeSubscriptions(){
        return  subscriptionService.findTopThreeSubscriptions();
    }
}
