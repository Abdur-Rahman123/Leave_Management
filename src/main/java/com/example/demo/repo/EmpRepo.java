package com.example.demo.repo;

import com.example.demo.model.Employee;
import net.bytebuddy.TypeCache;
import org.hibernate.mapping.Join;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Long> {
    @Query(value = "SELECT e.emp_id as empId,e.name as empName FROM employee e ",nativeQuery = true)
      List<Object[]> AllUser();
}
