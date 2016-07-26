package aop.client;

import java.util.List;

public class ClientsList implements ElemsList{

    private static List<String> clients;

    public ClientsList(List<String> clients) {
        this.clients = clients;
    }

    public void serveClient(int id) throws IllegalArgumentException{
        if(id < clients.size()){
            System.out.println("serving client: " + clients.get(id));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static String getClientName(int id){
        return id < clients.size() ? clients.get(id) : null;
    }

    public int getClientsNumber(){
        return clients==null?0:clients.size();
    }
}
