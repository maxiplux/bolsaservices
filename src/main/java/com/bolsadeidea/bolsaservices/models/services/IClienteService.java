package com.bolsadeidea.bolsaservices.models.services;

import com.bolsadeidea.bolsaservices.models.entity.Cliente;
import com.bolsadeidea.bolsaservices.models.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface IClienteService {
	
	public List<Cliente> findAll();


	Page<Cliente> findAll(Pageable pageable);

	Cliente save(Cliente cliente);

	Optional<Cliente> findById(Long id);

	void delete(Cliente currentCliente);

	boolean existByEmail(String email) ;

	List<Region> findAllRegiones();
}
