package rentalsystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import jakarta.faces.webapp.FacesServlet;

@SpringBootApplication
@ComponentScan(basePackages = "rentalsystem")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	@Bean
	public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<>(servlet,
				"*.xhtml");
		servletRegistrationBean.setName("Faces Servlet");
		servletRegistrationBean.setAsyncSupported(true);
		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}

}
