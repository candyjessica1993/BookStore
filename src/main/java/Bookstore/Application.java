package Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Bookstore.domain.Category;
import Bookstore.domain.CategoryRepository; 
import Bookstore.domain.Book;
import Bookstore.domain.BookRepository;

@SpringBootApplication
public class Application {

	@Autowired 
	private BookRepository repository; 
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Novel"));
			crepository.save(new Category("Business"));
			crepository.save(new Category("Course Book"));
			
			repository.save(new Book("Ernest Hemingway", "A Farewell to Arms", "1231212-21", 1929, 25, crepository.findByName("Novel").get(0)));
			repository.save(new Book("George Orwell", "Animal Farm", "2212343-5", 1945, 24, crepository.findByName("Novel").get(0)));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
		}; 
	}
	
	
}
