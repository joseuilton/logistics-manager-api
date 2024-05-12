<h1 align="center">
  Logistics Manager API
</h1>

<h4 align="center">
    Uma API para gestão de clientes e produtos com código de barras
</h4>

<p align="center">
  <a href="#sobre">Sobre</a> •
  <a href="#recursos-principais">Recursos Principais</a> •
  <a href="#linguagens-e-tecnologias">Linguagens e tecnologias</a> •
  <a href="#pre-requisitos">Pré requisitos</a> •
  <a href="#como-executar">Como executar</a> •
  <a href="#contato">Contato</a> •
</p>

## Sobre
Esta é uma simples API desenvolvida durante um teste técnico para uma startup de gestão de notas fiscais

## Recursos principais

- O usuário pode realizar operações de CRUD na tabela "clientes"
- O usuário pode realizar operações de CRUD na tabela "produtos"
- O usuário pode realizar operações de CRUD na tabela "itens"
- O usuário pode importar um arquivo de nota fiscal XML e o sistema extrairá os clientes e produtos e salvar no banco de dados

## Linguagens e tecnologias
Back-end: ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

## Pre requisitos

Para rodar o projeto em sua máquina você deve ter:
- Java instalado na versão 17
- Maven na sua versão estável
- Docker e docker compose

## Como usar

### Clone este repositório
```bash
# Clone this repository
$ git clone git@github.com:joseuilton/logistics-manager-api.git

# Go into the repository
$ cd logistics-manager-api
```

### Execute o docker compose

Você pode consfigurar o postgreSQL de acordo com sua preferência, lembre-se de adicionar as modificações a "application.properties"

```bash
# Run docker compose with PostgreSQL image
$ sudo docker compose up -d
```

### Execute a API

Lembre-se de instalar as dependências utilizando o maven antes de executar o projeto

```bash
$ mvn spring-boot:run
```

Caso dê erro execute o comando de novo, havia um bug em meu sistema, não sei se no seu irá ocorrer também

## Contact
José Uilton - [@joseuilton](https://www.linkedin.com/in/joseuilton/) - joseuilton.siqueira@gmail.com

---
Feito com 💜 por José Uilton