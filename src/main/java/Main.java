import model.Board;
import model.Space;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private static Board board;
    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) {
        final var positions = Stream.of(args)
                .collect(Collectors.toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]
                ));
        var option = -1;
        while(true){
            System.out.println("Selecione uma das opções a seguir");
            System.out.println("1 - Iniciar um novo Jogo");
            System.out.println("2 - Colocar um novo número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");

            option = scanner.nextInt();

            switch (option){
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opcao invalida, Tente novamente!");

            }

        }
    }

    private static void startGame(Map<String, String> positions) {
        if(Objects.nonNull(board)){
            System.out.println("Jogo já foi iniciado");
        }

        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                var positionConfig = positions.get("%s,%s".formatted(i, j));
                var expected = Integer.parseInt(positionConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                var currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }

        }

        board = new Board(spaces);
        System.out.println("O jogo está pronto e irá começar");
    }

    private static void inputNumber() {
        if(Objects.isNull(board)){
            System.out.println("Jogo ainda não iniciado");
        }

        System.out.println("Informe a coluna que deseja por o número: ");
        var col = runUntilGetValidNumber(0,8);
        System.out.println("Informe a linha que deseja por o número: ");
        var row = runUntilGetValidNumber(0,8);
        System.out.printf("Informe o número que deseja por em [%s ,%s]\n",col,row);
        var value = runUntilGetValidNumber(1,9);

        if(!board.changeValue(col,row,value)){
            System.out.printf("A posição [%s ,%s] tem um valor fixo\n",col,row);
        }
    }

    private static void removeNumber() {
        if(Objects.isNull(board)){
            System.out.println("Jogo ainda não iniciado");
        }

        System.out.println("Informe a coluna que deseja por o número: ");
        var col = runUntilGetValidNumber(0,8);
        System.out.println("Informe a linha que deseja por o número: ");
        var row = runUntilGetValidNumber(0,8);

        if(!board.clearValue(col,row)){
            System.out.printf("A posição [%s ,%s] tem um valor fixo\n",col,row);
        }
    }


    private static void showCurrentGame() {
    }

    private static void showGameStatus() {
    }

    private static void clearGame() {
    }

    private static void finishGame() {
    }

    private static int runUntilGetValidNumber(final int min, final int max){
        try {
            var current = scanner.nextInt();
            while (current < min || current > max) {
                System.out.printf("Informe um número entre %s e %s\n", min, max);
                current = scanner.nextInt();
            }
            return current;

        }catch (InputMismatchException ex){
            System.out.printf("O valor informado não condiz com o esperado, Informe um número entre %s e %s\n", min, max);
            return runUntilGetValidNumber(min,max);
        }
    }
}
