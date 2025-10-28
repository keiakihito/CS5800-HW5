package flyweight;

/*
 * Fall 2025 CS 5800 Homework 5 Part 1
 * Flyweight Pattern
 * Author: Keita Katsumi
 */

public class Driver {
    public static void main(String[] args) {
        // Index legend used by CharacterStyleFactory:
        // fontIndex: 0=Arial, 1=Calibri, 2=Verdana
        // colorIndex: 0=Red, 1=Blue, 2=Black
        // sizeIndex: 0=12pt, 1=14pt, 2=16pt

        StyledString text = new StyledString();
        char[] message = "HelloWorldCS5800".toCharArray();

        int[] fontIndexes =  {0, 0, 1, 1, 2, 2, 0, 0, 1, 1, 2, 2, 0, 0, 1, 1};
        int[] colorIndexes = {0, 1, 0, 1, 2, 0, 2, 1, 0, 1, 2, 0, 1, 2, 1, 0};
        int[] sizeIndexes =  {0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 0};

        for (int i = 0; i < message.length; i++) {
            text.append(message[i], fontIndexes[i], colorIndexes[i], sizeIndexes[i]);
        }

        System.out.println("Styled output for \"HelloWorldCS5800\":");
        int position = 0;
        for (String line : text.printStyles()) {
            System.out.printf("%02d: %s%n", position++, line);
        }
    }
}

/*
Sample Run:
❯   mvn exec:java -Dexec.mainClass=flyweight.Driver
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------------< com.calpoly:flyweight >------------------------
[INFO] Building Flyweight Pattern - Text Editor 1.0.0
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec:3.6.1:java (default-cli) @ flyweight ---
Styled output for "HelloWorldCS5800":
00: H -> Arial, Red, 12pt
01: e -> Arial, Blue, 14pt
02: l -> Calibri, Red, 16pt
03: l -> Calibri, Blue, 12pt
04: o -> Verdana, Black, 14pt
05: W -> Verdana, Red, 16pt
06: o -> Arial, Black, 12pt
07: r -> Arial, Blue, 14pt
08: l -> Calibri, Red, 16pt
09: d -> Calibri, Blue, 12pt
10: C -> Verdana, Black, 14pt
11: S -> Verdana, Red, 16pt
12: 5 -> Arial, Blue, 12pt
13: 8 -> Arial, Black, 14pt
14: 0 -> Calibri, Blue, 16pt
15: 0 -> Calibri, Red, 12pt
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.300 s
[INFO] Finished at: 2025-10-28T05:59:02-07:00
[INFO] ------------------------------------------------------------------------
 * 
 */