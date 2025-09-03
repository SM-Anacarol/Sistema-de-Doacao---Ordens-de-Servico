# Sistema de Doação – Ordens de Serviço

Aplicação Spring Boot (Web + JPA + H2) com página estática que consome a API REST para cadastrar Clientes, Técnicos e Ordens de Serviço.

## Como rodar
1) Windows (PowerShell) na raiz do projeto:
```
mvnw.cmd spring-boot:run
```
Linux/Mac:
```
./mvnw spring-boot:run
```
2) Backend sobe em `http://localhost:8080`.
3) Acesse a interface:         
- `http://localhost:8080/index.html`, ou
- abrindo o arquivo `src/main/resources/static/index.html` (detecta `file://` e usa a API em `http://localhost:8080`).

## Endpoints
- `GET /clientes` | `POST /clientes`
- `GET /tecnicos` | `POST /tecnicos`
- `GET /os` – lista ordens
- `POST /os` – cria ordem. Exemplo:
```
{ "descricao": "Troca de tela", "clienteId": 1, "tecnicoId": 2 }
```
- `PUT /os/{id}/status` – atualiza status. Exemplo:
```
{ "status": "ABERTA" }
```

## Banco H2
- Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:doacao-db`
- Usuário: `sa` (sem senha)

## Notas
- CORS habilitado com `@CrossOrigin("*")` nos controladores.
- Se a porta 8080 estiver ocupada, altere `server.port` em `src/main/resources/application.properties`.

## Estrutura
```
src/
  main/
    java/com/trabalhogil/sistema_doacao/
      controller/
      model/
      repository/
    resources/
      static/index.html
      application.properties
```
