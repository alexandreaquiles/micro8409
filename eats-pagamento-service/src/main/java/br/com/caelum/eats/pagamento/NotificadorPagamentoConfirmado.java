package br.com.caelum.eats.pagamento;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import br.com.caelum.eats.pagamento.AmqpPagamentoConfig.PagamentoSource;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificadorPagamentoConfirmado {
	
	private PagamentoSource source;

	void notificaConfirmacaoDePagamento(Pagamento pagamento) {
		PagamentoConfirmado pagamentoConfirmado = new PagamentoConfirmado(pagamento);
		Message<PagamentoConfirmado> message = MessageBuilder.withPayload(pagamentoConfirmado).build();
		source.pagamentosConfirmados().send(message);
	}
}
