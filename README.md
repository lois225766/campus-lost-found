# CampusFind — Campus Lost & Found

A complete Java 17+ Spring Boot + Thymeleaf + H2 Maven project for a second-year Java OOP demonstration.

## Stack
- Java 17+
- Spring Boot 3.5.x
- Spring MVC + Thymeleaf
- Spring Data JPA / Hibernate
- File-based H2 database
- Maven
- HTML / CSS / small JavaScript enhancement

## Demo accounts
> These are demonstration credentials only.

- `student1 / student1` — Ananya Nair — S4 CSE
- `student2 / student2` — Rahul Menon — S4 CSE
- `student3 / student3` — Meera Joseph — S6 CSE
- `student4 / student4` — Arjun Kumar — S2 CSE
- `admin / admin` — Campus Admin

## Run in GitHub Codespaces
1. Create a GitHub repository and upload/extract this project so `pom.xml` is at the repository root.
2. Open the repository in GitHub.
3. Choose **Code → Codespaces → Create codespace on main**.
4. Wait for the browser-based VS Code environment to finish loading.
5. Open the terminal and run:
   ```bash
   mvn spring-boot:run
   ```
6. When Spring Boot starts, open port **8080** from the **Ports** panel. Codespaces will provide the browser URL.
7. Sign in with one of the demo accounts above.

If Maven is not available in the Codespace image, install/use a Java + Maven Codespace image, or run `./mvnw spring-boot:run` after generating Maven Wrapper files from a Maven-enabled environment.

## Local run
With Java 17+ and Maven installed:
```bash
mvn spring-boot:run
```
Then open `http://localhost:8080`.

## Persistence
H2 uses a file database at `./data/campusdb`, so data is not just stored in an in-memory Java list. The database is created automatically. Demo seed data is inserted only when the user table is empty.

## Main workflows
- Student login and role-aware dashboard
- Lost/found report creation with optional image upload
- Search and filters
- Public/private report information separation
- Java rule-based possible-match detection
- Handover requests and two-party confirmation
- Student deletion requests
- Admin deletion approval/rejection
- Admin final closure of confirmed handovers
- Audit log for important actions
- Admin-only access to the admin dashboard

## OOP concepts in the actual application
### Encapsulation
`User`, `Item`, `Handover`, `DeletionRequest`, and `AuditLog` keep their fields private and expose controlled methods. Status changes happen through application services/workflow methods rather than direct field access from controllers.

### Inheritance
`Item` is an abstract JPA entity. `LostItem` and `FoundItem` extend it using JPA single-table inheritance.

### Polymorphism
The application stores and processes `LostItem` and `FoundItem` through `Item` references. `getReportType()` and `getActionLabel()` are overridden differently by the two subclasses.

### Abstraction
`Item` defines common item structure plus abstract behaviour. The controller and service layer can work with the parent type without depending on the concrete report class.

## Testing note
The project files were inspected for structure and obvious configuration/code issues. A full Maven build/test could **not** be executed in the creation environment because Maven is not installed and outbound network/DNS access was unavailable, so dependency resolution could not be performed here. Therefore this delivery does not claim a verified runtime build from this environment.
