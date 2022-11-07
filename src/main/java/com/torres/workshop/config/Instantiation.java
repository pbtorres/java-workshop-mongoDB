package com.torres.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.torres.workshop.domain.Post;
import com.torres.workshop.domain.User;
import com.torres.workshop.dto.AuthorDTO;
import com.torres.workshop.repository.PostRepository;
import com.torres.workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository; 
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		postRepository.deleteAll();
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria", "maria@gmail.com");
		User paulo = new User(null, "Paulo", "paulo@gmail.com");
		User joao = new User(null, "João", "joao@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, paulo, joao));
		
		Post post1 = new Post(null, sdf.parse("07/11/2022"), "Partiu viagem", "Vou viajar para o Piauí.", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("07/12/2022"), "Retorno da viagem", "Vou voltar para bsb.", new AuthorDTO(joao));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		
		userRepository.save(maria);
		
	}

}
