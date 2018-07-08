#(ENG) Good practices to build libraries and frameworks

## About coding

1 -  start from the simplest usage and keep going from there;

2 -  Functions should not depend on the global status but only on the arguments;

3 -  Every function is either general or application-specific;

4 -  Every function that could be made general should be made general;

5 - Keep a consistent name convention.

## About your users (other developers)

1 -  Keep a good documentation;

2 -  Just expose what you need to expose;

3 -  Make the usage simple;

4 - The common cases should be easy to do;

5 - Always keep the published code working;

6 - Dont surprise you users with unexpected behaviours;

7 - Don’t frustrate the users;




#(PTbr) Boas práticas para construção de biblitecas e frameworks

## Sobre o código que você escreve

1 -  inicie o desenvolvimento a partir dos casos de uso mais simples e evolua a biblioteca a partir dai;

2 -  funções deveriam depender apenas dos argumentos que recebem. Se uma função depende de algum argumento global, seu nome deveria deixar isso claro;

3 -  funções podem ser genéricas ou específicas para uma única aplicação. E isso não é errado!

4 -  seguindo do #3, se uma função ou comportamento pode ser generalizado para dentro de uma lib, ela deveria ser generalizada para possibilitar o reuso;

5 - mantenha uma nomenclatura consistente.

## Sobre sua responsabilidade para com seus usuários (desenvolvedores que usam suas libs)

1 -  qualquer estado / variável global de sua biblioteca deve ser documentada juntamente com seus valores padrão;

2 -  sempre matenha uma boa documentação junto ao site onde os usuários podem obter sua bibliteca;

3 -  exponha apenas aquilo que realmente for necessário;

4 -  faça com que o uso seja simples;

5 - os usos mais comuns devem ser muito simples de se realizar;

6 - sempre mantenha a versão publicada rodando corretamente, sem falhas conhecidas;

7 - não surpreenda seus usuários com comportamentos inesperados;

8 - não fruste seus usuários com falhas descaradas no código ou complexidade de uso desnecessária.
