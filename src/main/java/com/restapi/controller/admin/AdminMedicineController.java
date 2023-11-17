package com.restapi.controller.admin;

import com.restapi.model.Medicine;
import com.restapi.model.Role;
import com.restapi.request.MedicineRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin/medicine")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RolesAllowed(Role.ADMIN)
public class AdminMedicineController {

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

    @PostMapping
    public ResponseEntity<APIResponse> createMedicine(@RequestBody MedicineRequest medicineRequest) {
        List<Medicine> medicineList = medicineService.createMedicine(medicineRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(medicineList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<APIResponse> updateMedicine(@RequestBody MedicineRequest medicineRequest) {
        List<Medicine> medicineList = medicineService.updateMedicine(medicineRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(medicineList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteMedicine(@PathVariable Integer id) {
        List<Medicine> medicineList = medicineService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(medicineList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
