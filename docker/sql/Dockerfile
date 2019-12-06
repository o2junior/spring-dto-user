FROM postgres:latest

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=123456
ENV POSTGRES_DB=db-spring-dto

ADD \1-schema.sql \docker-entrypoint-initdb.d
ADD \2-data.sql \docker-entrypoint-initdb.d
