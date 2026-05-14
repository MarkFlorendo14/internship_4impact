# ── Stage 1: Build ─────────────────────────────────────────────
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
# Copy dependency manifests first (enables layer caching — see Section 5.5)
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
# Now copy the source code and build
COPY src ./src
RUN ./mvnw clean package -DskipTests
# ── Stage 2: Runtime ────────────────────────────────────────────
FROM eclipse-temurin:21-jre
WORKDIR /app
# Create a non-root user for security
RUN addgroup --system spring && adduser --system --ingroup spring spring
USER spring
# Copy only the compiled JAR from the build stage
COPY --chown=spring:spring --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]