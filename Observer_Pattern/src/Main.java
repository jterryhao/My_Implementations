public class Main {

    public static void main(String[] args) {
        Server server = new Server("Hello minions");
        Client Larry = new Client(server, "Larry");
        Client Bird = new Client(server, "Bird");

        server.notifyObservers();

        Larry.detach();
        Bird.detach();
    }
}
