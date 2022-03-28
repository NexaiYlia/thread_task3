package com.nexai.task3.main;

import com.nexai.task3.entity.Truck;
import com.nexai.task3.parser.TruckParser;
import com.nexai.task3.reader.TruckFileReader;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TruckFileReader fileReader = new TruckFileReader();
        List<String> trucksData = fileReader.readFromTxtFile("D:\\thread_task3\\src\\main\\resources\\data\\trucks.txt");
        TruckParser parser = new TruckParser();
        List<Truck> trucks = parser.parseTruckData(trucksData);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (Truck truck : trucks) {
            executorService.execute(truck);
        }
        executorService.shutdown();
    }
}
