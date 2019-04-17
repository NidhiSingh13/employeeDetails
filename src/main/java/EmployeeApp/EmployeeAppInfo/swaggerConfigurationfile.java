package EmployeeApp.EmployeeAppInfo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;

import static springfox.documentation.builders.PathSelectors.regex;

import java.time.LocalDate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configurable
@EnableSwagger2
@ComponentScan(" EmployeeApp.EmployeeAppInfo.EmployeeController")
public class swaggerConfigurationfile {
	
	@Bean
	public Docket apiDocket() {
		
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("EmployeeApp.EmployeeAppInfo"))
					.paths(PathSelectors.ant("/employeeApi/*"))
					.build();
		return docket;
		
	
	}

}
