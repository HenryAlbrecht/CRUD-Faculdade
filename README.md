# Tarefas API

API RESTful para gerenciamento de tarefas.

Principais features
- CRUD completo para entidade Tarefa (id, nome, dataEntrega, responsavel)
- Spring Boot + Spring Data JPA
- MySQL (configuração em `src/main/resources/application.yml`)

Tecnologias usadas
------------------
- Java 21: versão LTS.
- Spring Boot 3: framework para aplicações Java.
- MySQL (Connector/J): banco relacional usado em produção/avaliação (configurado em `application.yml`).
- Lombok: reduz boilerplate com anotações (`@Getter`, `@Setter`, `@RequiredArgsConstructor`, `@Data`).
- Maven: sistema de build e gerenciamento de dependências.
- Postman: para testar e documentar as chamadas da API (coleção em `postman/`).


Como rodar
1. Configure um banco MySQL local e atualize as credenciais em `application.yml`, deixei a configuração para auto-criar o db tarefas_db no localhost:3306.
2. Build e execute com Maven:

```bash
mvn clean package
mvn spring-boot:run
```

Maven Wrapper (opcional)
Para rodar o projeto sem instalar o Maven globalmente, gere o Maven Wrapper localmente com:

```bash
mvn -N io.takari:maven:wrapper
```

Isso criará `mvnw` e `mvnw.cmd` — depois use `./mvnw` (Linux/macOS) ou `mvnw.cmd` (Windows) para rodar comandos Maven.

Endpoints (base: http://localhost:8080/api/tarefas)
- POST /api/tarefas — cria tarefa
- GET /api/tarefas — lista todas
- GET /api/tarefas/{id} — busca por id
- PUT /api/tarefas/{id} — atualiza
- DELETE /api/tarefas/{id} — remove

Exemplo de JSON para criação/atualização
```json
{
  "nome": "Estudar para prova",
  "dataEntrega": "2025-09-20",
  "responsavel": "Henrique Ferreira Albrecht - RU 4653204"
}
```

Testes e documentação
- Use Postman ou similar para testar os endpoints (Pasta com a Collection com endpoints localizada na pasta postsman).
- A dependência `springdoc-openapi` adiciona automaticamente uma UI Swagger em /swagger-ui.html.