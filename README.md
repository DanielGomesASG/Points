# Algoritmo de cálculo de pontuação

A função do algoritmo em JAVA é avaliar uma lista de pontos em que os possíveis valores são "C", "D", "+" e ao menos 1 número, seguindo regras pré-estipuladas para cada valor, calculando e retornando a soma dos valores dessa lista em todos os casos possíveis. A lógica de tratamento foi feita em um teste técnico e o código foi aprimorado depois.

Regras:

- O valor "C" anula o anterior a ele somente se for um número, e necessariamente precisa de um valor anterior
- O valor "D" duplica o anterior a ele somente se for um número, atribui o resultado a sua posição e necessariamente precisa de um valor anterior
- O valor "+" soma os dois anteriores a ele somente se forem números, atribui o resultado a sua posição e necessariamente precisa de dois valores anteriores
- O valor que for igual a um número apenas é atribuido a posição
- O código deve funcionar em qualquer caso
