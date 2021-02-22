import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Games {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random=new Random();

    public static void main(String[] args) {
        System.out.println("В какую игру будем играть? "+ " 1 -Угадай число; "+" 0 -Угадай слово; " );
        int a=scanner.nextInt();
        if (a == 1){
            System.out.println("Ваша задача угадать число");
            int rang = 10;
            int one = 3;
            level(rang,one);

        } else {
            System.out.println("Ваша задача угадать слово: ");
            guessFruit();
        }

    }
    private static void level(int rang, int one) {
        System.out.println("Угадай число от 0 до " + (rang - 1));
        int number = (int) (Math.random() * 10); //загадываем случайное число

        for (int i=0;i<one;i++) {
            int input_number = scanner.nextInt(); //вводим число
            if (input_number == number) {
                System.out.println("Вы угадали! Вы выиграли!");
                break;
            } else {
                if (input_number > number) {
                    System.out.println("Заданное число меньше");
                } else {
                    System.out.println("Загаданное число больше");
                }
            }
        }
        System.out.println("Повторить игру еще раз? " + "1- Да; " + "0- Нет;");
        int povtor = scanner.nextInt();
        if (povtor == 1) {
            level(rang, one);
        } //scanner.nextLine();
    }

    private static void guessFruit(){
        String[] word={"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        //загадаем слово из массива

        int indWord = random.nextInt(word.length - 1); //выбираем случайный индекс массива
        String words = word[indWord]; //присваиваем данному индексу слово
        String maskedGuess=maskWord (words);//дописываем к загаданному слову #
        System.out.println("Я загадал слово, попробуй отгадать его");
        System.out.println("Слова для отгадывания: "+ Arrays.toString(word));

        //инициализируем сканер

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введи свой ответ: (для выхода из игры, просто нажмите Enter)"); //запрашиваем ответ
            String answer = scanner.nextLine(); //ждем ввода слова
            answer=maskWord(answer); //дописываем к ответу #
            if (answer.equals("")) {  //если нам надоест играть то мы выйдем
                break;
            } else {
                if (maskedGuess.equals(answer)) {
                    System.out.println("Вы угадали слово, игра закончена!!!");
                    break;
                }else {
                    String maskedResult="";
                    for (int i=0;i<maskedGuess.length()-1;i++) {
                        if (maskedGuess.charAt(i) == answer.charAt(i)) maskedResult += maskedGuess.charAt(i);// сравниваем загаданное слово с ответом посимвольно
                        else maskedResult += "#"; //если не совпадает ставим #
                    }
                    System.out.println(maskedResult);
                    System.out.println("Вы не угадали. Повторите снова!");
                }
            }

        }
        while (true) ;


    }
    static String maskWord(String s){ //дописываем к слову #
        String mask ="###############";
        for (int i=s.length()-1;i<mask.length()-1;i++){
            s+=mask.charAt(i);
        }
        return s;

    }

}