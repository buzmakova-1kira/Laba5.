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
        Fraction f2 = new Fraction(-3, 4);
        System.out.println("Дроби:");
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        // Кэширование
        System.out.println("\nКэширование:");
        System.out.println("Первое значение f1: " + f1.getRealValue());
        System.out.println("Второе значение f2: " + f2.getRealValue());
        // Изменение
        f1.setNumerator(3);
        System.out.println("\nПосле изменения: f1 = " + f1);
        System.out.println("Новое значение: " + f1.getRealValue());


        System.out.println("\nЗАДАНИЕ 2: КОТ\n");
        Cat cat = new Cat("Мурзик");
        Cat.meowsCare(cat);
        System.out.println("кот мяукал " + cat.getMeowCount() + " раз");


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
            List<String> failed = AbiturientProcessor.findFailed("abiturients.txt");
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

        // Создаем список точек
        List<Point> points = Arrays.asList(
                new Point(3, 5),
                new Point(1, 2),
                new Point(3, 5),
                new Point(5, -3),
                new Point(2, 7),
                new Point(1, 2),
                new Point(4, -1)
        );

        System.out.println("Исходные точки:");
        points.forEach(p -> System.out.print(p + " "));
        System.out.println("\n");

        // Обрабатываем стримом
        Polyline polyline = StreamProcessor.processPoints(points);

        System.out.println("Результат (ломаная):");
        System.out.println(polyline);

    }
}