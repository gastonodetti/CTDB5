package com.dh.clinica_odontologica.clinica_odontologica.repository;
import com.dh.clinica_odontologica.clinica_odontologica.models.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {

}
