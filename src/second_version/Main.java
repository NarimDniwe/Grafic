package second_version;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import second_version.readers.Reader;
import second_version.readers.impl.ConsoleReader;
import second_version.readers.impl.FileReader;

public class Main {
//    todo: - implement choosing the import way
//          - add export data to file
//          - add export a picture to file
//          - add another panel for buttons: 'add'(new point ofc), 'export', 'import'

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        CanvasPanel canvas = new CanvasPanel();

////////////// 1st way of loading data ///////////////////////////////////////////////////
//        ArrayList<Point> testList = new ArrayList<>(List.of(
//            new Point(70, 50 + 15),
//            new Point(90, 50 + 55 ),
//            new Point(110, 50 + 10),
//            new Point(130, 50 + 100),
//            new Point(150, 50 + 250))
//        );
//        CanvasPanel canvas = new CanvasPanel(testList);
///////////////////////////////////////////////////////////////////////////////////////////


////////////// 2nd way of loading data ///////////////////////////////////////////////////
//        Reader consoleReader = new ConsoleReader();
//        canvas.loadData(consoleReader);
//////////////////////////////////////////////////////////////////////////////////////////


////////////// 3rd way of loading data ///////////////////////////////////////////////////
        Reader fileReader = new FileReader();
        canvas.loadData(fileReader);
//////////////////////////////////////////////////////////////////////////////////////////

        frame.add(canvas);
        frame.setVisible(true);
    }
}