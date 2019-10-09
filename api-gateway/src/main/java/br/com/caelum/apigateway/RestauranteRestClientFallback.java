package br.com.caelum.apigateway;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
class RestauranteRestClientFallback implements RestauranteRestClient {

	@Override
	public Map<String, Object> porId(Long restauranteId) {
		//TODO: buscar restaurante do cache
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("restauranteId", restauranteId);
		return dados;
	}

}
