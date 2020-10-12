# Programação Reativa

De acordo com o [Manifesto Reativo](https://www.reactivemanifesto.org/pt-BR), sistemas reativos possuem os seguintes atributos:
* **Responsivo**: O sistema responde em um tempo hábil se possível.
* **Resiliente**: O sistema continua respondendo em caso de falha.
* **Elástico**: O sistema continua responsivo mesmo sob variações de demanda.
* **Orientado a Mensagens**: Sistemas reativos usam passagem de mensagens assíncronas para estabelecer fronteiras entre componentes e garantir baixo acoplamento, isolamento, transparência na localização e provêem meios para delegar o tratamento de erros através de mensagens.

Paradigma de programação reativa de baseia em stream de dados assíncronos(asynchronous data streams). Programação Reativa é aplicada usando algumas abstrações, algumas do mundo funcional:
* Future/Promises: Uma maneira de agir nos valores que serão retornados em algum momento no futuro.
* Stream: é uma *data pipeline*, "é o trilho do trem que da suporte para o trem passar".
* Dataflow variables: esses são os resultados de funções aplicadas no stream.
* Throttling: Mecanismo usado em ambientes *real-time processing*, para regular a velocidade de *input*. É utilizado *back-pressure* como estratégia.
* Mecanismo de Push: Assim que a informação fica disponível a informação é passada(*pushed*) para os *Observers*, ao invés dos *Observers* ficarem consultando a fonte de dados(pull).

## RxJava

* Observables: Responsável por emitir os dados assim que disponível.
  * Hot: começa a emitir assim que possível mesmo que não possuir Subscribers ligados.
  * Cold: espera pelo menos um Subscriber se ligar antes de emitir dados. Também são chamados de *Connectable Observers* 
* Observer: Responsável por reagir/consumir e/ou transformar os dados disponíveis.

## Reactive Design Patterns

Patterns são focados nos 4 pontos da programação reativa

### Responsividade

**Request-response**

É um *core pattern*. O nosso serviço recebe uma requisição e retorna uma resposta.

**Asynchronous-communication**

Esse padrão faz com que a aplicação fique responsiva mesmo quando faz operações intensivas, como gerar relatórios, por exemplo. Imagine que gerar um relatório em tempo de execução é muito demorado e só pode ser feito no momento em que o usuário requisitar essa ação. Poderíamos tornar a geração e disponibilização do relatório assincrona, no momento da requisição enviando uma resposta que a requisição foi feita e que após de alguns minutos o relatório estará disponível via e-mail ou na tela de relatórios.

**Caching**

Outro padrão para garantir a responsividade é implementar sistema de cache, onde ele garante que requisições similares são respondidas mas rapidamente e sem utilizar processamento, já que ele é feito na primeira vez antes do sistema do cache gravar a informação. Ele pode ser implementado em diferentes níveis, controllers, services, repositories, clients. E até antes de chegar no serviço como em load-balancer

**Fan-out and quickest-reply**

Em aplicações em tempo real a velocidade em extremamente importante. Então podemos subir várias instâncias do mesmo serviço e quando recebermos a requisição enviar para todas as instências, ficamos com a resposta da instência que responder primeiro e descartâmos as outras respostas, isso tem uma desvantagem que é o custo de recursos, já que iremos consumir mais com mais instâncias em pé.

**Fail-fast**

Esse padrão fala sobre caso haja indisponibilidade nos serviços de terceiros(dependências) que a aplicação não fique esperando uma resposta por muito tempo, que ela já retorne um erro tratado para o usuário o mais rápido possível. Outro ponto que poderia melhorar a experiência é verificar se o serviço está disponível antes de iniciar o processo, se não tiver, já retorna o erro de indisponibilidade, falhar rápido contribui para experiência do usuário, mesmo sendo ruim retornar erros.

### Resiliência

**circuit-breaker**

Esse padrão se baseia no circuito elétrico, ao invês de deixar a falha propagar entre a chamada de serviços, implementando retentativas(em caso de instabilidade), e após esse número de tentativas não conseguir a resposta ele pode ir para um fallback ou avisar monitoração que a dependência se encontra disponível e parar de fazer chamadas para o serviço indisponível por um certo período de tempo, isso para ajudar o serviço instável a se recuperar e não ficar sofrendo um volume de requisições quando esta iniciando ainda.

**failure-handling**

Uma pergunta importante para manter a resiliência é se perguntar, se um serviço cair o sistema vai parar de funcionar? A ideia é que só componente que depende do serviço seja afetado, e que as outras funcionalidade continuem funcionando normalmente. E em caso de o usuário tentar utilizar o componente indisponível, podemos mostrar resultados utilizando cache das últimas pesquisas feitas, ou uma mensagem falando sobre a indisponibilidade e prazo para normalização do serviço.

**bounded-queue**

Um padrão onde controlamos o número de requisições que um serviço pode lidar, nessa abordagem os serviços devem lidar com as requisições utilizando uma fila(*queue*) de tamanho fixo assim o serviço vai executando essas requisições a partir do momento em que fica livre. O tamanho fixo serve para caso a fila fique cheia o serviço comece a recusar requisições para os serviços que o chamam, tem um gerenciamento melhor por parte do serviço que recebe as requsições, ele se torna mais resiliente

### Monitoramento

**Bulkhead**

É termo que foi pego dos navios de cargo, onde cada sessão é totalmente isolada uma da outra, assim se uma sessão for inundada ou pegar fogo não vai afetar as outras sessões do navio, isso se aplica um serviço ou grupo de serviços, se houver uma queda de um serviço ou grupos deles não deve deixar a aplicação totalmente indisponível. Para implementar esse padrão deve-se garantir que todos os serviços trabalhem de forma independente, e as falhas não serão propagadas, todos os padrões reativos descritos aqui ajudam a chegar nesse objetivo.

### Elasticidade

**Single responsibility**

Conhecido como *single-component* ou *microservice pattern*, mesma ideia do *single responsibility principle* da orientação á objetos, uma classe só deve possuir um único motivo para mudar. A mesma coisa se aplica a serviços e componentes.

**Stateless-services**

Para ter os serviços escaláveis eles devem ser construídos sem estados. Isso quer dizer que o serviço não guarda nenhum estado das chamadas anteriores, ele vai tratar todas as chamadas como se fossem novas. Para manter estado podemos guardar a sessão em um lugar compartilhado e acessível a todas as instâncias, como um banco. Só que é trabalhoso e ainda assim não escala rápido. A solução ideal pode utilizar para manter estado baseado em Token, como JWT.

**Autoscaling**

É mais um padrão baseado em deployment do que em desenvolvido. Existem dois tipos de Autoscaling. Vertical: Baseado em aumento de poder de uma máquina, é mais complexo e possui mais limites, e possui o horizontal, baseado em adicionar mais instâncias para compartilhar a carga. Pode utilizar gatilhos, como consumo de CPU/Memória, se ultrapassar o limite estipulado ele automaticamente cria uma outra instância.

**Self-containment**

Quer dizer que a aplicação ou serviço deve ser alto suficiente ou capaz de trabalhar sozinha, sem depender de outras dependências.

### Orientado a Mensagens


**Event-driven communication**

Quando dois ou mais componentes passam mensagem entre eles baseados em algum evento. Evento pode ser adicionar um novo registro, atualização, ou remover.

**Publisher-subscriber**

Pode ser pensado como uma extensão do *event-driven*. Imagine se multíplos componentes querem ler a mensagem? e se o mesmo componente quer ouvir vários tipos de mensagens? Isso é resolvido utilizando o conceito de tópico, podemos pensar em um evento como se fosse um tópico.

**Idempotency**

Quando miramos em *message-driven* e *asynchronous communication*, isso pode trazer alguns desafios. Por exemplo, imagine se uma mensagem duplicada é enviada, isso vai corromper o sistema? o que acontece com o estado daquele registro? Para evitar problemas como adicionar duas vezes a mesma quantia em dinheiro na conta de um cliente por exemplo, podemos utilizar algumas técnicas, como: 
* Colocar Ids únicos nas mensagens, para identificar o evento duplicado.
* Manter o estado anterior e o novo estado na mensagem(assim o sistema bate os dados que ele possui com o eviado na mensagem)
