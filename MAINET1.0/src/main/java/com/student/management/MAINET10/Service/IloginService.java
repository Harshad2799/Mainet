package com.student.management.MAINET10.Service;

import com.student.management.MAINET10.DTO.LoginDto;
import com.student.management.MAINET10.Entity.Employee;

public interface IloginService {

    public LoginDto register(Employee empData);
}
