# Mback-payment

Este projeto é uma aplicação Spring Boot que fornece uma API RESTful para gerenciar pagamentos.

## Tecnologias Utilizadas

- Java 17: A linguagem de programação principal usada no projeto.
- Gradle: A ferramenta de automação de compilação usada para gerenciar dependências e construir o projeto.
- Spring Boot: O framework usado para simplificar a configuração e o desenvolvimento de aplicações Java.
- H2 Database: Um banco de dados em memória usado para testes.
- MySQL Connector/J: O driver JDBC usado para conectar o aplicativo ao banco de dados MySQL.
- Lombok: Uma biblioteca Java que ajuda a reduzir a verbosidade do código Java.
- Jacoco: Uma ferramenta usada para medir a cobertura de código de testes unitários.

## Endpoints

Aqui estão os endpoints disponíveis nesta aplicação:

- `GET /api/v1/payments`: Retorna uma lista de todos os pagamentos.
- `GET /api/v1/payments/{id}`: Retorna os detalhes de um pagamento específico.
- `POST /api/v1/payments`: Cria um novo pagamento.
- `PUT /api/v1/payments/{id}`: Atualiza um pagamento existente.
- `DELETE /api/v1/payments/{id}`: Exclui um pagamento.

## Como Executar o Projeto

1. Clone o repositório.
2. Navegue até o diretório do projeto.
3. Execute o comando `./gradlew bootRun`.

## Como Executar os Testes

1. Navegue até o diretório do projeto.
2. Execute o comando `./gradlew test`.