package second_version.readers.impl;

import java.util.ArrayList;
import java.util.Scanner;
import second_version.Point;
import second_version.readers.Reader;

public class ConsoleReader implements Reader {
//    todo: add fool-checks

    @Override
    public ArrayList<Point> load() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<>();

        System.out.println("Enter point in a format: 'x;y', f.e. '25;98'");
        System.out.println("or just type a number and press ENTER");

        for (; ; ) {
            String typedIn = scanner.nextLine();
            if (typedIn.contains(";") && typedIn.matches("\\d+;\\d+")) {
                String[] arr = typedIn.split(";");
                points.add(Point.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
            } else if (!typedIn.contains(";") && typedIn.matches("\\d+")) {
                int x = Integer.parseInt(typedIn);
                System.out.print("OK, what do we have for Y now?  ");
                int y = Integer.parseInt(scanner.nextLine());
                points.add(Point.of(x, y));
            } else if (typedIn.isBlank() || typedIn.isEmpty()) {
                scanner.close();
                break;
            }
        }
        return points;
    }
}
