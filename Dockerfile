FROM openjdk:11
RUN echo pwd
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . /usr/src/app
ENTRYPOINT ["sh","runservice.sh"]

