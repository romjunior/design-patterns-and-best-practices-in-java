# Functional Design Patterns

## MapReduce

Usado para programação paralela massiva, desenvolvida pela Google, é uma forma de Monad.

Objetivo: Quebrar tasks e outras bem menores, executá-las em paralelo, e agregar o resultado(reduce).

## Loan

Usado para liberar a aplicação de recursos que não serão mais utilizados. Geralmente são utilizados para liberar conexões de banco e etc.

## Tail Call Optimization

Uma técnica utilizada por alguns compiladores para chamar uma função sem utilizar o *stack space*. Scala faz uso dessa técnica.

## Memoization

Intenção é utilizar cache de funções puras para evitar o uso intensivo da CPU, assim tem mais rapidez e economizamos recurso.