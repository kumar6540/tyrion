package com.learningreacticespring.fluxandmonoplayground;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class FluxAndmonoTest {
	
	
	@Test
	public void fluxTest() {
		
		Flux<String> stringFlux = Flux.just("spring","SPring boot","Reactive Spring")
				 .concatWith(Flux.error(()->new RuntimeException("Exception Occured"))) .log();
	
	
		stringFlux.subscribe(System.out::println,(e)->System.err.println("Exception is"+ e));
	
	}

}
