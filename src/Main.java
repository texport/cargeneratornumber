import java.util.*;

public class Main
{
    static ArrayList<String> numberList = new ArrayList<>();
    static HashSet<String> numberListHashSet = new HashSet<>();
    static TreeSet<String> numberListTreeSet = new TreeSet<>();

    public static void main(String[] args)
    {
        final String[] carLetters = new String[] {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        String text = " ";

        for (String letter : carLetters)
        {
            for (int figure = 0; figure < 10; figure++)
            {
                for (String letter_2 : carLetters)
                {
                    for (String letter_3 : carLetters)
                    {
                        for (int m = 1; m <= 199; m++)
                        {
                            String numberCar = String.format("%s%d%d%d%s%s%d", letter, figure, figure, figure, letter_2, letter_3, m);
                            numberList.add(numberCar);
                        }
                    }
                }
            }
        }
        System.out.println("В базе всего " + numberList.size() + " автомобильных номеров");

        while (!text.equals("exit"))
        {
            System.out.println("Введите номер авто в формате A123AA123 для поиска, либо напишите exit для выхода:");
            text = getText();

            if (checkCarNumber(text))
            {
                find1(text);
                find2(text);
                find3(text);
                find4(text);
            }
            else
            {
                System.out.println("Номер не соответсвует формату!");
            }
        }
    }

    private static String getText()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static boolean checkCarNumber(String text)
    {
        return text.matches("[А-яа-я]\\d{3}[А-яа-я]{2}\\d{1,3}");
    }

    // Поиск обычным перебором
    private static void find1(String text)
    {
        long start = System.nanoTime();
        long finish;

        if (numberList.contains(text))
        {
            finish = System.nanoTime();
            System.out.println("Поиск перебором: номер " + text + " найден, поиск занял " + (finish - start) + " нс");
        }
        else
        {
            finish = System.nanoTime();
            System.out.println("Поиск перебором: номер " + text + " не найден, поиск занял " + (finish - start) + " нс");
        }
    }

    // Бинарный поиск
    private static void find2(String text)
    {
        Collections.sort(numberList);

        long start = System.nanoTime();
        long finish;

        if (Collections.binarySearch(numberList, text) >=0)
        {
            finish = System.nanoTime();
            System.out.println("Бинарный поиск: номер " + text + " найден, поиск занял " + (finish - start) + " нс");
        }
        else
        {
            finish = System.nanoTime();
            System.out.println("Бинарный поиск: номер " + text + " не найден, поиск занял " + (finish - start) + " нс");
        }
    }

    // Поиск HashSet
    private static void find3(String text)
    {
        numberListHashSet.addAll(numberList);

        long start = System.nanoTime();
        long finish;

        if (numberListHashSet.contains(text))
        {
            finish = System.nanoTime();
            System.out.println("Поиск в HashSet: номер " + text + " найден, поиск занял " + (finish - start) + " нс");
        }
        else
        {
            finish = System.nanoTime();
            System.out.println("Поиск в HashSet: номер " + text + " не найден, поиск занял " + (finish - start) + " нс");
        }
    }

    // Поиск TreeSet
    private static void find4(String text)
    {
        numberListTreeSet.addAll(numberList);

        long start = System.nanoTime();
        long finish;

        if (numberListTreeSet.contains(text))
        {
            finish = System.nanoTime();
            System.out.println("Поиск в TreeSet: номер " + text + " найден, поиск занял " + (finish - start) + " нс");
        }
        else
        {
            finish = System.nanoTime();
            System.out.println("Поиск в TreeSet: номер " + text + " не найден, поиск занял " + (finish - start) + " нс");
        }
    }
}