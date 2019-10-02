package br.com.caelum.eats.distancia;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

	List<Restaurante> findAllByAprovado(boolean aprovado);

	Page<Restaurante> findAllByAprovadoAndTipoDeCozinhaId(boolean aprovado, Long tipoId, Pageable limit);

	Page<Restaurante> findAllByAprovado(boolean aprovado, Pageable limit);

}
