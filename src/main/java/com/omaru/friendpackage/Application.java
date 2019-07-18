package com.omaru.friendpackage;

import com.omaru.friendpackage.service.CommandLineResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.inject.Inject;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private CommandLineResponse commandLineResponse;
	@Inject
	public Application(CommandLineResponse commandLineResponse){
		this.commandLineResponse = commandLineResponse;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		commandLineResponse.print(args);
	}
}
