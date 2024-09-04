package cl.nescorp.provider.aplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import cl.nescorp.provider.aplication.dto.FuncionarioDTO;
import cl.nescorp.provider.aplication.dto.ResponseDTO;
import cl.nescorp.provider.aplication.entity.EstadoFuncionarioEnum;
import cl.nescorp.provider.aplication.entity.Funcionario;
import cl.nescorp.provider.aplication.repository.FuncionarioRepository;
import cl.nescorp.provider.aplication.util.Utils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioService {
	
	private final FuncionarioRepository funcionarioRepository;
	
	public ResponseDTO findAll() {
		List<FuncionarioDTO> dtoList = new ArrayList<>();
		List<Funcionario> listAll = funcionarioRepository.findAll();
		listAll.forEach(fun -> {
			dtoList.add(new FuncionarioDTO(fun));
		});
		return new ResponseDTO(HttpStatus.OK, dtoList);
	}

	public ResponseDTO findById(String id) {
		
		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			Funcionario fun = funcionarioRepository.findById(Long.valueOf(id)).orElse(new Funcionario());
			return new ResponseDTO(HttpStatus.OK, new FuncionarioDTO(fun));
		}
	}

	public ResponseDTO save(FuncionarioDTO request) {
		
		Funcionario fun = new Funcionario();
		fun.setNombres(request.getNombres());
		fun.setApellidos(request.getApellidos());
		fun.setCorreo(request.getCorreo());
		fun.setDni(Integer.parseInt(request.getRut()));
		fun.setNacimiento(Utils.parseDateStringToLocalDate(request.getFechaNacimiento()));
		fun.setEstado(EstadoFuncionarioEnum.ACTIVO.getId());
		fun.setFechaCreacion(Utils.findDateTimeNow());
		fun = funcionarioRepository.save(fun);
		return new ResponseDTO(HttpStatus.OK, fun.getId());

	}

	public ResponseDTO update(FuncionarioDTO request) {
		if (null == request.getId()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
		} else {
			Funcionario fun = funcionarioRepository.findById(Long.valueOf(request.getId())).orElse(null);
			if (null == fun) {
				return new ResponseDTO(HttpStatus.BAD_REQUEST, null);
			} else {
				fun.setNombres(request.getNombres());
				fun.setApellidos(request.getApellidos());
				fun.setCorreo(request.getCorreo());
				fun.setDni(Integer.parseInt(request.getRut()));
				fun.setNacimiento(Utils.parseDateStringToLocalDate(request.getFechaNacimiento()));
				fun.setEstado(Integer.valueOf(request.getEstado()));
				fun = funcionarioRepository.save(fun);
				return new ResponseDTO(HttpStatus.OK, new FuncionarioDTO(fun));
				
			}}
		
			
	}

	public ResponseDTO delete(String id) {
		if (null == id || id.isBlank() || id.isEmpty()) {
			return new ResponseDTO(HttpStatus.BAD_REQUEST, null);

		} else {
			funcionarioRepository.deleteById(Long.valueOf(id));
			return new ResponseDTO(HttpStatus.OK, new FuncionarioDTO());
		}
	}

}
