package br.com.caelum.eats.restaurante;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
class DistanciaRestClient {
	
	private RestTemplate restTemplate;
	private String distanciaServiceUrl;

	public DistanciaRestClient(RestTemplate restTemplate, @Value("${configuracao.distancia.service.url}") String distanciaServiceUrl) {
		this.restTemplate = restTemplate;
		this.distanciaServiceUrl = distanciaServiceUrl;
	}
	
	public void novoRestauranteAprovado(Restaurante restaurante) {
		String url = distanciaServiceUrl+"/restaurantes";
		RestauranteParaDistancia restauranteParaDistancia = new RestauranteParaDistancia(restaurante);

		ResponseEntity<RestauranteParaDistancia> responseEntity = restTemplate.postForEntity(url, restauranteParaDistancia, RestauranteParaDistancia.class);
		HttpStatus statusCode = responseEntity.getStatusCode();
		if (!HttpStatus.CREATED.equals(statusCode)) {
			throw new RuntimeException("Status code diferente do esperado: " + statusCode);
		}
	}
	
	@Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2000, multiplier = 2))
	public void restauranteAtualizado(Restaurante restaurante) {
		log.info("Monólito tentando chamar distancia-service");
		
		String url = distanciaServiceUrl+"/restaurantes/"+restaurante.getId();
		RestauranteParaDistancia restauranteParaDistancia = new RestauranteParaDistancia(restaurante);
		restTemplate.put(url, restauranteParaDistancia);
	}

}
