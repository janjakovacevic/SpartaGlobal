import service.ActorDAO;

public class App {
    public static void main(String[] args) {
        ActorDAO actorDAO = new ActorDAO();
        System.out.println(actorDAO.findActorByID(1));
    }
}
