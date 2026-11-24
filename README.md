# API de Despesas da Associação

Spring Boot 3 · Java 17 · Spring Data JPA · MySQL · Validation · SpringDoc (Swagger UI)

## Como executar
1. Inicie o MySQL Server e confira usuário/senha em `src/main/resources/application.properties`
   (o banco `associacao_db` é criado automaticamente).
2. Abra a pasta no IntelliJ IDEA (Open → pom.xml) e execute `DespesasApplication`.
3. Swagger UI: http://localhost:8080/swagger-ui.html
4. Bruno: Open Collection → pasta `bruno/` → selecione o ambiente `local`.

## Endpoints (`/despesas`)
| Operação | Método e rota | Resposta |
|---|---|---|
| Cadastrar | POST /despesas | 201 Created |
| Listar | GET /despesas | 200 OK |
| Consultar | GET /despesas/{id} | 200 OK |
| Atualizar | PUT /despesas/{id} | 200 OK |
| Excluir | DELETE /despesas/{id} | 204 No Content |

Dados inválidos → 400 Bad Request · Id inexistente → 404 Not Found.

## Exemplo de corpo
```json
{ "descricao": "Conta de energia elétrica", "categoria": "Utilidades", "valor": 350.75, "dataDespesa": "2026-11-10" }
```
