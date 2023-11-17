package com.restapi.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegisterRequest {

    @NotEmpty
    @Size(min = 8, message = "Username should have at least 8 characters")
    private String username;

    @NotEmpty
    @Size(min = 5, message = "Password should have at least 5 characters")
    private String password;

    @NotEmpty
    @Size(min = 3, message = "Name should have at least 3 characters")
    private String name;
}
