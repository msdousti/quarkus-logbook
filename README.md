# Quarkus :heart: Logbook

This is a sample project to use Quarkus/Resteasy/Logbook together.

It was created as a response to [Logbook issue 1384](https://github.com/zalando/logbook/issues/1384), which states:

> Quarkus Resteasy endpoint returning 500 to client after HEAD request because of Logbook NullPointerException

I originally, created the project with only the request logging in mind. It worked fine, no 500 errors!

After [Issue #1](https://github.com/msdousti/quarkus-logbook/issues/1) asked for logging the response as well,
I tried to do that and observed the dreaded `NullPointerException`. This happens for HEAD or any other response without
a response entity. I fixed the issue, and 
[opened a PR with the Logbook project](https://github.com/zalando/logbook/pull/1909). 
This happens with Logbook 3.9, so hopefully the fix will be merged in 3.10+.

## How to test
Below is the result of the test based on my fix. Note that I'm using Logbook `3.10.0-SNAPSHOT`, 
which is my local fixed version.

1. **Terminal 1:** Run the project
```
./mvnw compile quarkus:dev
```

2. **Terminal 2:** Send a HEAD request, and note `200 OK`.

```bash
curl -iI http://localhost:8080/hello
```

```
HTTP/1.1 200 OK
connection: keep-alive
```

3. **Terminal 1:** Notice that Logbook has added the following logs:

```
2024-09-22 01:34:37,971 TRACE [org.zal.log.Logbook] (executor-thread-1) Incoming Request: de113af37c53368a
Remote: localhost:8080
HEAD http://localhost:8080/hello HTTP/1.1
Accept: */*
Host: localhost:8080
User-Agent: curl/8.5.0

2024-09-22 01:34:37,979 TRACE [org.zal.log.Logbook] (executor-thread-1) Outgoing Response: de113af37c53368a
Duration: 11 ms
HTTP/1.1 200 OK
```

## Default Quarkus readme

<details>
<summary>Expand to see the default Quarkus readme</summary>

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-logbook-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and
  more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
</details>
