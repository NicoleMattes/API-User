<h1 align="center">API-User</h1>
<p align="center"><i>Repositório para versionamento e documentação do projeto durante o seu desenvolvimento</i></p>

##  Sobre este projeto

<p> Bem-vindo ao repositório da API de Gerenciamento de Usuários! Esta API fornece funcionalidades essenciais para registro, autenticação e gestão de informações de usuários. </p>
<p>Desenvolvida utilizando Java e Spring Boot, a API oferece uma solução robusta para aplicações que necessitam de autenticação segura e controle de acesso.</p>
<br></br>

<p display="inline-block">
  <img width="48" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" alt="java-logo"/>
  <img width="48" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" alt="spring-logo"/>
  <img width="48" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" alt="mysql-logo"/>
  <img width="47" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/kotlin/kotlin-original.svg" alt="kotlin-logo"/>
</p>

                                                                                                  
## 🔨 Recursos Principais:

- `Cadastro de Usuário` Endpoint para registrar novos usuários com informações como nome, e-mail e senha.
- `Login de Usuário` Endpoint para autenticar usuários e fornecer tokens de acesso JWT para autorização subsequente.
- `Obtenção de Detalhes do Usuário Autenticado` Endpoint que retorna detalhes do usuário autenticado com base no token JWT.
- `Atualização de Informações do Usuário` Endpoint para permitir que usuários autenticados atualizem suas informações pessoais.
- `Logout de Usuário: Endpoint para invalidar` o token de acesso, efetuando o logout do usuário.

<br></br>
Esta API foi projetada com ênfase na segurança, implementando práticas como HTTPS, hashing de senhas e políticas de autorização. Sinta-se à vontade para explorar o código-fonte, contribuir com melhorias ou utilizar esta API como base para seus projetos. Qualquer feedback é bem-vindo!</p>

## 🛠️ Abrir e rodar o projeto

### Pré-requisitos
Certifique-se de ter o seguinte instalado em sua máquina:
- [Java JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Gradle](https://gradle.org/)

### Configuração do Banco de Dados

- Abra o projeto na sua IDE favorita.
- No diretório src/main/resources, encontre o arquivo application.properties e configure as seguintes propriedades para conectar ao seu banco de dados local:
  
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
spring.datasource.username=sua_usuario
spring.datasource.password=sua_senha
```

### Como Rodar o Projeto

- ./gradlew build
- ./gradlew bootRun

## Contribuindo 

Se você quiser contribuir para este projeto, por favor, siga os passos abaixo:

- Crie um fork do projeto.
- Crie uma branch para a sua contribuição: `git checkout -b feature/nova-funcionalidade`.
- Faça as alterações desejadas.
- Faça o commit das suas alterações: `git commit -m 'Adiciona nova funcionalidade`.
- Faça o push para a sua branch: `git push origin feature/nova-funcionalidade`.
- Abra um pull request.
