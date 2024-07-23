package cl.nescorp.provider.aplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.nescorp.provider.aplication.dto.MecanismoCompraDTO;
import cl.nescorp.provider.aplication.entity.MecanismoCompra;
import cl.nescorp.provider.aplication.repository.MecanismoCompraRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IndicePresupuestarioService {
	
	private final MecanismoCompraRepository mecanismoComprarepository;
	
	public List<MecanismoCompraDTO> findAll() {
		
		List<MecanismoCompraDTO> dtoList= new ArrayList<>();
		List<MecanismoCompra> listAll= mecanismoComprarepository.findAll();
		
		listAll.forEach(mc->{
			dtoList.add(new MecanismoCompraDTO(mc));
			
		});
		return dtoList;
	}

}
