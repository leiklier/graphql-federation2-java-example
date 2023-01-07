FROM eclipse-temurin:17
RUN apt-get update && apt-get install -y inotify-tools
WORKDIR /app

ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"

CMD ["sh", "run.sh"]