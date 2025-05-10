package com.VI__236.SubscriptionService.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Data
@Table(name = "subscriptions")
@NoArgsConstructor
@AllArgsConstructor
@Component
@Setter
@Getter
public class SubscriptionModel {

    @Id
    @Column(name = "subscription_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "userSubscriptions")
    private List<UserModel> usersOfSubscription;
}
