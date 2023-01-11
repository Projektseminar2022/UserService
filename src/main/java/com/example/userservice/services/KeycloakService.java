package com.example.userservice.services;

import com.example.userservice.model.User;
import com.example.userservice.model.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.RoleScopeResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class KeycloakService {

    @Value("${keycloak.auth-server-url}")
    private String keycloakServerUrl;


    private String keycloakRealm ="master";

    private String userRealm ="ProjektSeminar";

    @Value("${clientId}")
    private String clientId;

    @Value("${admin-client.secret}")
    private String clientSecret;

    public Keycloak getKeycloakAdminClient() {
        return KeycloakBuilder.builder()
            .serverUrl(keycloakServerUrl)
            .realm(keycloakRealm)
            .clientId(clientId)
            .clientSecret(clientSecret)
            .grantType("client_credentials")
            .build();
    }


    public UserRepresentation registerUserInKeycloak(UserDto userToRegister)  {

        CredentialRepresentation credentials = new CredentialRepresentation();
        credentials.setType(CredentialRepresentation.PASSWORD);
        credentials.setValue(userToRegister.getPassword());

        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEmail(userToRegister.getEmail());
        userRepresentation.setFirstName(userToRegister.getFirstName());
        userRepresentation.setLastName(userToRegister.getLastName());
        userRepresentation.setUsername(userToRegister.getEmail());
        userRepresentation.setRealmRoles(List.of("user"));
        userRepresentation.setEnabled(true);

        userRepresentation.setCredentials(List.of(credentials));

        UsersResource userResource = this.getKeycloakAdminClient().realm(userRealm).users();
        Response response = userResource.create(userRepresentation);

       Optional<HttpStatus>  httpStatus = Optional.ofNullable(HttpStatus.resolve(response.getStatus()));
        if(httpStatus.isPresent()){
            log.info(httpStatus.toString());
        }

        response.close();
        List<UserRepresentation> responseFromKeycloak = userResource.search(userRepresentation.getUsername());


        return responseFromKeycloak.get(0);

    }

    public String getId() {
        SecurityContext holder = SecurityContextHolder.getContext();
        Authentication authentication = holder.getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof KeycloakPrincipal) {
            KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) principal;
            return keycloakPrincipal.getName();
        }
        return null;
    }

}
