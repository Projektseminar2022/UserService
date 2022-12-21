docker stop seminar_keycloak
docker rm seminar_keycloak
docker rmi seminar_keycloak
docker build -t seminar_keycloak
docker run --name=seminar_keycloak --network seminar_keycloak -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin -p 8080:8080 seminar_keycloak:latest