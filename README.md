# demo-spring-jwt
Este projeto tem por finalidade exemplificar a segurança em aplicações Spring Boot utilizando Json Web Token (JWT).

Link para documentação: https://jwt.io/introduction/

Passos para realização de testes via restClient:

# Simulando o login:
 - Start a aplicação;
 - Realize um POST para http://localhost:8081/demo/authorization/login com o payload {"login": "seuLogin", "senha": "suaSenha"}

Ao realizar os passos acima vocês obterão o token referente à autenticação. Algo como o exibido abaixo:
{
"token": "eyJhbGciOiJIUzI1NiJ9.eyJ1c3VhcmlvU2lzdGVtYSI6eyJpZCI6MSwibG9naW4iOiJhZG1pbiJ9LCJleHAiOjE0OTA4MzM0NjksImlhdCI6MTQ5MDgzMTY2OX0.FNNcFin-u2o26k15og4TDejCkgKJWgwuODLkADk3fYs"
}

# Simulando um acesso a um endpoint protegido sem informar o token no header da requisição:
 - Start a aplicação;
 - Realize um GET para http://localhost:8081/demo/api/endpoint-protected

Ao realizar os passos acima vocês receberão a seguinte resposta: status=401 - Unauthorized.

# Simulando um acesso com sucesso a um endpoint protegido:
- Start a aplicação;
- Realize um GET para http://localhost:8081/demo/api/endpoint-protected adicionando ao header o Authorization com o valor do token.
 Exemplo: Authorization: demoToken eyJhbGciOiJIUzI1NiJ9.eyJ1c3VhcmlvU2lzdGVtYSI6eyJpZCI6MSwibG9naW4iOiJhZG1pbiJ9LCJleHAiOjE0OTA4MzU3OTksImlhdCI6MTQ5MDgzMzk5OX0.B9_BSDI2KPS_AWrJaYLlD8DlKK68FQIMIVae5Mgwd1c
 
Ao realizar os passos acima vocês receberão a seguinte resposta:
# Você acaba de acessar um endpoint protegido. Parabéns!!

# Observações sobre o último passo:
 Se um token inválido ou expirado for informado, a resposta será outra. Por exemplo: 
 {
"timestamp": 1490834254300,
"status": 408,
"error": "Request Timeout",
"message": "Opa, identificamos que você está a algum tempo sem acessar o sistema. Para sua segurança, logue novamente.",
"path": "/demo/api/endpoint-protected"
}

