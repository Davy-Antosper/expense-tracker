# Expense Tracker API

> API REST sécurisée pour gestion des dépenses personnelles — construite avec **Spring Boot 3.5.9**, **JWT** et **MySQL**.

---

## Fonctionnalités

- Inscription et connexion sécurisées avec **BCrypt**
- Authentification stateless via **JSON Web Token (JWT)**
- Validation des données d'entrée (`@Valid`, `@Email`, `@NotBlank`...)
- Séparation entités / DTOs (le mot de passe n'est **jamais** exposé dans les réponses)
- Documentation avec **Swagger UI** 
- Gestion globale des erreurs avec réponses JSON(ResponseEntity)

---

## Stack 
 Langage : Java 21 
 Framework : Spring Boot 3.5.9 
 Sécurité : Spring Security + JWT (jjwt 0.12.6) 
 Persistance :Spring Data JPA + Hibernate 
 Base de données : MySQL 
 Validation : spring-boot-starter-validation
 Documentation : SpringDoc OpenAPI 3 (Swagger UI) |

---



## 🚀 Installation

### Prérequis

- Java 21+
- Maven 3.8+
- MySQL 8+

### 1. Cloner le dépôt

```bash
git clone https://github.com/Davy-Antosper/expense-tracker.git
cd expense-tracker
```

### 2. Créer la base de données MySQL

```sql
CREATE DATABASE expense_tracker;
```

### 3. Configurer l'application

Édite `src/main/resources/application.properties` :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=TON_USER
spring.datasource.password=TON_MOT_DE_PASSE

jwt.secret=une-cle-secrete-dau-moins-32-caracteres
jwt.expiration=86400000
```

### 4. Lancer l'application

```bash
./mvnw spring-boot:run
```

L'API démarre sur `http://localhost:8080`.

---

 Durée de validité du token (ms) | `86400000` (24h) |

---

## Endpoints API

### Public (sans token)

POST : /api/v1/user/register   (Créer un compte)
POST :/api/v1/user/login       ( Se connecter )

### private (token JWT requis)

GET  :/api/v1/user?userId={id} (Récupérer un utilisateur par ID)




## 📖 Documentation Swagger: http://localhost:8080/swagger-ui.html

##  MESSAGE : "D'autres fonctionnalites bientot"

## Licence

Ishimwe Antosper Davy.
