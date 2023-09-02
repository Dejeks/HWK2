package org.example.Homework.HWException3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }


    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                return;
            }
        }
        System.out.println("Игрушка с ID " + toyId + " не найдена.");
    }

    public Toy drawToy() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        double randomValue = Math.random() * totalWeight;
        double currentWeight = 0;

        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randomValue <= currentWeight) {
                if (toy.getQuantity() > 0) {
                    toy.setQuantity(toy.getQuantity() - 1);
                    return toy;
                } else {
                    System.out.println("Игрушка " + toy.getName() + " закончилась.");
                }
            }
        }
        System.out.println("Не удалось выбрать игрушку.");
        return null;
    }

    // Метод для записи призовой игрушки в файл
    public void writeToPrizeFile(Toy toy, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(toy.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Toy> getToys() {
        return toys;
    }
}
