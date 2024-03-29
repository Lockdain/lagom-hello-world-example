package com.lightbend.helloworld;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.*;

public class HelloWorldServiceImplTest {

    @Test
    public void helloWorldShouldReturnTheExpectedResult() throws Exception {
        withServer(defaultSetup(), server -> {
            HelloWorldService helloWorldService = server.client(HelloWorldService.class);

            // never use blocking get in production
            String result = helloWorldService
                    .helloWorld()
                    .invoke()
                    .toCompletableFuture()
                    .get(5, TimeUnit.SECONDS);

            assertEquals("Hello World", result);
        });

    }


}