# Api para práticar CRUD com Spring Boot utilizando o padrão de arquitetura MVC.

### Requisitos:
> - Maven
> - Java 17
> - Spring boot versão 3.1.1

### Opcionais:
> - Intellij
> - Postman
> - Mysql

### Essa API foi inspirada no filme Matrix e possui um CRUD (Create, Read, Update e Delete) para as armas utilizadas no resgate do Morpheus.

> Foi utilizado o padrão de arquitetura MVC (Model-View-Controller) para separar a aplicação em camadas, cada uma com suas devidas responsabilidades.
> A API enfatizou as camadas Model e Controller, mas a camada de Visualização pode ser adicionada conforme sua preferência.

### Model:
> Representa dados, entidades, regras de negócio e gerencia informações, cuidando da integridade dos dados.

### Controller:
> Intermediário entre Model e View. Recebe requisições do usuário, processa operações no Model e atualiza. 
> Contém a lógica de controle da aplicação, definindo a manipulação e exibição dos dados.