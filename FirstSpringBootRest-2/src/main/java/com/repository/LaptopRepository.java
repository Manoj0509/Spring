package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
	
	Laptop findByLname(String lname);	
	 
 	@Query("Select l from Laptop l order by l.lname")
	List<Laptop> findByCompanySorted(String company);


}
