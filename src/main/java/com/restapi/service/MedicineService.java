package com.restapi.service;

import com.restapi.dto.MedicineDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Category;
import com.restapi.model.Medicine;
import com.restapi.repository.CategoryRepository;
import com.restapi.repository.MedicineRepository;
import com.restapi.request.MedicineRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
    @Service
    public class MedicineService {

        @Autowired
        private MedicineDto medicineDtoDto;

        @Autowired
        private CategoryRepository categoryRepository;

        @Autowired
        private MedicineRepository medicineRepository;

        public List<Medicine> findAll() {
            return medicineRepository.findAll();
        }

        @Transactional
        public List<Medicine> createMedicine(MedicineRequest medicineRequest) {
            Medicine medicine = medicineDtoDto.mapToBook(medicineRequest);
            Category category = categoryRepository.findById(medicineRequest.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                            "CategoryId", medicineRequest.getCategoryId()));
            medicine.setCategory(category);
            medicineRepository.save(medicine);
            return findAll();
        }

        @Transactional
        public List<Medicine> updateMedicine(MedicineRequest medicineRequest) {
            Medicine medicine = medicineDtoDto.mapToBook(medicineRequest);
            Category category = categoryRepository.findById(medicineRequest.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                            "CategoryId", medicineRequest.getCategoryId()));
            medicine.setCategory(category);
            medicineRepository.save(medicine);
            return findAll();
        }

        public List<Medicine> deleteById(Integer id) {
            medicineRepository.deleteById(Long.valueOf(id));
            return findAll();
        }
}
