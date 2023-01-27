Comandos para criar o container responsável por subir uma instância de um banco postgresql no docker

docker run --name meu-postgres -p7777:5432 -e POSTGRES_PASSWORD=123456 -d postgres:12.2 ( cria a imagem mapeando a porta do container para 
a porta da máquina)

docker exec meu-postgres psql -c "CREATE DATABASE petshop" -U postgres  (cria o schema no banco)

docker exec -it meu-postgres psql -U postgres petshop -W (entra no banco pelo psql)

========================================================================================================================================


Ordem de execução dos microsserviços: 

1 - Eureka
2 - Zuul
3 - Pessoas
4 - Animais

O serviço do eureka estará acessível à partir de http://localhost:8081/
Os serviços registrados estarão acessíveis por qualquel simulador de cliente REST (postman, insomnia, etc.) em http://localhost:8082/controle-pessoa-ms/api/pessoas
e http://localhost:8082/controle-animais-ms/api/animais 



