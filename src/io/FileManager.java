package io;

import GeneralClasses.Universe;

import java.io.*;

public class FileManager {
    public void save(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(Universe.getInstance());
            System.out.printf("Universe successfully saved to file: %s%n", filename);
        } catch (IOException e) {
            System.out.printf("Error while saving universe to file: %s%n", e.getMessage());
        }
    }

    public void load(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Universe loaded = (Universe) in.readObject();

            Universe.getInstance().setPlanets(loaded.getPlanets());

            System.out.printf("Universe successfully loaded from file: %s%n", filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("Error while loading universe from file: %s%n", e.getMessage());
        }
    }
}
