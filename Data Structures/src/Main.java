public class Main {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("what up");
        System.out.println(stack.top());
        stack.push("y'all");
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());


    }
}
