package com.restapi.response;

import com.restapi.model.Medicine;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MedicineResponse {

        private List<Medicine> medicineList;
    }
