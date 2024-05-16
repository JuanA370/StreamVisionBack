package com.example.demo;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
 
import com.example.demo.model.business.GestorCompra;
import com.example.demo.model.business.GestorFavorito;
import com.example.demo.model.business.GestorHilo;
import com.example.demo.model.business.GestorProducto;
import com.example.demo.model.business.GestorRespuesta;
import com.example.demo.model.business.GestorUsuario;
 
@SpringBootApplication
public class StreamVisionApplication {
 
	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StreamVisionApplication.class, args);
        GestorCompra gc = context.getBean(GestorCompra.class);
        GestorFavorito gf = context.getBean(GestorFavorito.class);
        GestorHilo gh = context.getBean(GestorHilo.class);
        GestorProducto gp = context.getBean(GestorProducto.class);
        GestorRespuesta gr = context.getBean(GestorRespuesta.class);
        GestorUsuario gu = context.getBean(GestorUsuario.class);
        ((ConfigurableApplicationContext)context).close();
	}
}