import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Map {
    // This class handles the "geography" of the game and manages a grid of Location objects.

    // Private Instance Variable:

    //     - Location[][] grid: A 2D array of Location objects.
    private Location[][] grid;
    // Constructor requires two parameters: numberRows, numberColumns
    public Map(int numberRows, int numberColumns) throws FileNotFoundException {
        grid = new Location[numberRows][numberColumns];

    //     - Initialize the Location[][] with numberRows and numberColumns.
    Location[][] map = new Location[numberRows][numberColumns];
    //     - Create a Scanner object that wraps a File object. For example... new Scanner(new File("locationStrings.txt"))
    Scanner fileScan = new Scanner(new File("src/locationStrings.txt"));
    //     - Use a nested for loop to instantiate a new Location(description) for every single index in the array. If you don't, your map will be full of null values
        for (int row = 0; row < numberRows; row++) {
            for (int col = 0; col < numberColumns; col++) {
                if (fileScan.hasNextLine()) {
                    grid[row][col] = new Location(fileScan.nextLine());
                } else {
                    grid[row][col] = new Location("none");
                }
            }
        }
        fileScan.close();
    }

    //         - Inside the loops, check if the file has another line using hasNextLine().
    //         - Assign grid[r][c] = new Location(fileScanner.nextLine());.

    // Methods:

    //     - int getRemaining(): Loop through the Location objects and count how many have getVisited() == false.
    public int getRemaining() {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (!grid[row][col].getVisited()) {
                    count++;
                }
            }
        }
        return count;
    }
    //     - int getTotalRows(): Returns the total amount of rows in grid
    public int getTotalRows() {
        return grid.length;
    }
    //     - int getTotalCols(): Returns the total amount of cols in grid
    public int getTotalCols() {
        return grid[0].length;
    }
    //     - boolean isValid(int r, int c): Returns true if r is in range 0...getTotalRows()-1 and c is in range 0...getTotalCols()-1 and grid[r][c] != null
    public boolean isValid(int r, int c) {
        if (r >= 0 && r < getTotalRows() && c >= 0 && c < getTotalCols() && grid[r][c] != null) {
            return true;
        } else {
            return false;
        }
    }
    //     - Location getLocation(int r, int c): Returns the Location object at those coordinates if isValid(r,c). Otherwise, returns null.
    public Location getLocation(int r, int c) {
        if (isValid(r, c)) {
            return grid[r][c];
        } else {
            return null;
        }
    }
}
