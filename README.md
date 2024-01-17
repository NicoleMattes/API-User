<h1 align="center">API-User</h1>
<p align="center"><i>Repositório para versionamento e documentação do projeto durante o seu desenvolvimento</i></p>
<br>

- [Sobre o projeto](https://github.com/NicoleMattes/API-User/edit/main/README.md#sparkles-sobre-este-projeto)
- [Tecnologias Utilizadas](https://github.com/NicoleMattes/API-User/blob/main/README.md#space_invader-tecnologias-utilizadas)
- [Recursos Principais](https://github.com/NicoleMattes/API-User/blob/main/README.md#-recursos-principais)
- [Abrir e rodar o projeto](https://github.com/NicoleMattes/API-User/blob/main/README.md#%EF%B8%8F-abrir-e-rodar-o-projeto)
- [Contribuindo](https://github.com/NicoleMattes/API-User/blob/main/README.md#pencil2-contribuindo)
<br>


## :sparkles: Sobre este projeto 

<p> Bem-vindo ao repositório da API de Gerenciamento de Usuários! Esta API fornece funcionalidades essenciais para registro, autenticação e gestão de informações de usuários. </p>
<p>Desenvolvida utilizando Java e Spring Boot, a API oferece uma solução robusta para aplicações que necessitam de autenticação segura e controle de acesso.</p>
<br>

## :space_invader: Tecnologias Utilizadas 

<p display="inline-block">
      <img align="center" alt="Nick-Java"  src= "https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white">
      <img align="center" alt="Nick-Spring"  src= "https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot">
      <img align="center" alt="Nick-Spring"  src= "https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white">
      <img align="center" width="63" alt="Nick-mysql"  src= "https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white">
</p>
<br>
                                                                                                  
## 🔨 Recursos Principais: 

- `Cadastro de Usuário` Endpoint para registrar novos usuários com informações como nome, e-mail e senha.
- `Login de Usuário` Endpoint para autenticar usuários e fornecer tokens de acesso JWT para autorização subsequente.
- `Obtenção de Detalhes do Usuário Autenticado` Endpoint que retorna detalhes do usuário autenticado com base no token JWT.
- `Atualização de Informações do Usuário` Endpoint para permitir que usuários autenticados atualizem suas informações pessoais.
- `Logout de Usuário: Endpoint para invalidar` o token de acesso, efetuando o logout do usuário.

<br></br>
Esta API foi projetada com ênfase na segurança, implementando práticas como HTTPS, hashing de senhas e políticas de autorização. Sinta-se à vontade para explorar o código-fonte, contribuir com melhorias ou utilizar esta API como base para seus projetos. Qualquer feedback é bem-vindo!</p>
<br>
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

<br>
  
## :pencil2: Contribuindo 

Se você quiser contribuir para este projeto, por favor, siga os passos abaixo:

- Crie um fork do projeto.
- Crie uma branch para a sua contribuição: `git checkout -b feature/nova-funcionalidade`.
- Faça as alterações desejadas.
- Faça o commit das suas alterações: `git commit -m 'Adiciona nova funcionalidade`.
- Faça o push para a sua branch: `git push origin feature/nova-funcionalidade`.
- Abra um pull request.
