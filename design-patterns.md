# Design Patterns

## Creational Patterns

São padrões que lidam com a criação de objetos. [link](design-patterns/src/main/java/com/exemplo/creational)

**Singleton**

Somente uma única instância do objeto seja criada e utilizada, ex: [Singleton](design-patterns/src/main/java/com/exemplo/creational/singleton/Singleton.java). Mas se a execução for feita em um ambiente multi-threading então deveríamos proteger o trecho do código que cuida da construção do objeto pela primeira vez para evitar que ocorra a criação de mais de uma instância, usando ``synchronized`` ex: [SingletonSync](design-patterns/src/main/java/com/exemplo/creational/singleton/SingletonSync.java#L18). A utilização desse método para proteção tem custos de performance, se o singleton possuir uma lógica mais complexa podemos extrair o ``synchronized`` e utilizar a técnica do [double-check](design-patterns/src/main/java/com/exemplo/creational/singleton/SingletonSync.java#L27), e por último a melhor implementação seria se não precisásemos criar locks e também se o singleton conseguisse continua thread-safe e isso pode ser feito pelo [Lock-free thread-safe](design-patterns/src/main/java/com/exemplo/creational/singleton/LockFreeSingleton.java), nas verões mais novas da JVM essa seria a melhor alternativa, já que o carregamento de classes é feito somente quando realmente vai se utilizar(para versões antigas não é dessa maneira), isso se traduz nas versões eager/lady.

**[Factory](design-patterns/src/main/java/com/exemplo/creational/factory)**

É usada para encapsular a lógica de instânciação de objetos que utilizam uma interface única. Novas classes podem ser adicionadas com o mínimo de mudanças

Temos 4 tipos:
* Simple Factory
* Method Factory
* Anonymous Factory
* Abstract Factory

**[Builder](design-patterns/src/main/java/com/exemplo/creational/builder)**

Usada quando precisamos construir um objeto complexo para diferentes objetos de estruturas e estados diferentes.

### Behavioral Patterns

Padrões que lidam interação, comunicação e fluxo de controle. A maioria são baseados na composição, e delegação ao invés de herança. [Link](design-patterns/src/main/java/com/exemplo/behavioral)


**[Cadeia de responsabilidade](design-patterns/src/main/java/com/exemplo/behavioral/chainofresponsability)**

Encadeiam os handlers a ponto de eles processarem algo se for de sua responsabilidade, ou simplesmente passar pra frente(próximo handler).

Aplicabilidade e Exemplos: Event handlers, Log handlers, Servlets

**[Observer](design-patterns/src/main/java/com/exemplo/behavioral/observer)**

Faz com que a mudança de estado seja observável para os objetos registrados serem informados.

**[Memento](design-patterns/src/main/java/com/exemplo/behavioral/memento)**

Usado para salvar o estado interno de um objeto sem quebrar o encapsulamento, restaurando o seu estado.

Aplicabilidade: utilizado quando precisar de operações de rollback. Operações atômicas que devem voltar ao estado inicial caso uma das ações falhe.

**[Strategy](design-patterns/src/main/java/com/exemplo/behavioral/strategy)**

Define uma família de algoritmos, encapsula cada um deles e os faz intercaláveis.

**[Template Method](design-patterns/src/main/java/com/exemplo/behavioral/templatemethod)**

Evitar escrever código duplicado e focar no core

### Structural Patterns

São feitos para criar estruturas complexas fazendo o uso de relações entre objetos e classes. [Link](https://github.com/romjunior/design-patterns-and-best-practices-in-java/tree/master/design-patterns/src/main/java/com/exemplo/structural)

**[Adapter](design-patterns/src/main/java/com/exemplo/structural/adapter)**

Objetivo é adaptar uma interface antiga para uma nova interface.

**[Proxy](design-patterns/src/main/java/com/exemplo/structural/proxy)**

Fornece um substituto ou espaço reservado para outro objeto para controlar o acesso a ele.

**[Decorator](design-patterns/src/main/java/com/exemplo/structural/decorator)**

Esse padrão diz que não podemos modificar as funcionalidades existentes, mas nós podemos estender. 
Em outras palavras, esse padrão é aberto para estender, mas fechado para modificação.

**[Bridge](design-patterns/src/main/java/com/exemplo/structural/bridge)**

Desacoplar a abstração da implementação permitindo assim que elas variem independentemente. 

**[Composite](design-patterns/src/main/java/com/exemplo/structural/composite)**

O Composite é um padrão de projeto estrutural que permite que você componha objetos em estruturas de árvores e então trabalhe com essas estruturas como se elas fossem objetos individuais.

**[Facade](design-patterns/src/main/java/com/exemplo/structural/facade)**

Provem uma interface unificada para sistemas complexos