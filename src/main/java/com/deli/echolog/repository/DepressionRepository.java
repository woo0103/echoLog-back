package com.deli.echolog.repository;

import com.deli.echolog.domain.Depression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepressionRepository extends JpaRepository<Depression, Long> {
}
