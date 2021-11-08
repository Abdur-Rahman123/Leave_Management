package com.example.demo.repo;

import com.example.demo.model.Reason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReasonRepo extends JpaRepository<Reason,Long> {
}
