package br.com.caelum.notafiscal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.caelum.notafiscal.pedido.PedidoDto;
import br.com.caelum.notafiscal.pedido.PedidoRestClient;

@AutoConfigureStubRunner(ids="br.com.caelum:eats-pagamento-service", stubsMode = StubsMode.LOCAL)
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProcessadorDePagamentosTest {

	@MockBean
	private GeradorDeNotaFiscal gerador;
	
	@MockBean
	private PedidoRestClient pedidoRestClient;
	
	@Autowired
	private StubTrigger stubTrigger;
	
	@SpyBean
	private ProcessadorDePagamentos processador;
	
	@Test
	public void deveProcessarPagamentoConfirmado() {
		stubTrigger.trigger("pagamento_confirmado");
		
		PedidoDto pedido = new PedidoDto();
		
		Mockito.when(pedidoRestClient.detalhaPorId(3L)).thenReturn(pedido);
		Mockito.when(gerador.geraNotaPara(pedido)).thenReturn("<xml>...</xml>");
	
		Mockito.verify(processador).processaPagamento(Mockito.any(PagamentoConfirmado.class));
	}

}
