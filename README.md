# Avaliação técnica Desenvolvedor
Regras : 
1. O projeto deve ser enviado ao github 
2. A estrutura do banco de dados pode ser um arquivo .SQL upado dentro do projeto, ou gerado automaticamente pelo projeto.
Utilizando Spring Boot e Postgres como banco de dados crie um microsserviço com as funcionalidades descritas abaixo:
1. Como usuário preciso salvar meus números de processos no sistema, quero poder enviar estes números através de uma requisição POST
- Obs : Os números de processos devem ser únicos
2. Como usuário quero receber um erro ao tentar cadastrar um processo que já foi cadastrado anteriormente
3. Como usuário quero poder consultar os números de processos que salvei
4. Como usuário quero poder excluir um número de processo que salvei
5. Como usuário quero poder adicionar um Réu a um processo que já cadastrei anteriormente
São pontos adicionais :
- Utilizar JUNIT para teste do endpoint de ponta a ponta
- Liquibase na geração da estrutura de dados

################################################################
# Teste

# API da Aplicação WebService.
http://localhost:8080/

API Teste feito com Swagger 3 para teste de ponta a ponta
http://localhost:8080/swagger-ui/index.html

1.Para Utilizar Importe o Projeto no Eclipse de um Update no Maven.
2.Editar o arquivo application.properties com o seu Banco de dados.
3.Criar banco de dados 'processo'.

Desenvolvimento foi feito utilizando Hibernate.

# Regra de Negocios:
1 - Número de Processo não poderá se repetir.

# Funcionalidades:
1.Cadastrar Numero de Processo.
2.Editar Número de Processo.
3.Listar Processo (Pesquisar)
4.Excluir Processo.

Modelo do Banco de dados feito no DBDesigner4.

https://ibb.co/XpZjBDX
