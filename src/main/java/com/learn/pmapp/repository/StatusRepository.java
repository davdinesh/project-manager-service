package com.learn.pmapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.pmapp.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
