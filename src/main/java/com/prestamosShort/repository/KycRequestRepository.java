package com.prestamosShort.repository;


import com.prestamosShort.entity.KycRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KycRequestRepository extends JpaRepository<KycRequest, Long> {
}
