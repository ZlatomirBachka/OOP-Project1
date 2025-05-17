package cli;

import GeneralClasses.Rank;
import UniverseManager.*;
import io.FileManager;
import util.PlanetChecker;

import java.util.Scanner;

public class CLI {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Jedi Universe CLI. Type your command: ");
        while (true) {
            System.out.println("> ");
            String command = scanner.nextLine().trim();
            if (command.equals("exit")) break;

            processCommand(command);
        }
    }

    private void processCommand(String command) {
        String[] parts = command.split(" ");
        String commandName = parts[0];

        switch (commandName) {
            case "add_planet":
                if (parts. length != 2) {
                    System.out.println("Usage: add_planet <planet_name>");
                    break;
                }
                new PlanetAdder().add_planet(parts[1]);
                break;
            case "create_jedi":
                if (parts. length != 7) {
                    System.out.println("Usage: create_jedi <planet_name> <jedi_name> <jedi_rank> <jedi_age> <saber_color> <jedi_strength>");
                    break;
                }
                try {
                    String planetName = parts[1];
                    String jediName = parts[2];
                    Rank rank = Rank.valueOf(parts[3].toUpperCase());
                    short age = Short.parseShort(parts[4]);
                    String color = parts[5];
                    float strength = Float.parseFloat(parts[6]);
                new JediCreator().create_jedi(planetName, jediName, rank, age, color, strength);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
                break;

            case "remove_jedi":
                if (parts. length != 3) {
                    System.out.println("Usage: remove_jedi <jedi_name> <planet_name>");
                    break;
                }
                new JediRemover().removeJedi(parts[1], parts[2]);
                break;

                case "promote_jedi":
                    if (parts. length != 3) {
                        System.out.println("Usage: promote_jedi <jedi_name> <multiplier>");
                        break;
                    }
                    try {
                        float multiplier = Float.parseFloat(parts[2]);
                        new JediPromoter().promote_jedi(parts[1], multiplier);
                    } catch (Exception e) {
                        System.out.println("Invalid multiplier.");
                    }
                    break;

                    case "demote_jedi":
                        if (parts. length != 3) {
                            System.out.println("Usage: demote_jedi <jedi_name> <multiplier>");
                            break;
                        }
                        try {
                            double multiplier = Double.parseDouble(parts[2]);
                            new JediDemoter().demote_jedi(parts[1], multiplier);
                        } catch (Exception e) {
                            System.out.println("Invalid multiplier.");
                        }
                        break;

                        case "get_strongest_jedi":
                            if (parts. length != 2) {
                                System.out.println("Usage: get_strongest_jedi <planet_name>");
                                break;
                            }
                            new StrongestJedi().get_strongest_jedi(parts[1]);
                            break;

                            case "get_youngest_jedi":
                                if (parts. length != 3) {
                                    System.out.println("Usage: get_youngest_jedi <planet_name> <rank>");
                                    break;
                                }
                                try {
                                    Rank rank = Rank.valueOf(parts[2].toUpperCase());
                                    new YoungestJedi().get_youngest_jedi(parts[1], rank);
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Invalid rank");
                                }
                                break;

                                case "get_most_used_saber_color":
                                    if (parts. length == 2) {
                                        new MostUsedSaberColor().getMostUsedSaberColor(parts[1]);
                                    } else if (parts. length == 3) {
                                        try {
                                            Rank rank = Rank.valueOf(parts[2].toUpperCase());
                                            new MostUsedSaberColor().getMostUsedSaberColor(parts[1], rank);
                                        } catch (IllegalArgumentException e) {
                                            System.out.println("Invalid rank.");
                                        }
                                    } else {
                                        System.out.println("Usage: get_most_used_saber_color <planet_name> [<rank>]");
                                    }
                                    break;

            case "print":
                if (parts. length != 2) {
                    System.out.println("Usage: print <planet_name> OR print <jedi_name>");
                    break;
                }
                if (PlanetChecker.validateAndGet(parts[1]) != null) {
                    new PlanetPrinter().printJediFromPlanet(parts[1]);
                } else {
                    new JediInfoPrinter().printJediInfo(parts[1]);
                }
                break;

            case "save":
                if (parts. length != 2) {
                    System.out.println("Usage: save <file_name>");
                    break;
                }
                new FileManager().save(parts[1]);
                break;
                case "load":
                    if (parts. length != 2) {
                        System.out.println("Usage: load <file_name>");
                        break;
                    }
                    new FileManager().load(parts[1]);
                    break;

                    default:
                        if (command.contains("+")) {
                            String[] plusParts = command.split("\\+");
                            if (plusParts.length == 2) {
                                String planet1 = plusParts[0].trim();
                                String planet2 = plusParts[1].trim();
                                new TwoPlanetsInfo().printJedisFromThePlanets(planet1, planet2);
                            } else {
                                System.out.println("Usage: <planet_name> + <planet_name>");
                            }
                        } else {
                            System.out.println("Unknown command: " + command);
                        }
                        break;
        }
    }
}
