import abiturient.Abiturients;
import cats.*;
import fractions.*;
import pointss.*;
import processor.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        System.out.println("ЗАДАНИЕ 1: ДРОБИ\n");
        // 1. Демонстрация дробей
        Fraction f1 = new Fraction(1, 2);
        CachedFraction f2 = new CachedFraction(-3, 4);
        System.out.println("Дроби:");
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);

        // Кэширование
        System.out.println("\nКэширование:");
        System.out.println("Первое значение f1: " + f1.getRealValue());
        System.out.println("Первое значение f2: " + f2.getRealValue()); // вычисляет
        System.out.println("Второе значение f2: " + f2.getRealValue()); // из кеша

        // Изменение
        f2.setNumerator(3);
        System.out.println("\nПосле изменения: f2 = " + f2);
        System.out.println("Новое значение: " + f2.getRealValue());  // вычисляет заново
        System.out.println("Снова: " + f2.getRealValue());  // из кеша


        System.out.println("\nЗАДАНИЕ 2: КОТ\n");
        CatCounter countingCat = new CatCounter("Барсик");

        // Вызываем метод meowsCare из класса Cat
        Cat.meowsCare(countingCat);

        // Получаем количество мяуканий
        System.out.println("Кот мяукал: " + countingCat.getMeowCount() + " раз");


        System.out.println("\nЗАДАНИЕ 3: СПИСКИ");
        // Пример 1: Списки целых чисел
        List<Integer> intList1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> intList2 = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> intResult = ListProcessor.createList(intList1, intList2);

        System.out.println("\n1. Списки целых чисел:");
        ListProcessor.printList("L1", intList1);
        ListProcessor.printList("L2", intList2);
        ListProcessor.printList("Результат", intResult);

        // Пример 2: Списки строк
        List<String> strList1 = Arrays.asList("яблоко", "банан", "апельсин");
        List<String> strList2 = Arrays.asList("банан", "виноград", "киви");
        List<String> strResult = ListProcessor.createList(strList1, strList2);

        System.out.println("\n2. Списки строк:");
        ListProcessor.printList("L1", strList1);
        ListProcessor.printList("L2", strList2);
        ListProcessor.printList("Результат", strResult);


        System.out.println("\n=== ЗАДАНИЕ 4: АБИТУРИЕНТЫ ===");
        try {
            List<String> failed = Abiturients.findFailed("abiturients.txt");
            System.out.println("Не допущены к экзаменам:");
            if (failed.isEmpty()) {
                System.out.println("Таких абитуриентов нет");
            } else {
                for (String name : failed) {
                    System.out.println(name);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }


        System.out.println("\n=== ЗАДАНИЕ 5: СОГЛАСНЫЕ БУКВЫ ===");
        try {
            List<Character> consonants = ConsonantProcessor.findConsonants("text.txt");
            if (consonants.isEmpty()) {
                System.out.println("Таких согласных не найдено");
            } else {
                System.out.println("Звонкие согласные (встречаются более чем в одном слове):");
                for (char c : consonants) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла text.txt");

        }


        System.out.println("=== ЗАДАНИЕ 6: ОБРАТНЫЙ ПОРЯДОК ОЧЕРЕДИ ===");

        Queue<Integer> L = new LinkedList<>();
        L.add(1);
        L.add(2);
        L.add(3);
        L.add(4);
        L.add(5);

        System.out.print("Очередь L: ");
        for (Integer num : L) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("В обратном порядке: ");
        QueueProcessor.printReverse(new LinkedList<>(L));


        System.out.println("=== ЗАДАНИЕ 7: ОБРАБОТКА ТОЧЕК СТРИМОМ ===\n");

        List<pointss.Point> points = Arrays.asList(
                new Point(5, -3),
                new Point(2, 4),
                new Point(5, -3),
                new Point(1, -1)
        );

        Polyline result = StreamProcessor.processPoints(points);
        System.out.println("Результат: " + result);


    }
}