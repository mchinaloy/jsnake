

# JSNAKE

A battlesnakeio implementation using Spring Webflux: 

https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#webflux

## Running the server locally

First build the battlesnake-engine docker image:

```
cd ./battlesnake-engine
docker build .
```

Start the server up:

```
cd ./battlesnake-engine
docker-compose up
```

Now run the project in your IDE and create games via your browser:

```
http://localhost:3010/

Snake URL - 192.168.1.100
```