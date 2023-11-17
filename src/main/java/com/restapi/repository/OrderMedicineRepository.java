package com.restapi.repository;

import com.restapi.model.OrderedMedicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMedicineRepository extends JpaRepository<OrderedMedicine, Long> {
    List<OrderedMedicine> findByOrderId(Long orderId);
}