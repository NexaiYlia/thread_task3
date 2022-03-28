package com.nexai.task3.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TruckFileReader {
    private static final Logger log = LogManager.getLogger();
    private static final String DEFAULT_PATH = "resources/data/trucks.txt";

    public List<String> readFromTxtFile(String fileName) {

        Path path;

        if (fileName != null) {
            path = Paths.get(fileName);
            if (Files.exists(path)) {
                try {
                    if (Files.size(path) < 0) {
                        log.info("File \"{}\" is empty. Default file was used.", fileName);
                        path = Paths.get(DEFAULT_PATH);
                    }
                } catch (IOException e) {
                    log.error("error by reading the file {}", fileName, e);
                }
            } else {
                log.info("File \"{}\" doesn't exist. Default file was used.", fileName);
                path = Paths.get(DEFAULT_PATH);
            }
        } else {
            log.info("Inputted filename equals null. Default file was used.");
            path = Paths.get(DEFAULT_PATH);
        }

        List<String> trucksInfo = null;

        try (Stream<String> linesStream = Files.lines(path)) {
            trucksInfo = linesStream.collect(Collectors.toList());
        } catch (IOException e) {
            log.error("error by reading the file {}", fileName, e);
        }

        return trucksInfo;
    }
}
