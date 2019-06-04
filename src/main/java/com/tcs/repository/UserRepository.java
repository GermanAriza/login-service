package com.tcs.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tcs.model.User;

/**
 * @author german_ariza
 * 
 *         Clase encargada de exponer las operaciones CRUD sobre la entidad
 *         User.
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	public Optional<User> findByUsername(String username);
}