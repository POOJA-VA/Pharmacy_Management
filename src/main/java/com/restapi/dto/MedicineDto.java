package com.restapi.dto;

import com.restapi.model.Medicine;
import com.restapi.request.MedicineRequest;
import com.restapi.response.MedicineResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicineDto {

    public MedicineResponse mapTomedicineResponse(List<Medicine> medicineList) {
        return new MedicineResponse(medicineList);
    }

    public Medicine mapToBook(MedicineRequest medicineRequest) {
        Medicine medicine = new Medicine();
        if (medicineRequest.getId() != null) {
            medicine.setId(medicineRequest.getId());
        }
        medicine.setPrice(medicineRequest.getPrice());
        medicine.setDescription(medicineRequest.getDescription());
        medicine.setTitle(medicineRequest.getTitle());
        medicine.setPhoto(medicineRequest.getPhoto());
        medicine.setDate(medicineRequest.getDate());
        return medicine;
    }
}
