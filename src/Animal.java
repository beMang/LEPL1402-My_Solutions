public class Animal {

    private String name;
    private StringBuilder event_recorder;

    public Animal(String name) {
        this.name = name;
        this.event_recorder = new StringBuilder();
    }

    private Animal() {
        this.name = "Unknown animal";
        this.event_recorder = new StringBuilder();
    }

    public void clearStringBuilder() {
        event_recorder.setLength(0);
    }

    public void addStringToLogger(String toBeAdded) {
        event_recorder.append(toBeAdded+"\n");
    }

    public String logs() {
        return event_recorder.toString();
    }

    public void act(String action) {
        /**
         *   TODO To be implemented
         *   You must create the following string to be added to event_recorder :
         *   "AnimalName is performing the following action: Action"
         *       Example : "Cat is performing the following action: Sleep"
         *   Hint : Use the addStringToLogger method
         **/
        String toAdd = this.name + " is performing the following action: " + action;
        this.addStringToLogger(toAdd);
    }

    public String getName() {
        return this.name;
    }

    public class Cat extends Animal {

        // useful for the actForTestMethod function
        private final String forTestMethod = "Thinking";

        public Cat() {
            // TODO : How can you invoke the Animal constructor from here (with name = "Cat") ?
            super("Cat");
        }

        public void actForTestMethod() {
            // TODO : How could you invoke the parent act method from here with action parameter : the String forTestMethod
            this.act(forTestMethod);
        }

        public class SuperCat extends Cat {

            public void clearLog() {
                /**
                 * TODO : How can you clear the StringBuffer we obtained by inheritance ?
                 * ( Super Heroes like SuperCat want to keep their secret actions private )
                 */
                clearStringBuilder();
            }

        }

    }
}
