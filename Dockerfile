FROM openjdk:11
VOLUME /tmp
EXPOSE 443
ADD ./target/nt-sc-gateway-0.0.1-SNAPSHOT.jar ms-nt-sc-gateway.jar
ENTRYPOINT ["java", "-jar", "ms-nt-sc-gateway.jar"]