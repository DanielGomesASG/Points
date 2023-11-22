import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Classe resultado_____________________________________________________________________________________________________

class Result {
    private List<Integer> points;
    private int sum;

    public Result(List<Integer> points, int sum) {
        this.points = points;
        this.sum = sum;
    }

    public List<Integer> getPoints() {
        return points;
    }

    public int getSum() {
        return sum;
    }
}

public class Main {
    // Função principal_________________________________________________________________________________________________
    public static void main(String[] args) {
        /* Imprimindo */
        out();
    }

    // Função para os resultados________________________________________________________________________________________

    private static void out() {
        /* Array padrão aleatório */
        List<Object> randomArr = createRandomArr();

        /* Ou crie abaixo seu array seguindo as normas (Conter: "D", "C", "+" e ao menos um número) */

        List<Object> arr = Arrays.asList(/* Retire este comentário e digite os valores... */);

        /* Imprimindo o array utilizado */
        System.out.println((arr.isEmpty() ? ("//Array Original__________________\n\n" + randomArr + "\n\n")
                : ("Seu Array: " + arr + "\n\n")) + "//Todos os Tratamentos____________\n");

        /* Array */
        Result Result = calcPoints(arr.isEmpty() ? randomArr : arr);

        /* Imprimindo os resultados */
        System.out.println("//Resultados______________________\n\n" + "Valores finais: " + Result.getPoints());
        System.out.println("Soma dos valores: " + Result.getSum());
    }

    // Função para calcular os pontos___________________________________________________________________________________

    private static Result calcPoints(List<Object> ops) {
        /* Array de pontos */
        List<Integer> points = new ArrayList<>();

        /* Percorrendo o array referência */
        for (int op = 0; op < ops.size(); op++) {
            /* Tratando as condições */
            if (ops.get(op) instanceof Number) {
                points.add((Integer) ops.get(op));
            } else if ("C".equals(ops.get(op)) && !points.isEmpty()) {
                points.remove(points.size() - 1);
            } else if ("D".equals(ops.get(op)) && !points.isEmpty()) {
                int z = points.get(points.size() - 1);
                points.add(z * 2);
            } else if ("+".equals(ops.get(op)) && points.size() >= 2) {
                int z = points.get(points.size() - 1);
                int y = points.get(points.size() - 2);
                points.add(y + z);
            }

            /* Imprimindo o array atualizado */
            System.out.println((op + 1) + "º Valor tratado: " + points + "\n");
        }

        /* Retornando a soma dos pontos */
        int sum = points.stream().mapToInt(Integer::intValue).sum();
        return new Result(points, sum);
    }

    // Função para criar um array aleatório contendo "D", "C", "+" e ao menos um número_________________________________

    private static List<Object> createRandomArr() {

        /* Aleatorizando os elementos para o array final */
        Object[] elements = { new Random().nextInt(9) + 1, "D", "C", "+" };

        /* Definindo o tamanho do array e a necessidade de possuir um número */
        List<Object> finalArr = new ArrayList<>();
        finalArr.add(new Random().nextInt(9) + 1);
        int length = new Random().nextInt(9) + 1;

        /* Inserindo os elementos */
        for (int i = 0; i < length; i++) {
            finalArr.add(getRandomElement(elements));
        }

        /* Embaralhando e retornando o array */
        Collections.shuffle(finalArr);
        return finalArr;
    }

    // Função para obter um elemento aleatório__________________________________________________________________________
    private static Object getRandomElement(Object[] elements) {
        int randomIndex = new Random().nextInt(elements.length);
        return elements[randomIndex];
    }
}
