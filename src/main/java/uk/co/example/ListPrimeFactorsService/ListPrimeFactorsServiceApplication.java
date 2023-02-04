package uk.co.example.ListPrimeFactorsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListPrimeFactorsServiceApplication {

	public static void main(String[] args) {
		ListPrimeFactors lpf = new ListPrimeFactors();
		SpringApplication.run(ListPrimeFactorsServiceApplication.class, args);
	}

}
