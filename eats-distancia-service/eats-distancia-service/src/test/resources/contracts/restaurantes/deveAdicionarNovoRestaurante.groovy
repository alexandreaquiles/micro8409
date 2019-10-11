import org.springframework.cloud.contract.spec.Contract
Contract.make {

	description "deve poder inserir um novo restaurante aprovado"

	request {
		method POST()
		url("/restaurantes")
		headers {
			contentType("application/json")
		}
		body ([
			id: 2,
		    cep: '71500-000',
		    tipoDeCozinhaId: 1
		])
	}
	response {
		status 201
		headers {
			contentType("application/json")
		}
		body ([
			id: 2,
		    cep: '71500-000',
		    tipoDeCozinhaId: 1
		])
	} 

}
