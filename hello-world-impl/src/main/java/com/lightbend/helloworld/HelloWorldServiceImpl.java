package com.lightbend.helloworld;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static java.util.concurrent.CompletableFuture.completedFuture;

public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public ServiceCall<NotUsed, String> helloWorld() {
        /*If you already know the result of a computation, you can use the static completedFuture method
        with an argument that represents a result of this computation. Then the get method of the Future
        will never block, immediately returning this result instead.*/
        return notUsed -> completedFuture("Hello World");
    }
}
