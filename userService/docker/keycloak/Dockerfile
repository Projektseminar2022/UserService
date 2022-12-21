######### CREATE OPTIMIZED BUILD ##########
FROM quay.io/keycloak/keycloak:20.0.2 as builder
WORKDIR /opt/keycloak

####
ENV KC_HOSTNAME_STRICT=false
ENV KC_TRANSACTION_XA_ENABLED=false
ENV KC_DB=postgres

WORKDIR /opt/keycloak
RUN /opt/keycloak/bin/kc.sh build

######### CREATE keycloak IMAGE #############
FROM quay.io/keycloak/keycloak:20.0.2

COPY --from=builder /opt/keycloak/ /opt/keycloak/
# import optimized build
WORKDIR /opt/keycloak
# Needs to be false because TLS temination on WAF
ENV KC_HOSTNAME_STRICT=false

# DB
ENV KC_DB=postgres
ENV KC_DB_URL_DATABASE=userServiceDB
ENV KC_DB_URL_HOST=lars-postgres
ENV KC_DB_USERNAME=postgres
ENV KC_DB_PASSWORD=postgres
ENV KC_DB_URL_PORT=5432

# Needs to be false because TLS temination on WAF
ENV KC_HTTP_ENABLED=true
ENV KC_HOSTNAME_STRICT_HTTPS=false

ENTRYPOINT [ "/opt/keycloak/bin/kc.sh", "start", "--optimized" ]
EXPOSE 8080

