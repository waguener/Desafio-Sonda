package com.tinnova.apiRest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tinnova.apiRest.model.Aeronave;
import com.tinnova.apiRest.model.AeronaveJson;
import com.tinnova.apiRest.model.AeronaveJsonAno;
import com.tinnova.apiRest.model.Aeronave;
import com.tinnova.apiRest.repository.AeronaveRepository;
import com.tinnova.apiRest.services.AeronaveServices;

@RestController
@RequestMapping(value = "/api")
public class AeronaveController {
	
	@Autowired
	AeronaveRepository aeronaveRepository;
	
	private AeronaveServices aeronaveServices;
	
		
	public AeronaveController(AeronaveRepository aeronaveRepository) {
		super();
		this.aeronaveRepository = aeronaveRepository;
	}

	@GetMapping(value = "/aeronaves", produces = "application/json")
	public List<Aeronave> listaVeiculos(){
		return aeronaveRepository.findAll();
	}
	
	@GetMapping(value = "/aeronaves/total/marca", produces = "application/json")
	public List<AeronaveJsonAno> totalAeronaveAno(){
		List<AeronaveJsonAno> aeronaveJsonListAno = aeronaveServices.getTotalAno();
		return aeronaveJsonListAno;
	}
	
	@GetMapping(value = "/aeronaves/total/ano", produces = "application/json")
	public List<AeronaveJson> totalMarcas(){
		List<AeronaveJson> aeronaveJsonList = aeronaveServices.getTotalMarcas();
		return aeronaveJsonList;
	}
	
	@GetMapping(value = "/aeronaves/find", produces = "application/json")
	public Aeronave aeronaveId(@RequestParam(value = "modelo") String modelo){
		
		Aeronave aeronave = aeronaveServices.getAeronaveModelo(modelo);
		return aeronave;
	}
	
	@GetMapping(value = "/aeronave", produces = "application/json")
	public Aeronave aeronaveId(@RequestParam(value = "id") int id){
		
		Aeronave aeronave = aeronaveServices.getAeronave(id);
		return aeronave;
	}
	
	
	@GetMapping(value = "/veiculos/vendidos", produces = "application/json")
	public int totalAeronaves() {
		
		int total = aeronaveServices.totalVendidos();
		return total;
	}
	
	@GetMapping(value = "/aeronaves/total", produces = "application/json")
	public int total() {
		
		int total = aeronaveServices.total();
		return total;
	}
	
	@PostMapping(value = "/aeronaves", consumes = "application/json")
	public Aeronave salvarAeronave(@RequestBody Aeronave aeronave) {
		
		return aeronaveRepository.save(aeronave);
	}
	
	@PutMapping(value = "/aeronaves/update", consumes = "application/json")
	public Boolean updateVeiculo(@RequestBody Aeronave aeronave) {
		
		Boolean response =  aeronaveServices.updateAeronave(aeronave);
		
		return response;
	}
	
	@DeleteMapping(value = "/aeronaves/delete")
	public Boolean deleteVeiculo(@RequestBody Aeronave aeronave) {
		
		Boolean response = aeronaveServices.deleteAeronave(aeronave);
		return response;
	}
}
