package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.model.Laptop;
import com.repository.LaptopRepository;

@Service
public class LaptopService {
	
	@Autowired
	LaptopRepository repo;
	
	public Laptop addLaptop(Laptop c)
	{
		 repo.save(c);	
		 return c;
	}
	
	public List<Laptop> getLaptop()
	{
		List<Laptop> lc2=repo.findAll();
		
		return lc2;
	}

	public Laptop getLaptopById(int lid) throws Throwable {
		Supplier s1= ()->new ResourceNotFoundException("Laptop Does not exist in the database");
		Laptop l=repo.findById(lid).orElseThrow(s1);
		return l;
	}

	public String deleteLaptopById(int lid) {
		
		repo.deleteById(lid);
		
		return "Deleted";
	}

	public String deleteLaptop(Laptop l) {
		
		repo.delete(l);
		return "Deleted";
	}

	public Laptop updateLaptop(Laptop l) throws Throwable {
		int id=l.getLid();
		
		Supplier s1= ()->new ResourceNotFoundException("Laptop Does not exist in the database");
		Laptop l1=repo.findById(id).orElseThrow(s1);
		
		l1.setLname(l.getLname());
			l1.setCompany(l.getCompany());
			repo.save(l1);
			return l1;	
	}

	public List<Laptop> addLaptops(List<Laptop> lp) {
		repo.saveAll(lp);
		return lp;
	}
	
	public Laptop getLaptopByLname(String lname) {
		Laptop l=repo.findByLname(lname);
		return l;
	}
	
	public List<Laptop> findByCompanySorted(String company) 
	{
		List<Laptop> lp=repo.findByCompanySorted(company);
	return lp;
	}

}
