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

### Demonstração

No pacote problema nós temos uma classe `CalculadoraDeSalario` e ela possui um método calcula onde ela faz o calculo de salários, você pode pensar que ela faz ou só vai mudar por uma razão, que seria o cálculo de salários e ai que está a pegadinha, por que se você olhar a classe vai perceber que ela faz o cálculo de salário mas dos cargos de Desenvolvedor, DBA e Tester. E se tivermos um novo cargo? teríamos que adicionar mais um `if`, dando mais uma responsabilidade pra ela. Ela é um exemplo de adição de responsabilidades.

Para resolver isso nós vamos separar o calculo de cada cargo em uma classe nova, por que assim essa classe respeitaria o princípio, ela só precisaria mudar para o cálculo de salário **daquele cargo** e nada mais. No pacote de solução nós criamos uma interface para definir o contrato comum, já que o cálculo de salário é comum para qualquer cargo, como isso está ligado ao cargo, nós enriquecemos o Enum para mostrar além do cargo, retornar cada classe de cálculo para o cargo selecionado, e quem ficou com essa responsabilidade de invocar o cálculo é a classe `Funcionario`, por que a responsabilidade é dela.

[Exemplo](solid/src/main/java/com/estudo/srp)

## Aberto/Fechado (O)

Módulos, classes e funções devem ser abertos para extensão, mas fechados para modificação.

### Demonstração

A `CalculadoraDePreco` calcula o preço a vista ou a prazo, dependendo de qual é o produto utilizando uma tabela de preços. Perceba que a classe está aberta para modificação e fechada para extensão, por quê ser tiver uma tabela nova de cáculo de preços nós teremos que adicionar a lógica nela também e ela pode crescer muito, além disso ela está acoplada as dependências e isso é ruim. Para evitar isso, nós vamos criar interfaces(contratos) para os cálculos de preço e de frete, e a partir dai toda implementação nova vai utilizar esses contratos, e nós vamos tirar as dependências do cálculo de preço e de frete da `CalculadoraDePreco` e vamos fazer ela depender dos contratos, assim nós poderemos alterar em tempo de execução uma tabela nova de preço e de frete.

[Exemplo](solid/src/main/java/com/estudo/ocp)

## Substituição de Liskov (L)

Tipos derivados devem ser completamente substituíveis pelos seus tipos bases.

### Demonstração

Nós temos o exemplo da conta comum, onde ela possui as operações básica e também o rendimento, e também temos a conta salário que não possui o rendimento. Por questões de similaridades essa conta possui herança da conta comum. Mas note que nós alteramos o comportamento da classe base, fazendo com que o método de rendimento retorne uma exceção, isso pode quebrar a aplicação. Esse princípio diz que o tipo derivado deve ser completamente substituível pelo tipo base, se isso não acontecer então você sabe que não pode aplicar a herança e vai ter que buscar uma abordagem diferente como composição ou mesmo não ligar essas classes.

[Exemplo](solid/src/main/java/com/estudo/lsp)

## Segregação de Interface (I)

Clientes não devem ser forçados a depender de interfaces que eles não usam.

### Demonstração

A ideia é simplesmente não possui interfaces gordas, interfaces que possuam funcionalidades a mais do que o necessário, o exemplo demostra que a classe do `Desenvolvedor` ele herda a comissão, só que ele não recebe comissão. A segregação de interfaces resolve esse problema.

[Exemplo](solid/src/main/java/com/estudo/isp)

## Inversão de Dependência (D)

Módulos de alto nível não devem depender de módulos de baixo nível. Os dois devem depender de abstrações.
Abstrações não devem depender de detalhes. Detalhes devem depender de abstrações.

### Demonstração

A ideia é se for depender de algum recurso, que sejam de sua abstração e não da sua implementação, isso faz com o que a gente tenha um baixo acomplamento e possibilidade trocas de implementações.

[Exemplo](solid/src/main/java/com/estudo/dip)