# getting-started project

This project intent to integrate the framework Optimizely with Quarkus

If you want to learn more about Quarkus, please visit its [website](https://quarkus.io/).

If you want to learn more about Optimizely, please visit its [website](https://www.optimizely.com/).

## First things first
You need to have an account on Optimizely with some basic variables created for your
feature flag to work. You can check the guide on their [website](https://docs.developers.optimizely.com/full-stack/docs/java).
After that you can go on this project `application.properties` and set the key you were provided.

Now you are almost finished

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Running and testing the application

You can now go to your favorite browser (not IE) and get on `localhost:8080`
and check on your feature flags.

Have fun!
