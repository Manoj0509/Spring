package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Laptop;
import com.service.LaptopService;

@RestController
@RequestMapping(path="/api")
public class LaptopController {
	
	@Autowired
	LaptopService laptopservice;
	
	
	@PostMapping("/addLaptop")
	public ResponseEntity<Laptop> addLaptop(@RequestBody Laptop l)
	{
		Laptop l1=laptopservice.addLaptop(l);
		ResponseEntity re=new ResponseEntity<Laptop>(l1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getLaptops")
	public ResponseEntity<List<Laptop>> getLaptop()
	{
		List<Laptop> lp1=laptopservice.getLaptop();
		ResponseEntity re=new ResponseEntity<List<Laptop>>(lp1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getLaptop/{lid}")
	public ResponseEntity<Laptop> getEmpById(@PathVariable int lid) throws Throwable
	{
		Laptop l1=laptopservice.getLaptopById(lid);
		
		ResponseEntity re=new ResponseEntity<Laptop>(HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addLaptops")
	public ResponseEntity<List<Laptop>> addLaptops(@RequestBody List<Laptop> lp)
	{
		List<Laptop> le=laptopservice.addLaptops(lp);
		
		ResponseEntity re=new ResponseEntity<List<Laptop>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateLaptop")
	public ResponseEntity<Laptop> updateLaptop(@RequestBody Laptop e) throws Throwable
	{
		Laptop e1=laptopservice.updateLaptop(e);
		
		ResponseEntity re=new ResponseEntity<Laptop>(e1,HttpStatus.OK);
		return re;
	}
	
/*	@DeleteMapping(path="/deleteCoder")
	public ResponseEntity<String> deleteCoder(@RequestBody Coder e)
	{
		coderservice.deleteCoder(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteCoder/{eid}")
	public ResponseEntity<String> deleteCoderById(@PathVariable int eid)
	{
		coderservice.deleteCoderById(eid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getCodername/{cname}")
	public ResponseEntity<Coder> getCoderByCname(@PathVariable String cname) 
	{
		Coder c=coderservice.getCoderByCname(cname);
		ResponseEntity re=new ResponseEntity<Coder>(c,HttpStatus.OK);
		return re;
	}
	*/
	@GetMapping("/getLaptopscompany/{company}")
	public ResponseEntity<List<Laptop>> findByCompanySorted(@PathVariable String company) 
	{
		List<Laptop> lp=laptopservice.findByCompanySorted(company);
		ResponseEntity re=new ResponseEntity<List<Laptop>>(lp,HttpStatus.OK);
		return re;
	}

}
