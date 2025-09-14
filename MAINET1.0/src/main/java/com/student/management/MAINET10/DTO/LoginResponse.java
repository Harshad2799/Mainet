package com.student.management.MAINET10.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LoginResponse {
    private String username;
    private String organization;
    private List<String> error = new ArrayList<>();
    private String token;

}
