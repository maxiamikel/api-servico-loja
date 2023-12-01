package com.maxi.gestaoServico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class GestaoServicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoServicoApplication.class, args);
	}
	/*
	 * git commit -m "first commit"
	 * git branch -M main
	 * git remote add origin https://github.com/maxiamikel/controle-servico-loja.git
	 * git push -u origin main
	 */
}
