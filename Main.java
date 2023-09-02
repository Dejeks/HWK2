package org.example.Homework.HWException3;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        Scanner scanner = new Scanner(System.in);

        toyStore.addToy(new Toy(1, "Кукла", 10, 30));
        toyStore.addToy(new Toy(2, "Мяч", 20, 20));
        toyStore.addToy(new Toy(3, "Пазл", 15, 10));

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить игрушку");
            System.out.println("2. Изменить вес игрушки");
            System.out.println("3. Провести розыгрыш");
            System.out.println("4. Вывести все игрушки");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем перевод строки после числа

            switch (choice) {
                case 1:
                    System.out.println("Введите ID игрушки:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Считываем перевод строки после числа

                    System.out.println("Введите название игрушки:");
                    String name = scanner.nextLine();

                    System.out.println("Введите количество игрушек:");
                    int quantity = scanner.nextInt();

                    System.out.println("Введите вес игрушки (в % от 100):");
                    double weight = scanner.nextDouble();

                    toyStore.addToy(new Toy(id, name, quantity, weight));
                    break;
                case 2:
                    System.out.println("Введите ID игрушки, для которой нужно изменить вес:");
                    int toyId = scanner.nextInt();
                    scanner.nextLine(); // Считываем перевод строки после числа

                    System.out.println("Введите новый вес игрушки (в % от 100):");
                    double newWeight = scanner.nextDouble();

                    toyStore.updateWeight(toyId, newWeight);
                    break;
                case 3:
                    Toy prizeToy = toyStore.drawToy();
                    if (prizeToy != null) {
                        toyStore.writeToPrizeFile(prizeToy, "prize.txt");
                        System.out.println("Призовая игрушка: " + prizeToy.getName() + " записана в файл.");
                    }
                    break;
                case 4:
                    System.out.println("Список всех игрушек:");
                    for (Toy toy : toyStore.getToys()) {
                        System.out.println(toy.toString());
                    }
                    break;
                case 5:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
