package com.aeo.microservice.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class MicroserviceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MicroserviceApplication.class, args);

		ProductDetail detail = new ProductDetail();
		detail.setProductId("ABCD1234");
		detail.setProductName("O livro de Dan sobre a escrita");
		detail.setShortDescription("Um livro sobre como escrever livros.");
		detail.setLongDescription("Neste livro Dan apresenta ao leitor técnicas sobre como escrever livros.");
		detail.setInventoryId("009178461");
		
		ProductDetail detail2 = new ProductDetail();
		detail2.setProductId("WER312312");
		detail2.setProductName("O livro de João");
		detail2.setShortDescription("Um livro sobre como ler livros.");
		detail2.setLongDescription("Neste livro João apresenta ao leitor técnicas sobre como ler livros.");
		detail2.setInventoryId("234234234");
		
		ProductDetailRepository repository = ctx.getBean(ProductDetailRepository.class);
		repository.save(detail);
		repository.save(detail2);

		for (ProductDetail productDetail : repository.findAll()) {
			System.out.println(productDetail.getProductId());
		}
	}
}
