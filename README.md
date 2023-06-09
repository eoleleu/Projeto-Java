# 🕹️ Projeto MC322 ~ NoCity
### 💻 [UNICAMP][1S2023] MC322 • Programação Orientada a Objetos

#

### 🧑‍🤝‍🧑 Autores

224538 ∷ Artur de Miranda Rodrigues  
213437 ∷ Leandro Henrique Silva Resende  
231718 ∷ Vitor Rodrigues Zanata Da Silva

#
### 📋 Diagrama UML: https://app.diagrams.net/#G1nXsmcUysOQQRqp3Z4IqRhQbYRoFes2ou  (presente também em arquivo .png no mesmo diretório do readme)
#


### Os arquivos das classes estão em "src", AppMain está no pacote "ClassesJogo".


### 🗒️ Descrição do Projeto
#### 1 - Conceitualização
O jogo desenvolvido tem como bases os gêneros "clicker" e "idle" e assemelha-se a um "simulador de cidade". Em essência, o jogador deve comprar casas, parques, hospitais e outras construções a fim de manter sua cidade ativa e rentável, de forma também a equilibrar suas estatísticas. Essas serão chamadas de "ClassesJogo.Stats", compostas por "População", "Felicidade" e "Infraestrutura". Caso o jogador falhe nesse equilíbrio, perde o jogo.

Outros recursos do jogo são: uma GUI interativa, recurso de salvar e de continuar um jogo prévio, tratamento de erros do usuário, entre outros.


#### 2 - Core mechanics

Aqui serão descritos os elementos principais do jogo:
- Dinheiro do jogador, o qual cresce em taxa constante por segundo, podendo essa taxa ser aumentada se o usuário comprar lojas ou indústrias;
- Infraestrutura e Felicidade da cidade decrescem em taxa constante por segundo, para que o jogador não perca é necessária a compra de parques e hospitais e delegacias, os quais aumentam as taxas de felicidade e infraestrutura, respectivamente.
- População da cidade aumenta em taxa constante por segundo, assim é necessário que o usuário compre casas/prédios para receber essa nova população e, portanto impedindo-a de "estourar".
- Construções que forem compradas, podem ter suas capacidade ampliadas ou receberem uma "upgrade" (i.e. uma casa pode ser transformada em um prédio);
- Salvamento e carregamento de sessões de jogo;

#### 3 - Ideias da estrutura da base do programa

- "Construcao" será classe **interface**, determinando características comuns às das construções do jogo
- Classes como "Habitavel" serão pais **abstratos** dos tipos diferentes de contrução do mesmo nicho, como nesse caso, "Habitavel" é pai de "Casa" e "Predio".
- A classe "ClassesJogo.Cidade" representa a sessão de jogo atual, como ClassesJogo.Stats, taxas de aumento/decréscimo, poupança etc. Ela será também uma **agregação** dos diferentes tipos de construção. Será ela o "arquivo" a ser salvo para continuar o jogo.
- A classe "AppMain" estará encarregada de instanciar algumas das ClassesGUI como "InicioFrame", "TelaJogoFrame" e "GameOverFrame". Essas são as classes responsáveis por gerenciar os elementos da GUI e associa-los a métodos nas ClassesJogo.Cidade e classesJogo.Stats.

#### 4 - Resumo do funcionamento geral
- Main lida com "InicioFrame", o qual instancia "InicioPanel"  iniciando o programa e a GUI, após o usuário iniciar um novo jogo ou carregar um salvo, a Main Intancia o TelaJogoPanel, o qual instancia MenuLateralPanel, MenuSuperiorPanel e TelaJogoPanel (todos por agregação).
- O andamento será gerenciado pelos Triggers programados por Swing e Timers.
- O backend é armazenado e executado por ClassesJogo.Cidade
- Classes adicionais podem ser criadas como auxiliares.
- Erros/exceções como "Comprar algo sem ter dinheiro", "Carregar um jogo inexistente" ou em situações de gameOver (i.e. quando a felicidade/infraestrutram zeram ou a população explode) são tratados corretamente.


#

### 📔 A Disciplina

No início da disciplina MC322 (Programação Orientada a Objetos) da Unicamp, os alunos são introduzidos aos paradigmas de programação, que são diferentes abordagens para resolver problemas utilizando código. Eles exploram os conceitos de programação imperativa, orientada a objetos e funcional, entendendo as características distintas de cada um.

Além disso, os alunos são apresentados ao versionamento de projetos, que é o controle de versões do código-fonte ao longo do tempo. Eles aprendem a utilizar ferramentas populares, como Git, para gerenciar alterações, rastrear problemas e colaborar de forma eficiente em projetos de programação.

A abstração de dados é um conceito crucial, onde os alunos aprendem a representar informações do mundo real por meio de objetos, classes e tipos. Eles exploram como encapsular dados e comportamentos relacionados em objetos, definindo classes que atuam como modelos para criar instâncias.

Os alunos também são introduzidos às propriedades e estados dos objetos, entendendo como os objetos podem ter atributos que representam seu estado atual. Eles aprendem sobre métodos e mensagens, que são ações que os objetos podem executar e como a sobrecarga de métodos permite a existência de várias implementações para um mesmo método, mas com diferentes parâmetros.

O conceito de herança é explorado, tanto em herança simples como em herança múltipla, permitindo que os alunos compreendam como uma classe pode herdar atributos e comportamentos de uma classe pai. Eles também aprendem sobre hierarquias de generalização/especialização, onde classes mais específicas podem ser derivadas de classes mais gerais.

A compreensão de relacionamentos entre objetos é fundamental, e os alunos estudam associação, agregação e composição. Eles aprendem como os objetos podem se relacionar entre si, seja através de associações simples, composições mais fortes ou agregações mais fracas.

Os conceitos de sobrescrita, polimorfismo e alocação dinâmica são abordados para ensinar aos alunos a capacidade de substituir métodos em classes derivadas, a capacidade de usar uma mesma interface para diferentes tipos de objetos e como a alocação dinâmica permite a criação de objetos em tempo de execução.

Classes abstratas são introduzidas como classes que não podem ser instanciadas diretamente, mas fornecem uma base para outras classes derivadas. Os alunos aprendem a utilizar classes abstratas como modelos para criar hierarquias mais específicas de classes.

Por fim, as interfaces são discutidas como contratos que definem um conjunto de métodos que uma classe deve implementar. Os alunos aprendem a criar interfaces para garantir que diferentes classes possam fornecer implementações consistentes para funcionalidades específicas.

Ao final do semestre, espera-se que os alunos tenham uma compreensão sólida desses conceitos e estejam aptos a aplicá-los na resolução de problemas de programação utilizando diferentes paradigmas.
