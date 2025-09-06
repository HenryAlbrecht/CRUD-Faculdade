# Tarefas API

API RESTful para gerenciamento de tarefas — implementação de exemplo para a atividade prática.

Principais features
- CRUD completo para entidade Tarefa (id, nome, dataEntrega, responsavel)
- Spring Boot + Spring Data JPA
- MySQL (configuração em `src/main/resources/application.yml`)
- Documentação OpenAPI (UI disponível em /swagger-ui.html quando em execução)

Como rodar
1. Configure um banco MySQL local e atualize as credenciais em `application.yml`.
2. Build e execute com Maven:

```bash
mvn clean package
mvn spring-boot:run
```

Maven Wrapper (opcional)
Para garantir que outros desenvolvedores possam rodar o projeto sem instalar o Maven globalmente, gere o Maven Wrapper localmente com:

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
  "responsavel": "Henrique"
}
```

Testes e documentação
- Use Postman ou similar para testar os endpoints.
- A dependência `springdoc-openapi` adiciona automaticamente uma UI Swagger em /swagger-ui.html.

Observações
- Segui as instruções da atividade e as diretrizes do projeto (camadas controller/service/repository/model).
- Para desenvolvimento rápido sem MySQL, altere a URL do datasource para usar H2 (ou configure um profile `dev`).
