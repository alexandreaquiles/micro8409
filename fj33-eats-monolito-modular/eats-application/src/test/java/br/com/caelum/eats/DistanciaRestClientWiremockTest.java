package br.com.caelum.eats;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.eats.administrativo.TipoDeCozinha;
import br.com.caelum.eats.restaurante.DistanciaRestClient;
import br.com.caelum.eats.restaurante.Restaurante;

@AutoConfigureStubRunner(ids="br.com.caelum:eats-distancia-service:+:stubs:9992",stubsMode = StubsMode.LOCAL)
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistanciaRestClientWiremockTest {

	private DistanciaRestClient distanciaRestClient;
	
	@Before
	public void before() {
		distanciaRestClient = new DistanciaRestClient(new RestTemplate(), "http://localhost:9992");
	}
	
	@Test
	public void deveAdicionarNovoRestauranteAprovadoNoDistanciaService() {
		TipoDeCozinha tipoDeCozinha = new TipoDeCozinha();
		tipoDeCozinha.setId(1L);

		Restaurante restaurante = new Restaurante();
		restaurante.setId(2L);
		restaurante.setCep("71500-000");
		restaurante.setTipoDeCozinha(tipoDeCozinha);
		distanciaRestClient.novoRestauranteAprovado(restaurante);
	}
}












