public class Server extends Subject {
    private String message;

    public Server(String message) {
        this.message = message;
    }

    void setMessage(String message) {
        this.message = message;
    }

    String getMessage() {
        return this.message;
    }
}
