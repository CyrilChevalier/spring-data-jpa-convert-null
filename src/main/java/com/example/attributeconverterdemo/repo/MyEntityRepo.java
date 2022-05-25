package com.example.attributeconverterdemo.repo;

import com.example.attributeconverterdemo.domain.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *                  MyEntity Repository
 * </p>
 *
 * @author Ccr
 * @since 1.22.0
 */
public interface MyEntityRepo extends JpaRepository<MyEntity, Long> {

    /**
     * Find by date (nullable)
     * @param date
     * @return
     */
    @Query("select e from MyEntity e WHERE e.date = :date")
    List<MyEntity> findByDate(@Param("date") LocalDate date);
}
