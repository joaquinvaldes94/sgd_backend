package cl.nescorp.provider.aplication.service;

import org.springframework.stereotype.Service;

import cl.nescorp.provider.aplication.dto.CargoDTO;
import cl.nescorp.provider.aplication.dto.ResponseDTO;
import cl.nescorp.provider.aplication.repository.CargoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CargoService {
	
	private final CargoRepository cargoRepo;
	
	
	public ResponseDTO findAll() {
		// TODO Auto-generated method stub
		return null;
	}

public ResponseDTO findById(String id) {
	// TODO Auto-generated method stub
	return null;
}

public ResponseDTO save(CargoDTO request) {
	// TODO Auto-generated method stub
	return null;
}

public ResponseDTO update(CargoDTO request) {
	// TODO Auto-generated method stub
	return null;
}

public ResponseDTO delete(String id) {
	// TODO Auto-generated method stub
	return null;
}
	
	

}
