Système de Gestion de Réservations - Backend

## Description
API REST développée avec Spring Boot pour la gestion de boîtes de stockage, de réservations et d'utilisateurs. Ce backend fournit tous les services nécessaires pour l'application frontend Angular.

## Fonctionnalités
- 🔐 Authentification et autorisation
- 📦 CRUD pour la gestion des boîtes
- 📅 CRUD pour la gestion des réservations
- 👥 CRUD pour la gestion des utilisateurs
- 🗄️ Intégration avec base de données MariaDB
- 🌐 API RESTful

## Prérequis
- Java 17 ou supérieur
- Maven 3.6 ou supérieur
- MariaDB 10.6 ou supérieur
- IDE Java (IntelliJ IDEA, Eclipse, VS Code avec extensions Java)

## Installation

### 1. Cloner le dépôt
```bash
git clone https://github.com/medelmir/CapeGeminiBack.git
cd CapeGeminiBack
```

### 2. Configuration de la base de données

#### Créer la base de données
Connectez-vous à MariaDB et créez la base de données :
```sql
CREATE DATABASE boite;
```

#### Configurer application.yml
Créez le fichier `application.yml` 

```yaml
spring:
  application:
    name: opendata-crud
  datasource:
    url: jdbc:mariadb://localhost:3306/boite
    username: root
    password: "0000"
    driver-class-name: org.mariadb.jdbc.Driver
  jpa:
    properties:
      hibernate.dialect: org.hibernate.dialect.MariaDBDialect
    hibernate:
      ddl-auto: update
    show-sql: true
```

**⚠️ Important** : Modifiez les valeurs `username` et `password` selon votre configuration MariaDB.

L'API sera accessible sur `http://localhost:8080/`



**⚠️ Configuration importante pour l'exécution du JAR** :

Lors de l'exécution du fichier JAR compilé, vous devez créer le fichier `application.yml` dans le répertoire `target/classes/` avec le même contenu de configuration :

```bash
# Créer le répertoire si nécessaire
mkdir -p target/classes

# Copier ou créer application.yml dans target/classes/
```

Contenu du fichier `target/classes/application.yml` :
```yaml
spring:
  application:
    name: opendata-crud
  datasource:
    url: jdbc:mariadb://localhost:3306/boite
    username: root
    password: "0000"
    driver-class-name: org.mariadb.jdbc.Driver
  jpa:
    properties:
      hibernate.dialect: org.hibernate.dialect.MariaDBDialect
```

## Structure du Projet

```
CapeGeminiBack/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/capgemini/
│   │   │       ├── controller/     # Contrôleurs REST
│   │   │       ├── model/          # Entités JPA
│   │   │       ├── repository/     # Repositories Spring Data
│   │   │       └── service/        # Logique métier
│   │   └── resources/
│   │       └── application.yml     # Configuration
│   └── test/                       # Tests unitaires
├── target/                         # Fichiers compilés
└── pom.xml                        # Dépendances Maven
```

## Endpoints API Principaux

### Authentification
- `POST /api/auth/login` - Connexion utilisateur
- `POST /api/auth/register` - Inscription utilisateur

### Boîtes
- `GET /api/boites` - Récupérer toutes les boîtes
- `GET /api/boites/{id}` - Récupérer une boîte par ID
- `POST /api/boites` - Créer une nouvelle boîte
- `PUT /api/boites/{id}` - Mettre à jour une boîte
- `DELETE /api/boites/{id}` - Supprimer une boîte

### Réservations
- `GET /api/reservations` - Récupérer toutes les réservations
- `GET /api/reservations/{id}` - Récupérer une réservation par ID
- `POST /api/reservations` - Créer une nouvelle réservation
- `PUT /api/reservations/{id}` - Mettre à jour une réservation
- `DELETE /api/reservations/{id}` - Supprimer une réservation

### Utilisateurs
- `GET /api/utilisateurs` - Récupérer tous les utilisateurs
- `GET /api/utilisateurs/{id}` - Récupérer un utilisateur par ID
- `POST /api/utilisateurs` - Créer un nouvel utilisateur
- `PUT /api/utilisateurs/{id}` - Mettre à jour un utilisateur
- `DELETE /api/utilisateurs/{id}` - Supprimer un utilisateur

## Technologies Utilisées
- **Spring Boot 3.x** - Framework principal
- **Spring Data JPA** - Gestion de la persistance
- **Spring Web** - API REST
- **MariaDB** - Base de données
- **Maven** - Gestion des dépendances
- **Hibernate** - ORM
- **Lombok** - Réduction du code boilerplate





## Contribuer
1. Forkez le projet
2. Créez une branche pour votre fonctionnalité (`git checkout -b feature/nouvelle-fonctionnalite`)
3. Committez vos changements (`git commit -m 'Ajouter une nouvelle fonctionnalité'`)
4. Poussez vers la branche (`git push origin feature/nouvelle-fonctionnalite`)
5. Ouvrez une Pull Request


## Lien avec le Frontend
Ce backend est conçu pour fonctionner avec l'application frontend Angular disponible ici : https://github.com/medelmir/CapeGeminiFront
