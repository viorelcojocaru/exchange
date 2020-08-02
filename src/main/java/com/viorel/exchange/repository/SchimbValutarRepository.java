package com.viorel.exchange.repository;

import com.viorel.exchange.domain.SchimbValutar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchimbValutarRepository extends JpaRepository<SchimbValutar, Long> {

}
