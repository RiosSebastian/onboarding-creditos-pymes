# 🏦 API de Préstamos – Backend

Backend desarrollado en **Spring Boot** para la gestión de un sistema de préstamos, con autenticación y autorización mediante **JWT**, manejo de usuarios, empresas, solicitudes de crédito, documentos y verificación KYC.

-------------------------------------------------------

🚀 Tecnologías utilizadas

- ☕ Java 17+
- 🌱 Spring Boot 3
- 🔐 Spring Security 6 + JWT
- 🗄️ Spring Data JPA (Hibernate)
- 🐘 Base de datos relacional (MySQL / PostgreSQL)
- 📄 Swagger / OpenAPI 3
- 🔑 BCrypt Password Encoder
- 📦 Maven

---------------------------------------------------

## 📂 Arquitectura del proyecto
src/main/java
├── controller
├── service
│ └── impl
├── repository
├── mapper
├── dto
│ ├── req
│ └── res
├── entity
├── security
│ ├── JwtAuthenticationFilter
│ ├── JwtService
│ ├── SecurityConfig
│ └── UserDetailsServiceImpl
└── exception

------------------------------------------------

🔐 Seguridad y Autenticación

El sistema utiliza **JWT Stateless Authentication**.

 🔑 Flujo de autenticación

1. El usuario se loguea con email y contraseña
2. El backend devuelve:
   - `accessToken` (15 minutos)
   - `refreshToken` (7 días)
3. El `accessToken` se envía en cada request: Authorization: Bearer <token>
4. Cuando el access token expira, se usa el refresh token para obtener uno nuevo

---------------------------------------------------------

👥 Roles y permisos

Roles disponibles:

- `SOLICITANTE`
- `OPERADOR`
- `ADMIN`

Cada rol tiene **authorities** asociadas:

| Rol         | Permisos                         |
|------------|----------------------------------|
| SOLICITANTE | READ                             |
| OPERADOR    | READ, UPDATE                     |
| ADMIN       | READ, CREATE, UPDATE, DELETE     |

Ejemplo de protección en controllers:

```java
@PreAuthorize("hasAuthority('READ')")

