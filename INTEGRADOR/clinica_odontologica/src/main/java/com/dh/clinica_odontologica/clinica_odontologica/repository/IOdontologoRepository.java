package com.dh.clinica_odontologica.clinica_odontologica.repository;
import com.dh.clinica_odontologica.clinica_odontologica.models.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

}
