package com.missionlife.carbontracker.repository;

import com.missionlife.carbontracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Ye MySQL database se user ko find ya save karne ke liye built-in methods dega
}