FROM openjdk:latest

WORKDIR /app

COPY . /app

RUN javac saleManagerMain.java

CMD ["java", "saleManagerMain"]