package br.com.caelum.eats.distancia;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@ImportAutoConfiguration(exclude = MongoAutoConfiguration.class)
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestaurantesBase {

	@Autowired
	private RestaurantesController restaurantesController;
	
	@MockBean
	private RestauranteRepository restauranteRepository;
	
	@Before
	public void before() {
		RestAssuredMockMvc.standaloneSetup(restaurantesController);
		
		Mockito.when(restauranteRepository.insert(Mockito.any(Restaurante.class)))
			.thenAnswer((InvocationOnMock i) -> {
				return i.getArgument(0);
			});
	}
	
	
	
}
