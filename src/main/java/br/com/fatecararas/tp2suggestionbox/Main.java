package br.com.fatecararas.tp2suggestionbox;

import br.com.fatecararas.tp2suggestionbox.dto.CategoriaDTO;
import br.com.fatecararas.tp2suggestionbox.dto.SugestaoDTO;
import br.com.fatecararas.tp2suggestionbox.services.CategoriaService;
import br.com.fatecararas.tp2suggestionbox.services.SugestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private SugestaoService sugestaoService;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		var c1 = new CategoriaDTO();
//		c1.setId(1);
//		c1.setDescricao("Sugestão");
//
//		categoriaService.salvar(c1);
//
//		var s1 = new SugestaoDTO();
//		s1.setDescricao("Cantina com produtos diversificados.");
//		s1.setCategoria(c1);
//
//		sugestaoService.salvar(s1);
	}
}
