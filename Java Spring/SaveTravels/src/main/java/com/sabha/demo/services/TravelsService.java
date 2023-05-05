package com.sabha.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sabha.demo.models.Travels;
import com.sabha.demo.repositories.TravelsRepository;

@Service
public class TravelsService {
	
    // adding the travel repository as a dependency
	private final TravelsRepository travelsRepository;
	
	public TravelsService(TravelsRepository travelsRepository) {
		this.travelsRepository =travelsRepository;
	}
	// returns all the travels
    public List<Travels> allTravels() {
        return travelsRepository.findAll();
    }
    // returns  the travel
    //public Travels findTravels(Long id) {
    //  return travelsRepository.findById(id).orElse(null);
	//}
    // adds a travel
    public Travels addTravels(Travels travel) {
        return travelsRepository.save(travel);
    }
    //update a travel
    public Travels updateTravels(Travels travel) {
        return travelsRepository.save(travel);
    }
    // delete a travel
    public void deleteTravels(Long id) {
    	travelsRepository.deleteById(id);
    }
    
    // retrieves a travel
    public Travels findTravels(Long id) {
       Optional<Travels> optionalTravels = travelsRepository.findById(id);
       if(optionalTravels.isPresent()) {
           return optionalTravels.get();
       } else {
           return null;
       }
    }
}
