package de.marhan.patch.controller

import de.marhan.patch.RestPatchSampleApplication
import io.restassured.RestAssured
import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

class SpringBootSpecification extends Specification {

    @Shared
    @AutoCleanup
    ConfigurableApplicationContext context

    void setupSpec() {
        Future future = Executors
                .newSingleThreadExecutor().submit(
                new Callable() {
                    @Override
                    ConfigurableApplicationContext call() throws Exception {
                        return (ConfigurableApplicationContext) SpringApplication
                                .run(RestPatchSampleApplication.class)
                    }
                })
        context = future.get(60, TimeUnit.SECONDS)

        RestAssured.baseURI = "http://localhost:12345"

    }

}