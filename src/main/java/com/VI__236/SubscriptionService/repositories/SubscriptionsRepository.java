package com.VI__236.SubscriptionService.repositories;

import com.VI__236.SubscriptionService.models.SubscriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SubscriptionsRepository extends JpaRepository<SubscriptionModel, Long> {

    //Возвращает список из id 3 самых популярных подписок и количество её подписчиков.
    @Query(value = """
        SELECT subscription_id, COUNT(*) AS count 
        FROM users_subscriptions 
        GROUP BY subscription_id 
        ORDER BY count DESC 
        LIMIT 3
        """, nativeQuery = true)
    List<Object[]> findTopThreeSubscriptions();
}