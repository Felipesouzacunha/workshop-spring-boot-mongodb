# Projeto Spring Boot com MongoDB

Este projeto é uma API REST desenvolvida com **Spring Boot** e **MongoDB**, onde os usuários podem ser cadastrados e criar posts. Cada post contém um usuário aninhado. A arquitetura segue o padrão **DTO** e utiliza a estrutura **Controller-Service-Repository**.

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3**
- **Spring Data MongoDB**
- **MongoDB**
- **Spring Web**

## Estrutura do Projeto

O projeto segue a estrutura **Controller-Service-Repository**, garantindo a separação de responsabilidades:

```
src/
│── main/
│   ├── java/com/felipesouza/workshop/
│   │   ├── config/
│   │   ├── controller/
│   │   ├── controller/exception
│   │   ├── controller/util
│   │   ├── domain/
│   │   ├── dto/
│   │   ├── repository/
│   │   ├── services/
│   │   ├── services/exception
│   ├── resources/
│       ├── application.properties
│── test/
```

### Domain

- **User**: Representa um usuário do sistema.
- **Post**: Representa um post criado por um usuário.

### DTOs

- **UserDTO**: Utilizado para transferir dados do usuário de forma otimizada.
- **PostDTO**: Transferência de dados do post aninhado ao usuário.
- **CommentsDTO**: Transferência de dados para uma lista de comentários atrelados aos post.

### Endpoints da API

#### Usuários

| Método | Endpoint | Descrição |
|--------|----------|------------|
| GET | `/users` | Retorna todos os usuários |
| GET | `/users/{id}` | Retorna um usuário por ID |
| GET | `/users/{id}/posts` | Retorna os comentários que o usuários fez |
| POST | `/users` | Cadastra um novo usuário |
| PUT | `/users/{id}` | Atualiza um usuário existente |
| DELETE | `/users/{id}` | Remove um usuário |

#### Posts

| Método | Endpoint | Descrição |
|--------|----------|------------|
| GET | `/posts/{id}` | Retorna um post por ID |
| GET | `/posts/titleseach` | Retorna os comentários do post |
| GET | `/posts/fullSearch` | Uma busca avançada com regex especificando a data miníma, a data máxima e o título |

## Configuração e Execução

1. Clone o repositório:
   ```sh
   git clone https://github.com/Felipesouzacunha/workshop-spring-boot-mongodb.git
   ```
2. Configure o MongoDB no `application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo
   ```
3. Execute a aplicação com:
   ```sh
   mvn spring-boot:run
   ```
4. Acesse os endpoints via Postman ou outra ferramenta API.

## Contribuições

Contribuições são bem-vindas! Para contribuir:
1. Faça um fork do repositório.
2. Crie uma branch.
3. Envie um pull request.

## Licença

Este projeto é distribuído sob a licença MIT. Consulte `LICENSE` para mais informações.

