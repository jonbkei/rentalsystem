package rentalsystem.configs;

import org.springframework.boot.web.servlet.ServletContextInitializer;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class CustomServletContextInitializer implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		sc.setInitParameter("com.sun.faces.forceLoadConfiguration", "true");
		sc.setInitParameter("jakarta.faces.DEFAULT_SUFFIX", ".xhtml");
		sc.setInitParameter("jakarta.faces.PROJECT_STAGE", "Development");
		sc.setInitParameter("jakarta.faces.STATE_SAVING_METHOD", "server");
		sc.setInitParameter("jakarta.faces.FACELETS_SKIP_COMMENTS", "true");

		// theme
		sc.setInitParameter("primefaces.THEME", "nova-light");
	}

}
