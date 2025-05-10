package com.VI__236.SubscriptionService.repositories;

import com.VI__236.SubscriptionService.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserModel, Long>{
    UserModel getUserById(Long id);
}
