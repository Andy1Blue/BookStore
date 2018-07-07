package pl.krzysztofbujak.bookstorenew;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.swing.*;

@SpringBootApplication
public class BookstorenewApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BookstorenewApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return configureApplication(applicationBuilder);
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder){
        return builder.sources(BookstorenewApplication.class).bannerMode(Banner.Mode.OFF);
    }

}
