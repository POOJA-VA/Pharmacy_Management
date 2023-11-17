package com.restapi.controller;

import com.restapi.model.Medicine;
import com.restapi.model.Role;
import com.restapi.response.common.APIResponse;
import com.restapi.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/medicine")
//@PreAuthorize("hasRole('ROLE_USER')")
@RolesAllowed(Role.USER)
public class MedicineController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllMedicine() {
        List<Medicine> medicineList = medicineService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(medicineList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
