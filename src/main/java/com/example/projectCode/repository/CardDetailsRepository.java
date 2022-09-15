package com.example.projectCode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectCode.entity.CardDetails;

@Repository
public interface CardDetailsRepository extends JpaRepository<CardDetails,Long>{

}
