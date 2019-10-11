import org.springframework.cloud.contract.spec.Contract
Contract.make {

	description "deve confirmar pagamentos"
	
	label 'pagamento_confirmado'
	
	input {
		triggeredBy('notificaConfirmacaoPagamento()')
	}

	outputMessage {
	
		sentTo 'pagamentosConfirmados'
		
		headers {
			messagingContentType(applicationJson());
		}

		body ([
			pagamentoId: 2,
			pedidoId: 3
		])		
		
		
	
	
	}
}