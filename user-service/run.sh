./gradlew bootRun &
while true; do
  inotifywait -e modify,create,delete,move -r ./src/ && ./gradlew build
done