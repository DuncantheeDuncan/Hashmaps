package co.projectcodex.hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

enum Langs {
    zulu("Saw'bona"),
    xhosa("Molo"),
    english("Hello"),
    sotho("Dumela");


    private String greeting;

//
    Langs(String greeting) {
        this.greeting = greeting;

    }
    public String getGreeting() {

        return greeting;
    }
}

class Greetnames {

    Map<Langs, Integer> howmanygreetedMap = new HashMap<Langs, Integer>();

    public void greet(Langs language) {
       // howmanygreetedMap.put();

        if (!howmanygreetedMap.containsKey(language)) {
            howmanygreetedMap.put(language, 0);
        }
        // increment the counter for this type of Langs!!
        int userCounter = howmanygreetedMap.get(language);
        userCounter++;
        howmanygreetedMap.put(language, userCounter);
//        System.out.println(language+ " testing");
    }

    public int totalnamesGreeeted() {
        // return howmanygreetedMap.keySet().size();
        int totalnamesGreeeted = 0;

        for (Integer nameCount : howmanygreetedMap.values()) {
            totalnamesGreeeted += nameCount;
        }

        return totalnamesGreeeted;
    }

    public int totalnamesGreeeted(Langs name) {
        if (!howmanygreetedMap.containsKey(name)) {
            return 0;
        }
        return howmanygreetedMap.get(name);
    }

    public void clear() {
        howmanygreetedMap.clear();
    }

    public void clear(Langs langs) {/// changed it to lower case
        howmanygreetedMap.put(langs, 0);
    }


}

public class GreetAPerson {


    public static void main(String[] args) {


        Greetnames Greetnames = new Greetnames();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Waiting for a command ");// Langs = pet
            String commands = scanner.nextLine();

            if ("exit".equals(commands)) {
                break;
            }

            String[] commandArray = commands.trim().split(" ");

            if (commandArray.length > 1) {
                String command = commandArray[0].trim();
                String languageType = commandArray[1].toLowerCase();
                try {
                    Langs name = Langs.valueOf(languageType);
                    if ("greet".equals(command)) {

                        System.out.println("Yohe greated" + name);
                        Greetnames.greet(name);

                    } else if ("greeted".equals(command)) {

                        Integer nameCount = Greetnames.totalnamesGreeeted(name);
                        System.out.println(nameCount + " " + name + "'s has been greeted.");

                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Language : " + languageType);
                }
            }


        }


//        Greetnames.greet(Langs.cat);
//        Greetnames.greet(Langs.dog);
//        Greetnames.greet(Langs.dog);
//        Greetnames.greet(Langs.ferret);
//        Greetnames.greet(Langs.cat);
//        Greetnames.greet(Langs.cat);
//        Greetnames.greet(Langs.cat);
//        Greetnames.greet(Langs.rabbit);
//        Greetnames.greet(Langs.parrot);
//        Greetnames.greet(Langs.cat);
//        Greetnames.greet(Langs.goldfish);
//        Greetnames.greet(Langs.ferret);


//        System.out.println("I have spotted so many Langss: " + Greetnames.totalnamesGreeeted());
//        System.out.println("I have spotted so many cats: " + Greetnames.totalnamesGreeeted(Langs.cat));
//        System.out.println("I have spotted so many ferrets: " + Greetnames.totalnamesGreeeted(Langs.ferret));
//        System.out.println("I have spotted so many goldfish: " + Greetnames.totalnamesGreeeted(Langs.goldfish));


//        Map<String, Integer> userGreetCounter = new HashMap<String, Integer>();
//
//        userGreetCounter.put("Phumlani", 2);
//        System.out.println(userGreetCounter);
//
//        userGreetCounter.put("Phumlani", 1);
//        System.out.println(userGreetCounter);
//
//        userGreetCounter.put("Phumlani", 7);
//        System.out.println(userGreetCounter);
//
//        userGreetCounter.put("Langser", 7);
//
//        userGreetCounter.clear();
//        userGreetCounter = null;
//        System.out.println(userGreetCounter);



    }
}
