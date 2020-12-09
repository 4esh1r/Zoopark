import Animal.*;

import java.util.ArrayList;
import java.util.Scanner;

    public class AnimalAccount {
        static ArrayList<Animal> animalList = new ArrayList<Animal>();
        static Scanner scanner = new Scanner(System.in);

        private static void addAnimal() {
            System.out.println("1 - Line\n" +
                    "2 - Panther\n" +
                    "3 - Snake\n" +
                    "4 - Wolf\n" );
            int num;
            num = scanner.nextInt();
            String name;
            int age;
            int weight;
            int aviaryNumber;
            int timeSpentInTheZoo;
            System.out.println("Имя животинки?");
            name = scanner.next();
            System.out.println("Сколько годиков животному?");
            age = scanner.nextInt();
            System.out.println("Сколько килограмчиков весит  любимец?");
            weight = scanner.nextInt();
            System.out.println("Каков номер любимца? ");
            aviaryNumber = scanner.nextInt();
            System.out.println("Как давно он чалиться? ");
            timeSpentInTheZoo = scanner.nextInt();
            switch (num) {
                case 1: {
                    boolean mane;
                    System.out.println("Грива есть?");
                    mane = scanner.nextBoolean();
                    animalList.add(new Line("line", name, age, weight, aviaryNumber, timeSpentInTheZoo, mane));
                }
                break;
                case 2: {
                    String color;
                    System.out.println("Какой цвет ?");
                    color = scanner.next();
                    animalList.add(new Panther("panther", name, age, weight, aviaryNumber, timeSpentInTheZoo, color));
                }
                break;
                case 3: {
                    int length;
                    String color;
                    System.out.println("Какая длина?");
                    length = scanner.nextInt();
                    System.out.println("Какой цвет?");
                    color = scanner.next();
                    animalList.add(new Snake("Snake", name, age, weight, aviaryNumber, timeSpentInTheZoo, length, color));
                }
                break;
                case 4: {
                    animalList.add(new Wolf("wolf", name, age, weight, aviaryNumber, timeSpentInTheZoo));
                }

                default: {
                    System.out.println("Error");
                }
            }
        }

        private static void showAnimals() {
            for (Animal animal : animalList) {
                System.out.println(animal.getName() + "(" + animal.getType() + ")");
            }
        }

        private static void deleteAnimal() {
            System.out.println("Введите имя");
            String name;
            name = scanner.next();
            for (int i = 0; i < animalList.size(); i++) {
                if (animalList.get(i).getName().equals(name)) {
                    animalList.remove(i);
                    return;
                }
            }
            System.out.println("Животинка сбежала или её просто нету)");
        }

        private static void addingFoodExpenses() {
            System.out.println("Введите имя?");
            String name;
            name = scanner.next();
            for (Animal animal : animalList) {
                if (animal.getName().equals(name)) {
                    System.out.println("Как сильно вы покормили животинку?");
                    int expenses;
                    expenses = scanner.nextInt();
                    animal.setFoodExpensesForTheCurrentDay(expenses);
                    animal.setFoodExpensesForAllTime(animal.getFoodExpensesForAllTime() + expenses);
                    return;
                }
            }
            System.out.println("Животинка сбежала или её просто нету)");
        }

        private static int calculationFoodExpensesCurrentDay() {
            int expenses = 0;
            for (Animal animal : animalList) {
                expenses += animal.getFoodExpensesForTheCurrentDay();
            }
            return expenses;
        }

        private static int calculationFoodExpensesAllTime() {
            int expenses = 0;
            for (Animal animal : animalList) {
                expenses += animal.getFoodExpensesForAllTime();
            }
            return expenses;
        }

        public static void menu() {
            int menu;
            do {
                System.out.println("1 - Добавить любимца в зоопарк\n" +
                        "2 - Показать всех кто чалиться \n" +
                        "3 - Наконец животное получить свободу!\n" +
                        "4 - Добавить отчёт о коомежке любимца\n" +
                        "5 - Сколлько корма ушло сегодня на всех сидяших?\n" +
                        "6 - Сколько корма ушло за всё время на этих любимцов");
                menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        addAnimal();
                        break;
                    case 2:
                        showAnimals();
                        break;
                    case 3:
                        deleteAnimal();
                        break;
                    case 4:
                        addingFoodExpenses();
                        break;
                    case 5:
                        System.out.println(calculationFoodExpensesCurrentDay());
                        break;
                    case 6:
                        System.out.println(calculationFoodExpensesAllTime());
                        break;
                }
            } while (menu != 0);
        }
    }

