package com.bolsadeidea.bolsaservices.models.dao;

import com.bolsadeidea.bolsaservices.models.entity.Cliente;
import com.bolsadeidea.bolsaservices.models.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String email);
    boolean existsByEmail(String email);



    @Query("from Region")
    List<Region> findallRegions();

    //Page<Cliente> findAll(Pageable pageable);
}
