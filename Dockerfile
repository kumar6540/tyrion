FROM openjdk:11
EXPOSE 9090
ADD target/fluxmonoEndpoints.jar  fluxmonoEndpoints.jar
ENTRYPOINT [ "java","-jar" "/fluxmonoEndpoints.jar" ]