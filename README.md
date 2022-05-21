
## Requisitos
* JDK 11
* Maven
* PostgreSQL

## Instalação

### Build
```console
$ mvn clean install -DskipTests
```

### Running

```console
$ mvn spring-boot:run
```

## Banco de dados

* Criar um banco de dados com o seguinte nome: `armazem`. O framework Hibernate irá gerar as tabelas do banco aumaticamente ao rodar o projeto.
* Configurar usuario, senha, ip, host and nome do banco de dados no arquivo: `src/main/resources/application,properties`