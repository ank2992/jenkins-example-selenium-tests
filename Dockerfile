FROM openjdk:11
RUN echo pwd
ENV APP_HOME /usr/src/app
RUN mkdir -p ${APP_HOME}
WORKDIR ${APP_HOME}
COPY . ${APP_HOME}
ENTRYPOINT ["/bin/bash","./runservice.sh"]

