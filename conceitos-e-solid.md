# Conceitos

> Paradigma de programação: são conceitos, princípios e regras

Paradigmas:
* Imperativo: declarações são escritas para mudar o estado de um programa
* OOP: Classes(templates) e Objetos(implementação do template)
  * Principios:
    * Encapsulamento(manter propriedades e comportamentos em um único lugar, provém também esconder detalhes desnecessários)
    * Abstração(expõe o que um objeto faz, mas esconde como ele faz)
    * Herança
    * Poliformismo
      * CompileTime: Mesmo método com diferentes argumentos
      * Runtime: subclasse sobreescreve o método herdado, somente em tempo de execução com o objeto criado vai definir o seu comportamento.
* Declarativo: Inverso do Imperativo, fala o que o programa deve fazer, sem dizer como fazer.(Ex: SQL)
* Funcional
  * Considerado um sub-paradigma do declarativo.
  * As funções são similares a funções matemáticas. As funções dependem somente dos seus argumentos, são independentes do estado do programa.
  * Maioria baseada em lambda calculus
  * Habilidade de executar paralelamente(não confunda com multi-thread)


## Relacionamento de classes

Em OOP, além da herança existem outros conceitos para ajudar no desenvolvimento de sistemas complexos:
* Generalização(is-a) e realização(implementação de uma interface pela classe).
* Dependência.
* Associação(aggregação e composição).

# SOLID

## Responsabilidade Única (S)

O módulo do software deve possuir somente uma razão pra mudar. No Java isso é aplicado nas classes.

## Aberto/Fechado (O)

Módulos, classes e funções devem ser abertos para extensão, mas fechados para modificação.

## Substituição de Liskov (L)

Tipos derivados devem ser completamente substituíveis pelos seus tipos bases.

## Segregação de Interface (I)

Clientes não devem ser forçados a depender de interfaces que eles não usam.

## Inversão de Dependência (D)

Módulos de alto nível não devem depender de módulos de baixo nível. Os dois devem depender de abstrações.
Abstrações não devem depender de detalhes. Detalhes devem depender de abstrações.