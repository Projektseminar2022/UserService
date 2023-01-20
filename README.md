# UserService
User Service, Authentication/Autorisation Service

# Paper
[Paper](Paper/Projektseminar_Microservices_mit_Springboot_Paper(final).docx)

# Keycloak
<ol>
<li> create realm with name ProjektSeminar </li>
<li> lege client : springboot-keycloak an </li>
<li> lege dort role user und admin an </li>
<li> realm settings. -> user registration -> assign role ->user </li>
</ol>

# User anlegen: Post-Request:
Bsp. Datensatz Postman:
{      
"lastName": "Sweeney",
"firstName": "Sean",
"email":"praesent.luctus@protonmail.net",
"password":"Deutschland",
"city":"Bonn",
"country":"germany"
}

### login with credentials in keycloak -> get Token
## postman
Access-Token-Url; http://localhost:8080/realms/ProjektSeminar/protocol/openid-connect/token
Client-ID: springboot-keycloak
scope: openid

# get Current User : Get-Request (with Token):

# Location hinzufügen: Post-Request (with Token):
Bsp. Datensatz Postman:
{"location":"Bonn",
"latitude":50.733334,
"longitude":7.100000
}