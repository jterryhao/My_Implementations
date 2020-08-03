public class Client extends Observer {

    private Server server;
    private String name, message;

    public Client(Server server, String name) {
        this.server = server;
        this.name = name;
        this.server.attach(this);
    }

    @Override
    void inform() {
        message = server.getMessage();
        System.out.println("Client " + this.name + " got message: " + message);
    }

    @Override
    void detach() {
        this.server.detach(this);
    }
}
