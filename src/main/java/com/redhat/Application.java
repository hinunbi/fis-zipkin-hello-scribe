
package com.redhat;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.zipkin.starter.CamelZipkin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@CamelZipkin
public class Application extends RouteBuilder {


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void configure() throws Exception {


    from("timer://foo?period=5000")
        .setBody().simple("Hello World at ${date:now:yyyy-MM-dd HH:mm:ss,SSS}")
        .log("first >>> ${body}")
        .to("direct:second");

    from("direct:second")
        .log("second >>> ${body}");
  }
}
