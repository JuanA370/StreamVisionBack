package com.example.demo;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.service.AnswersServices;
import com.example.demo.model.service.PurchasingService;
import com.example.demo.model.service.FavoritesService;
import com.example.demo.model.service.ProductsService;
import com.example.demo.model.service.ThreadsServices;
import com.example.demo.model.service.UsersService;
 
@SpringBootApplication
public class StreamVisionApplication {
 
	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StreamVisionApplication.class, args);
        PurchasingService gc = context.getBean(PurchasingService.class);
        FavoritesService gf = context.getBean(FavoritesService.class);
        ThreadsServices gh = context.getBean(ThreadsServices.class);
        ProductsService gp = context.getBean(ProductsService.class);
        AnswersServices gr = context.getBean(AnswersServices.class);
        UsersService gu = context.getBean(UsersService.class);
        ((ConfigurableApplicationContext)context).close();
	}
}