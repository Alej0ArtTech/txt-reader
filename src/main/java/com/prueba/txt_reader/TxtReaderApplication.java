package com.prueba.txt_reader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.prueba.txt_reader.service.FileService;

@SpringBootApplication
@ComponentScan(basePackages = { "com.prueba.txt_reader.service" })

public class TxtReaderApplication implements CommandLineRunner {
	private final FileService fileService;

	@Autowired
	public TxtReaderApplication(FileService fileService) {
		this.fileService = fileService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TxtReaderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileService.generateFile();
	}
}