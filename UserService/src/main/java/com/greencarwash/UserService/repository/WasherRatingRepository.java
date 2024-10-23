package com.greencarwash.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greencarwash.UserService.entities.WasherRating;

@Repository
public interface WasherRatingRepository extends JpaRepository<WasherRating, Long> {

}
