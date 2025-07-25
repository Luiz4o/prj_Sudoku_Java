# Sudoku em Java (CLI)

> Um jogo de Sudoku clássico totalmente funcional, desenvolvido em Java para ser executado e jogado diretamente no terminal (console).

## 📜 Sobre o Projeto

Este projeto é uma implementação do tradicional jogo de quebra-cabeça Sudoku. A aplicação gera um tabuleiro de Sudoku, apresenta-o ao usuário e permite uma interação completa para a resolução do desafio.

Toda a interação acontece via **CLI (Command Line Interface)**, onde o jogador insere coordenadas e números para preencher o tabuleiro, com o sistema validando cada jogada de acordo com as regras do Sudoku. O jogo termina quando o tabuleiro é preenchido corretamente.

## 🛠️ Ferramentas Iniciais

Para visualizar e compilar o código-fonte deste projeto, você precisará das seguintes ferramentas em seu ambiente de desenvolvimento:

* **Java Development Kit (JDK):** Versão 17 ou superior.
* **Git:** Para clonar o repositório para a sua máquina local.

## ✨ Funcionalidades e Interação

A aplicação é um jogo interativo. Ao ser iniciada, ela oferece as seguintes funcionalidades ao usuário:

* **Visualização do Tabuleiro:** O estado atual do tabuleiro de Sudoku é impresso no console, com os números iniciais já preenchidos.
* **Inserção de Números:** O jogador é solicitado a informar três valores:
    1.  A **linha** (0 a 8) onde deseja jogar.
    2.  A **coluna** (0 a 8) onde deseja jogar.
    3.  O **valor** (1 a 9) que deseja inserir na posição escolhida.
* **Validação de Jogadas:** O sistema verifica automaticamente se o número inserido é válido para a posição escolhida, considerando a linha, a coluna e o bloco 3x3 correspondente.
* **Feedback Instantâneo:** Caso a jogada seja inválida, uma mensagem de erro é exibida, e o jogador pode tentar novamente.
* **Condição de Vitória:** O jogo continua em um loop até que todas as células vazias sejam preenchidas corretamente, momento em que uma mensagem de parabéns é exibida.

## 📁 Estrutura do Projeto

O código-fonte está organizado da seguinte forma:

* `Main.java`: A classe principal que inicia a aplicação e dá início ao jogo.
* `Game.java`: Controla o fluxo principal do jogo (o *game loop*), processa as entradas do usuário e interage com o tabuleiro.
* `Board.java`: Representa o tabuleiro de Sudoku. Contém toda a lógica para gerar o tabuleiro, validar as jogadas, inserir números e verificar se o jogo foi concluído.
* `Space.java`: Modela uma única célula do tabuleiro, guardando seu valor e se ela faz parte do quebra-cabeça inicial ou foi inserida pelo jogador.
