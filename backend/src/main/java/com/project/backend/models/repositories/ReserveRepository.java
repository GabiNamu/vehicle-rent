package com.project.backend.models.repositories;

import com.project.backend.models.entities.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Reserve repository.
 */
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
}
