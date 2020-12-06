package com.Brayan_Vargas.taller1.repository;

import com.Brayan_Vargas.taller1.model.Userr;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserrRepository extends CrudRepository<Userr,Long> {

    List<Userr> findByUserName(String name);
}
