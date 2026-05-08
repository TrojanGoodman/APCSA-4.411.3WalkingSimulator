public class Location {
    // Represents a single square on the map.

    // Private Instance Variables:

    //     - String description: A flavor text description (e.g., "A dusty old library" or "A sun-drenched meadow").
    private String description;
    //     - boolean hasVisited: Tracks if the player has been here.
    private boolean hasVisited;

    // Constructor: Takes a String argument to set the description. hasVisited should default to false.
    public Location(String description) {
        this.description = description;
        this.hasVisited = false;
    }

    // Methods:

    //     - String getDescription(): Returns the description.
    public String getDescription() {
        return description;
    }
    //     - boolean getVisited(): Returns the visited status.
    public boolean getVisited() {
        return hasVisited;
    }
    //     - void setVisited(boolean status): Updates the visited status.
    public void setVisited(boolean status) {
        hasVisited = status;
    }
}