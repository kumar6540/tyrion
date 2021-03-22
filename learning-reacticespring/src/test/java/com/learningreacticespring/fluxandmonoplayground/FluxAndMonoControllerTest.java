package com.learningreacticespring.fluxandmonoplayground;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import com.learningreacticespring.controller.FluxandMonoController;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


@WebFluxTest(controllers = FluxandMonoController.class)
public class FluxAndMonoControllerTest {

	
	@Autowired
	WebTestClient webtestclient;
	
	@Test
	@DisplayName("This elements test")
	public void flux_approach1() {
		
		Flux<Integer> integerFlux = webtestclient.get().uri("/flux")
				.accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isOk()
				.returnResult(Integer.class)
				.getResponseBody();
		
		
		StepVerifier.create(integerFlux)
		.expectSubscription()
		.expectNext(1)
		.expectNext(2)
		.expectNext(3)
		.expectNext(4)		
		.verifyComplete();
		
	}
	
	

	@Test
	@DisplayName("This output elements count test")
	public void flux_approach2() {
		
		 webtestclient.get().uri("/flux")
				.accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isOk()
				.expectBodyList(Integer.class)
				.hasSize(4);
	
	}


	@Test
	@DisplayName("This output elements Matches with expected elements test")
	public void flux_approach3() {
		
		List<Integer> expectedIntegerlis = Arrays.asList(1,2,3,4);
		
		EntityExchangeResult<List<Integer>> entityExchageResult=  webtestclient.get().uri("/flux")
				.accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isOk()
				.expectBodyList(Integer.class)
				.returnResult();

	Assertions.assertEquals(expectedIntegerlis, entityExchageResult.getResponseBody());

}
	
	@Test
	@DisplayName("This output elements Matches with expected elements test with consumer")
	public void flux_approach4() {
		
		List<Integer> expectedIntegerlis = Arrays.asList(1,2,3,4);
		
		webtestclient.get().uri("/flux")
				.accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isOk()
				.expectBodyList(Integer.class)
				.consumeWith((res)->{

					Assertions.assertEquals(res.getResponseBody(),expectedIntegerlis);	
				});
}
	
	
	@Test
	@DisplayName("This flux stream elements test")
	public void flux_Stream() {
		
		Flux<Long> longFlux = webtestclient.get().uri("/fluxstream")
				.accept(MediaType.TEXT_EVENT_STREAM)
				.exchange().expectStatus().isOk()
				.returnResult(Long.class)
				.getResponseBody();
	
		

		StepVerifier.create(longFlux)
		.expectSubscription()
		.expectNext(0l)
		.expectNext(1l)
		.expectNext(2l)
		.thenCancel()
		.verify();
	}	
	

	
	@Test
	public void mono() {
		
		Integer expectedValue = 1;
		
		
		webtestclient.get().uri("/mono")
		.accept(MediaType.APPLICATION_JSON)
		.exchange()
		.expectStatus().isOk()
		.expectBody(Integer.class)
		.consumeWith((res)->{
			Assertions.assertEquals(expectedValue, res.getResponseBody());
		});
	}
}