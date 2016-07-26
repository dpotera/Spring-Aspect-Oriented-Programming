package aop.client;

public interface ElemsList {
    void serveClient(int id) throws IllegalArgumentException;
    int getClientsNumber();
}
