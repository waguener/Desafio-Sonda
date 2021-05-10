package com.tinnova.apiRest.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.tinnova.apiRest.model.Aeronave;
import com.tinnova.apiRest.model.AeronaveJson;
import com.tinnova.apiRest.model.AeronaveJsonAno;
import com.tinnova.apiRest.model.Aeronave;
import com.tinnova.apiRest.repository.AeronaveRepository;

@Service
public class AeronaveServices {

	private AeronaveRepository aeronaveRepository;

	@PersistenceContext
	EntityManager entityManager;

	public AeronaveServices(AeronaveRepository ar) {
		super();
		this.aeronaveRepository = ar;
	}

	// Buscar aeronave por id
	public Aeronave getAeronave(int id) {

		Aeronave aeronave = aeronaveRepository.findById(id);

		return aeronave;
	}
	
	// Total por marca
	public List<AeronaveJson> getTotalMarcas() {
		
		List<Aeronave> aeronaves = new ArrayList<Aeronave>();
		List<AeronaveJson> aeronavesJson = new ArrayList<AeronaveJson>();
		
		aeronaves = aeronaveRepository.findAll();
		
		for(Aeronave a : aeronaves) {
			String queryMarcas = String.format("select marca from aeronave where '%s'", a.getMarca());
			List<String> marcas = new ArrayList<String>();
			marcas = entityManager.createNativeQuery(queryMarcas).getResultList();
			int total = marcas.size();
			AeronaveJson aeronaveJson = new AeronaveJson();
			
			aeronaveJson.marca = a.getMarca();
			aeronaveJson.total = total;
			aeronavesJson.add(aeronaveJson);
		}
		
		return aeronavesJson;
	}
	
	// Total por Ano
		public List<AeronaveJsonAno> getTotalAno() {
			
			List<Aeronave> aeronaves = new ArrayList<Aeronave>();
			List<AeronaveJsonAno> aeronavesJsonAnos = new ArrayList<AeronaveJsonAno>();
			
			aeronaves = aeronaveRepository.findAll();
			
			for(Aeronave a : aeronaves) {
				String queryMarcas = String.format("select ano from aeronave where '%s'", a.getAno());
				List<Integer> anos = new ArrayList<Integer>();
				anos = entityManager.createNativeQuery(queryMarcas).getResultList();
				int total = anos.size();
				AeronaveJsonAno aeronaveJsonAno = new AeronaveJsonAno();
				
				aeronaveJsonAno.ano = a.getAno();
				aeronaveJsonAno.total = total;
				aeronavesJsonAnos.add(aeronaveJsonAno);
			}
			
			return aeronavesJsonAnos;
		}
	
	// Buscar aeronave por modelo
		public Aeronave getAeronaveModelo(String modelo) {
			Aeronave aeronave = new Aeronave();
			try {
				String queryModelo = String.format("select * from aeronave where modelo = '%s'", modelo);
				aeronave = (Aeronave) entityManager.createNativeQuery(queryModelo).getSingleResult();
				return aeronave;
			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
			return aeronave;
		}
	

	// Total de aeronaves Vendidos
	public int totalVendidos() {
		int total = 0;
		try {

			String query = "select count(vendido) from aeronave where vendido = true";
			total = Integer.parseInt(entityManager.createNativeQuery(query).getSingleResult().toString());

			return total;
		} catch (Exception e) {
			return total;
		}
	}
	
	// Total de aeronaves 
		public int total() {
			int total = 0;
			try {

				String queryTotal = "select count(id) from aeronave";
				total = Integer.parseInt(entityManager.createNativeQuery(queryTotal).getSingleResult().toString());

				return total;
			} catch (Exception e) {
				return total;
			}
		}

	// Atualiza aeronave
	public Boolean updateAeronave(Aeronave aeronave) {

		try {

			aeronaveRepository.save(aeronave);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	// Exclui aeronave
	public Boolean deleteAeronave(Aeronave aeronave) {

		try {
			aeronaveRepository.delete(aeronave);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
