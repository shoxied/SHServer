FROM openjdk:18.0.2

ARG VERSION=$VERSION
ENV jarFile=SHServer-$VERSION.jar

RUN mkdir -p /opt/sh-server
COPY target/${jarFile} /opt/sh-server
EXPOSE 8080
CMD  cd /opt/sh-server; java -XshowSettings:vm $JAVA_OPTS -Dspring.profiles.active=$PROFILE -jar ${jarFile} $ARGS