package second_version.readers;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import second_version.Point;

public interface Reader {
    ArrayList<Point> load() throws FileNotFoundException, URISyntaxException;
}

// todo: implement reading from DB
