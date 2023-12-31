package com.idho.learningcase.raceconditioncase.repository;

import com.idho.learningcase.raceconditioncase.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Updated by Idho.
 * Date: 06.04.2023
 * Time: 9:11
 */

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {
}
