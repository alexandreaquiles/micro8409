package br.com.caelum.apigateway;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
class RestaurantesComDistanciaController {

	private RestauranteRestClient restauranteRestClient;
	private DistanciaRestClient distanciaRestClient;
	
	@GetMapping("/restaurantes-com-distancia/{cep}/restaurante/{restauranteId}")
	Map<String, Object> porCepEIdComDistancia(@PathVariable("cep") String cep, 
								@PathVariable("restauranteId") Long restauranteId) {
		Map<String, Object> dadosDoRestaurante = restauranteRestClient.porId(restauranteId);
		Map<String, Object> dadosDeDistancia = distanciaRestClient.porCepEId(cep, restauranteId);
		dadosDoRestaurante.putAll(dadosDeDistancia);
		return dadosDoRestaurante;
	}
	
}
