FROM java:8

COPY *.jar /app.jar
MAINTAINER hhhw/defect-assitant

CMD ["--server.port=10086"]

EXPOSE 10086

ENTRYPOINT ["java","-jar","/app.jar"]