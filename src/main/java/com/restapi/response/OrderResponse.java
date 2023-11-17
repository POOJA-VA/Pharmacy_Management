package com.restapi.response;

import com.restapi.model.Address;
import com.restapi.model.OrderedMedicine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long id;
    private List<OrderedMedicine> orderedMedicineList;
    private Long userId;
    private String name;
    private String username;
    private Address address;
    private String orderStatus;
}
