package br.com.hilker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hilker.entity.Fazenda;

@Repository
public interface FazendaRepo extends CrudRepository<Fazenda, Long> {


}
