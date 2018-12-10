package com.bolsadeidea.bolsaservices.models.services;

import java.util.List;
import java.util.Optional;

import com.bolsadeidea.bolsaservices.models.dao.IClienteDao;
import com.bolsadeidea.bolsaservices.models.entity.Cliente;
import com.bolsadeidea.bolsaservices.models.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}


	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findById(Long id) {
		return this.clienteDao.findById(id);
	}


	@Transactional(readOnly = true)
	public Optional<Cliente> findByEmail(String email) {
		return this.clienteDao.findByEmail(email);
	}

	@Transactional(readOnly = true)
	public boolean existByEmail(String email) {
		return this.clienteDao.existsByEmail(email);
	}

	@Override
	public void delete(Cliente currentCliente) {
		this.clienteDao.delete(currentCliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllRegiones() {
		return	this.clienteDao.findallRegions();
	}


}
