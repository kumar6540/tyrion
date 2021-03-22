package com.reactivepractice.fluxmonoEndpoints.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import com.reactivepractice.fluxmonoEndpoints.Entity.Employee;
import com.reactivepractice.fluxmonoEndpoints.Entity.Image;
import com.reactivepractice.fluxmonoEndpoints.service.ImageService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/reactapi")
public class MyController {

	@Autowired
	private ImageService imageservice;
	
	
	@GetMapping("/")
	public Mono<String> index(Model model) {
	model.addAttribute("images", imageservice.getImages());
	return Mono.just("index");
	}

	
	@GetMapping("/getimages")
	public Flux<Image> getAllImages(){
		
		return imageservice.getImages();
		
	}
	
	
	
	@GetMapping(value = "/getimage/{filename}")
	public Mono<ResponseEntity<?>> getoneImage(@PathVariable("filename") String filename){
		
		return imageservice.findOneImage(filename)
				.map(resource -> {
					try {
					return ResponseEntity.ok()
							.contentLength(resource.contentLength())
							.body(new InputStreamResource(
							resource.getInputStream()));
				}
					
				catch (Exception e) {
					return ResponseEntity.badRequest()
							.body("Couldn't find " + filename +
							" => " + e.getMessage());
               			}
				});
				
	}
	
	@PostMapping(value = "/createimage")
	public Mono<String> createFile(@RequestPart(name = "file")
	Flux<FilePart> files) {
	return imageservice.createImage(files)
	.then(Mono.just("redirect:/reactapi/"));
	}
	
	@DeleteMapping(value = "/delete/{filename}")
	public Mono<String> deleteFile(@PathVariable String filename) {
		return imageservice.deleteImage(filename)
		.then(Mono.just("redirect:/reactapi/"));
		}
	
	
	
}
