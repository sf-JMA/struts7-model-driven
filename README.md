# Start
runs on port 8080
`./gradlew bootRun`

# Action with Transaction
This does not work as intended, because `execute` is annotated with `@Transactional`: http://localhost:8080/hello.action

# Action without Transaction
This works as intended (request parameters get mapped to model): http://localhost:8080/hello2.action
