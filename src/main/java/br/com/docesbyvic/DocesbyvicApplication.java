package br.com.docesbyvic;

import br.com.docesbyvic.main.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DocesbyvicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocesbyvicApplication.class, args);

		Main display = new Main();
		display.display();

}
}
