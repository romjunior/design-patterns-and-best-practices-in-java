# Design Patterns and Best Practices in Java

## Fontes

Estudo do livro: Design Patterns and Best Practices in Java

Código fonte do livro: [Github](https://github.com/PacktPublishing/Design-Patterns-and-Best-Practices-in-Java)

Imagens do livro: [Imagens](https://static.packt-cdn.com/downloads/DesignPatternsandBestPracticesinJava_ColorImages.pdf)

[Refactoring Guru](https://refactoring.guru/pt-br)

## Conceitos

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


### Relacionamento de classes

Em OOP, além da herança existem outros conceitos para ajudar no desenvolvimento de sistemas complexos:
* Generalização(is-a) e realização(implementação de uma interface pela classe).
* Dependência.
* Associação(aggregação e composição).

## SOLID

### Responsabilidade Única (S)

O módulo do software deve possuir somente uma razão pra mudar. No Java isso é aplicado nas classes.

### Aberto/Fechado (O)

Módulos, classes e funções devem ser abertos para extensão, mas fechados para modificação.

### Substituição de Liskov (L)

Tipos derivados devem ser completamente substituíveis pelos seus tipos bases.

### Segregação de Interface (I)

Clientes não devem ser forçados a depender de interfaces que eles não usam.

### Inversão de Dependência (D)

Módulos de alto nível não devem depender de módulos de baixo nível. Os dois devem depender de abstrações.
Abstrações não devem depender de detalhes. Detalhes devem depender de abstrações.


## Design Patterns

### Creational Patterns

São padrões que lidam com a criação de objetos. [link](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/creational)

**Singleton**

Somente uma única instância do objeto seja criada e utilizada, ex: [Singleton](https://github.com/romjunior/design-patterns-and-best-practices-in-java/blob/master/design-patterns/src/main/java/com/exemplo/creational/singleton/Singleton.java). Mas se a execução for feita em um ambiente multi-threading então deveríamos proteger o trecho do código que cuida da construção do objeto pela primeira vez para evitar que ocorra a criação de mais de uma instância, usando ``synchronized`` ex: [SingletonSync](https://github.com/romjunior/design-patterns-and-best-practices-in-java/blob/fa86e1dd8cb9db9958405a547fe6172c7cac17a9/design-patterns/src/main/java/com/exemplo/creational/singleton/SingletonSync.java#L18). A utilização desse método para proteção tem custos de performance, se o singleton possuir uma lógica mais complexa podemos extrair o ``synchronized`` e utilizar a técnica do [double-check](https://github.com/romjunior/design-patterns-and-best-practices-in-java/blob/fa86e1dd8cb9db9958405a547fe6172c7cac17a9/design-patterns/src/main/java/com/exemplo/creational/singleton/SingletonSync.java#L27), e por último a melhor implementação seria se não precisásemos criar locks e também se o singleton conseguisse continua thread-safe e isso pode ser feito pelo [Lock-free thread-safe](https://github.com/romjunior/design-patterns-and-best-practices-in-java/blob/master/design-patterns/src/main/java/com/exemplo/creational/singleton/LockFreeSingleton.java), nas verões mais novas da JVM essa seria a melhor alternativa, já que o carregamento de classes é feito somente quando realmente vai se utilizar(para versões antigas não é dessa maneira), isso se traduz nas versões eager/lady.

**[Factory](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/creational/factory)**

É usada para encapsular a lógica de instânciação de objetos que utilizam uma interface única. Novas classes podem ser adicionadas com o mínimo de mudanças

Temos 4 tipos:
* Simple Factory
* Method Factory
* Anonymous Factory
* Abstract Factory

**[Builder](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/creational/builder)**

Usada quando precisamos construir um objeto complexo para diferentes objetos de estruturas e estados diferentes.

### Behavioral Patterns

Padrões que lidam interação, comunicação e fluxo de controle. A maioria são baseados na composição, e delegação ao invés de herança. [Link](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/behavioral)


**[Cadeia de responsabilidade](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/behavioral/chainofresponsability)**

Encadeiam os handlers a ponto de eles processarem algo se for de sua responsabilidade, ou simplesmente passar pra frente(próximo handler).

Aplicabilidade e Exemplos: Event handlers, Log handlers, Servlets

**[Observer](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/behavioral/observer)**

Faz com que a mudança de estado seja observável para os objetos registrados serem informados.

**[Memento](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/behavioral/memento)**

Usado para salvar o estado interno de um objeto sem quebrar o encapsulamento, restaurando o seu estado.

Aplicabilidade: utilizado quando precisar de operações de rollback. Operações atômicas que devem voltar ao estado inicial caso uma das ações falhe.

**[Strategy](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/behavioral/strategy)**

Define uma família de algoritmos, encapsula cada um deles e os faz intercaláveis.

**[Template Method](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/behavioral/templatemethod)**

Evitar escrever código duplicado e focar no core

### Structural Patterns

São feitos para criar estruturas complexas fazendo o uso de relações entre objetos e classes. [Link](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/structural)

**[Adapter](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/structural/adapter)**

Objetivo é adaptar uma interface antiga para uma nova interface.

**[Proxy](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/structural/proxy)**

Fornece um substituto ou espaço reservado para outro objeto para controlar o acesso a ele.

**[Decorator](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/structural/decorator)**

Esse padrão diz que não podemos modificar as funcionalidades existentes, mas nós podemos estender. 
Em outras palavras, esse padrão é aberto para estender, mas fechado para modificação.

**[Bridge](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/structural/bridge)**

Desacoplar a abstração da implementação permitindo assim que elas variem independentemente. 

**[Composite](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/structural/composite)**

O Composite é um padrão de projeto estrutural que permite que você componha objetos em estruturas de árvores e então trabalhe com essas estruturas como se elas fossem objetos individuais.

**[Facade](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/structural/facade)**

Provem uma interface unificada para sistemas complexos

## Functional Programming

Diferente do paradigma OOP, a construção de um programa é composto por funções ao invés de objetos. Isso é feito da maneira declarativa, por composição de funções, imutabilidade, e evitando *side-effects* em dados compartilhados.

Isso nos da um código mais consciso e mais resiliente à mudanças, previsível e mais fácil para manutenção.

### Conceitos e Príncipios

**Lambdas**

Vem do Lambda Calculus e é usada para identificar *functions expressions*, são mais simples e tem escrita reduzida do que declarações. No Java 8 foi disponibilizada e trabalha de uma maneira diferente, não gerando classes para serem carregadas, para evtiar problemas de performance.

Exemplo, cálculo do radio do círculo:
```java
(x, y) -> x*2 + y*2
```

**Pure Functions**

É uma função que não possui *side-effects*, se sua entrada é a mesma, sua saída também será(previsível e cacheável). *side-effect* é uma ação que modifica o funcionamento da função de fora do contexto dela.

Exemplos:
* Escrevendo em um arquivo/console/rede/tela
* Modificar uma variável/obejto de fora da função
* Chamar uma função não pura
* iniciar um processo

É inevitável um programa não possuir funções não puras, que causam *side-effects* por isso tente isolar essas funções das puras. Haskell e em outras linguagens funcionais isso é feito usando *Monads*

**Referential Transparency**

É a propriedade da função ser substítuível com o seu valor de retorno e o seu valor de input. Isso favorece caching o resultado para o mesmo input, paralelismo das chamadas e escrita de testes.

**First-class Functions**

São funções que podem ser tratadas como os objetos no OOP - criados, armarenados, usados como parâmetors, e retornado como valores.

**Higher-order Functions**

São funções que podem receber outras funções como parâmetros, criá-las e retorna-las. Promovem o reuso de código, utilizando funções menores e que já foram testadas.

Exemplo. cálculo da média do dobro dos números passados
```java
OptionalDouble avg = IntStream.of(4, 5, 6)
.map(x -> x*2) //higher-order function
.average();
```

**Composition**
 Na matemática, as funções são compostas/ligadas usando a saida de uma função como entrada para a próxima função. Mesma regra se aplica para *first-class functions* serem usadas pelas *higher-order functions*

 **Currying**

 é o processo usado para transformar uma *n-ary function* em uma série ou *unary functions*

 Exemplo, forma *curried* da função f:: (x, y) -> z
```java
x -> y -> z
```

Exemplo, cálculo da raio quadrado:
```java
Function<Integer, Function<Integer, Integer>> square_radius = x -> y -> x*x + y*y;
List<Integer> squares = List.of(new Tuple<Integer, Integer>(1,5), new Tuple<Integer, Integer>(2,3))
.stream()
.map(square - > square_radius.apply(square.y).apply(square.x))
.collect(Collectors.toList());
===> [26, 13]
```

**Closure**

É uma tecnica para implementar o *lexical scoping*(permite nós acessarmos variáveis fora do contexto dentro do *inner scope*)

**Immutability**

Promover imutabilidade simplifica o código e permite que os desenvolvedores foquem no fluxo. O pior tipo de *side-effects* são os que mudam pouco em um ponto e produzem resultados catastróficos em outro(Efeito borboleta). São difícies de paralelizar e as vezes temos que trabalhar com *locks*.

**Functors**

Permitem aplicar funções dado o container. Eles sabem como *unwrap* o valor do *wrapped object*, aplicar a função e retornar um outro functor contendo o novo/transformado *wrapped object* como resultado. Ex de functors(Collections, futures(promises), e Optionals)

Exemplo, usando o Functor `Optional`, aplicando uma divisão em um Optional(5) vai retornar outro Optional(2,5)
```java
Optional<Float> a = Optional.of(5);
Optional<Float> b = a.map(x -> x/2);
b.get() ===> 2,5
```
**Applicatives**

Adicionam um novo nível de *wrapping*. Ao invés de aplicar a função no *wrapped object*, a função é *wrapped* também.

Exemplo, vamos criar um Optional que retorne uma função, e se não possuir uma função(Optional.Empty), ela vai executar a `Function.identity()`(tudo fica a mesma coisa).
```java
Optional<String> a = Optional.of("Hello!");
Optional<Function<String, String>> upper = Optional.of(String::toUpperCase);
a.map(x -> upper.get().apply(x)); // HELLO!
// mas caso o upper fosse empty
upper = Optional.empty();
Optional<Function<String, String>> identity = Optional.of(Function.identity());
a.map(x -> upper.or(() -> identity).get().apply(x)); //Hello!
```

**Monads**

aplica uma função que retorna um valor *wrapped* para um valor *wrapped*. Java tem exemplos como `Stream`, `CompletableFuture`, `Optional`.

Exemplo:
```java
Map<Integer, String> codesMapping = Map.of(400500, "Cluj-Napoca", 75001, "Paris", 10115, "Berlin", 10000, "New York");
List<Integer> codes = List.of(400501, 75001, 10115, 10000);
codes.stream().flatMap(x -> Stream.ofNullable(codesMapping.get(x))).collect(Collectors.toList()); //Paris, Berlin, New York
```
### Programação funcional no Java 8

**Lambda expressions**

são as funções para utilização que estão disponíveis no `java.util.functions` pacote de interfaces.

Interfaces funcionais: BiConsumer<T, U>, BiFunction<T, U, R>, BinaryOperator<T>, BiPredicate<T, U>, Consumer<T>, Function<T, R>

**Streams**

São uma pipeline de funções que tranformam, não mutam, os dados. eles possuem operações de crição, intermediárias e terminais. Para obter um valor de um Stream, deve-se chamar uma operação terminal. Eles não são estruturas de dados, eles não podem ser reusados, uma vez consumidos eles permanecem fechados. Se for chamado uma segunda vez é lançado `java.lang.IllegalStateException` 

* Operações de criação(Exemplos):
 * stream()
 * parallelStream()
 * generate()
 * of()
 * empty()
 * iterate()
 * concat()
 * range()
 * rangeClosed()

* Operações intermediárias:
 * sequential()
 * parallel()
 * unordered()
 * onClose()
 * filter()
 * map()
 * flatMap()
 * distinct()
 * sorted()
 * peek()
 * limit()
 * skip()

* Operações terminais:
 * iterator()
 * splititerator()
 * toArray()
 * collect()
 * findFirst()
 * findAny()
 * min()
 * max()
 * anyMatch()
 * allMatch()
 * noneMatch()
 * reduce()

