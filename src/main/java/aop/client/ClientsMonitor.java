package aop.client;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Aspect
public class ClientsMonitor {

    private Map<Integer,Integer> map = new HashMap<Integer, Integer>();

    @Pointcut("execution(* aop.client.ElemsList.serveClient(int)) && args(clientID)")
    public void clientServed(int clientID){}

    @Before("clientServed(clientID)")
    public void countClientVisits(int clientID){
        if(map.containsKey(clientID)){
            int currentVisits = map.get(clientID);
            map.put(clientID,++currentVisits);
        } else {
            map.put(clientID,1);
        }
    }

    public int getClientVisits(int id){
        return map.containsKey(id) ? map.get(id) : 0;
    }

    public void showClientsVisits(){
        System.out.println("\nClient names with visits number:");
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer,Integer> entry:entries)
            System.out.println(ClientsList.getClientName(entry.getKey())+" : "+entry.getValue());
    }

}
