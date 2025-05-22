package Model;

import java.io.IOException;

// Interface that defines saving and loading methods for any object
public interface Storable {
    void saveToFile(String filepath) throws IOException;
    void loadFromFile(String filepath) throws IOException;
}