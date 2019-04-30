package ictcg.com;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.qos.logback.core.net.SyslogOutputStream;
import ictcg.com.model.Societes;
import ictcg.com.repository.SocieteRepository;
import ictcg.com.repository.TransactionRepository;

@SpringBootApplication
public class TrialspringwebfluxmarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrialspringwebfluxmarsApplication.class, args);
	}

	@Bean
	public  CommandLineRunner start(SocieteRepository socrepo, TransactionRepository transac)
	{
		return Args -> {
						Stream.of("orange", " fraise", "kiwi ")
						.forEach(
//									s -> {
//										socrepo.save(new Societes(s , 100 + Math.random() * 900 ))
//												.subscribe(  soc -> {
//															System.out.println(soc.toString());
//													}
//											);			
//										}
								);

					};
	}
}
