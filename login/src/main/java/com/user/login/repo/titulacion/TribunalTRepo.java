package com.user.login.repo.titulacion;

import java.util.List;

import com.user.login.modelo.titulacion.tribunalt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TribunalTRepo extends JpaRepository <tribunalt, Integer> {   
     
}
