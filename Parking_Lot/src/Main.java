import Controllers.TicketController;
import Services.TicketService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ObjectContainer objectContainer= new ObjectContainer();
        TicketService ticketService= new TicketService();

        objectContainer.register("ticketService",ticketService);
        TicketController ticketController= new TicketController((TicketService)objectContainer.get("ticketService"));




        }
    }
