package com.student.management.MAINET10.Repository;

import com.student.management.MAINET10.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT emp FROM Employee emp WHERE emp.userName = :userName")
    public Employee findByUserName(@Param("userName") String userName);
}
