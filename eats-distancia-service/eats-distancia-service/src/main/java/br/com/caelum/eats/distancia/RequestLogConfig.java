package br.com.caelum.eats.distancia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
class RequestLogConfig {

	@Bean
	CommonsRequestLoggingFilter requestLoggingFilter() {
		CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
		loggingFilter.setIncludePayload(true);
		loggingFilter.setIncludeQueryString(true);
		loggingFilter.setIncludeHeaders(true);
		loggingFilter.setIncludeClientInfo(true);
		return loggingFilter;
	}
	
}
