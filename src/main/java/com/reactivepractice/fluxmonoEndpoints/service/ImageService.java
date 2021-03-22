package com.reactivepractice.fluxmonoEndpoints.service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.reactivepractice.fluxmonoEndpoints.Entity.Image;
import com.reactivepractice.fluxmonoEndpoints.repository.ImageRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ImageService {
	
	
	private static String UPLOAD_ROOT = "C:\\javaIO";
	
	private final ResourceLoader resourceLoader;
	
	private final ImageRepository imageRepository;
	
	@Autowired
	public ImageService(ResourceLoader resourceLoader, ImageRepository imageRepository) {
		super();
		this.resourceLoader = resourceLoader;
		this.imageRepository = imageRepository;
	}


	
	  @Bean CommandLineRunner setup() {
	  
	  return (args) -> { Files.createDirectories(Paths.get(UPLOAD_ROOT) );
	  
	  FileCopyUtils.copy("Test file", new FileWriter(UPLOAD_ROOT +
	  "/learning-spring-boot-cover.jpg"));
	  
	  FileCopyUtils.copy("Test file2", new FileWriter(UPLOAD_ROOT +
	  "/learning-spring-boot-2nd-edition-cover.jpg"));
	  
	  FileCopyUtils.copy("Test file3", new FileWriter(UPLOAD_ROOT +
	  "/bazinga.png")); }; }
	 
	
	public Flux<Image> getImages(){
		
	try { DirectoryStream<Path> ds =
		  Files.newDirectoryStream(Paths.get(UPLOAD_ROOT));
	
	Iterator<Path> iterator =  ds.iterator(); 
	
	List<Image> list = new ArrayList<>(); 
	while (iterator.hasNext()) { 
		
		Path path = iterator.next(); 
		
		list.add(new  Image(String.valueOf(path.hashCode()), 
		
				path.getFileName().toString())); }
	
		  return Flux.fromIterable(list); 
		  } catch (IOException e) { // TODO
		   e.printStackTrace();
		  
		  return Flux.empty(); }
		 
		
			}
	
	
	public Mono<Resource> findOneImage(String filename){
		
		return Mono.fromSupplier(
			() -> resourceLoader.getResource("file:"+UPLOAD_ROOT+"/"+filename));
	}

	public Mono<Void> createImage(Flux<FilePart> files){
		
		
		  return files.flatMap(file -> file.transferTo(
		  Paths.get(UPLOAD_ROOT,file.filename()).toFile())).then();
		 
		
		
	
	}
	
	
	public Mono<Void> deleteImage(String filename){
		
		
		  return Mono.fromRunnable( ()-> { try {
		  Files.deleteIfExists(Paths.get(UPLOAD_ROOT, filename));
		  
		  } catch (IOException e) { throw new RuntimeException(e);
		  
		  } } );
		  
		 
		
	
	}}
