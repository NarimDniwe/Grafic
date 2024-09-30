package second_version.readers.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;
import second_version.Point;
import second_version.readers.Reader;

public class FileReader implements Reader {
//    todo: - handle exceptions in try-catch-finally blocks
//          - allow user to choose a file

    @Override
    public ArrayList<Point> load() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/second_version/testData.txt"));
        ArrayList<Point> points = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] arr = line.split(";");
            points.add(Point.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
        }

        return points;
    }
}
