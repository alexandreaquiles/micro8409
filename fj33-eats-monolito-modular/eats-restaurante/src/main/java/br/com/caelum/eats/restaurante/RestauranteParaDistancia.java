package br.com.caelum.eats.restaurante;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestauranteParaDistancia {
	
	private Long id;
	private String cep;
	private Long tipoDeCozinhaId;

	public RestauranteParaDistancia(Restaurante restaurante) {
		this(restaurante.getId(), restaurante.getCep(), restaurante.getTipoDeCozinha().getId());
	}
	
	
}
