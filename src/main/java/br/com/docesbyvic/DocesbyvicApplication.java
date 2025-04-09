package br.com.docesbyvic;

import br.com.docesbyvic.main.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DocesbyvicApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DocesbyvicApplication.class, args);

		Main main = context.getBean(Main.class); // Pegando a Main pelo Spring
		main.display();
	}
}
