package br.com.caelum.eats.pagamento;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

@MockBeans(@MockBean(PagamentoRepository.class))
@ImportAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@AutoConfigureMessageVerifier
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@RunWith(SpringRunner.class)
public class PagamentosConfirmadosBase {

	@Autowired
	private NotificadorPagamentoConfirmado notificador;
	
	
	public void notificaConfirmacaoPagamento() {
		Pagamento pagamento = new Pagamento();
		pagamento.setId(2L);
		pagamento.setPedidoId(3L);
		notificador.notificaConfirmacaoDePagamento(pagamento );
	}
	
}
