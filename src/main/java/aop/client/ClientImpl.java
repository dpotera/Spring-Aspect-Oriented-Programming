package aop.client;

public class ClientImpl implements Client{
    private String name;

    public ClientImpl(String name) {
        this.name = name;
    }

    public void goShopping() {
        System.out.println("Client " + name + " went shopping.");
    }
}
