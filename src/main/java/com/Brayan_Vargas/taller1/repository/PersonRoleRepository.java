package com.Brayan_Vargas.taller1.repository;

import com.Brayan_Vargas.taller1.model.PersonRole;
import com.Brayan_Vargas.taller1.model.PersonRolePK;
import org.springframework.data.repository.CrudRepository;

public interface PersonRoleRepository extends CrudRepository<PersonRole, PersonRolePK> {
}
