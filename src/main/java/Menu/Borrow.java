//package Menu;
//
//import Bicycle.Bicycle;
//import Ticket.Ticket;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//import static Menu.Menu.askTypeBike;
//
//public class Borrow {
//    String id = Menu.askId();
//                    for(User usuarito : users){
//        if(usuarito.getId().equals(id)){
//            System.out.println("-----------User in the system Found-------------------");
//            System.out.println("User ID : " + " "+ usuarito.getId() +" User Fullname : "+ usuarito.fullname
//                    +" "+ "User Type :" +usuarito.uType);
//            if (usuarito.hasTicket){
//                System.out.println("The user "+ usuarito.getId()+ "has a ticket with debt.Please cancel it and try again.");
//                break;
//            }
//            System.out.println("Please choose the type of bike:");
//            String typechose = String.valueOf(askTypeBike());
//            System.out.println("type choose" +typechose);
//            int counter = 0;
//            for(Bicycle bicesita : bicies){
//                if (bicesita.getBikeType().equals(typechose) && (bicesita.isAccessible) &&(counter == 0)){
//                    counter++;
//                    System.out.println("Bicycle chosen!" +
//                            "Code: " + bicesita.UniqueCode + "\n" +
//                            "Type: " + bicesita.getBikeType()  + "\n" + "Color:" + bicesita.color);
//
//                    Ticket newTicket = new Ticket("T-001",bicesita,usuarito, LocalDate.now(), LocalTime.of(1,2),LocalTime.of(1,50),true,false,0,"Active");
//                    tickets.add(newTicket);
//                }
//
//
//            }
//            counter = 0;
//
//        }
//    }
//                    System.out.println("A ticket was generated");
//                    for (Ticket ticketcito : tickets){
//        System.out.println("Code: " + ticketcito.code + "\n"+
//                "Bicycle:" +  ticketcito.bicycle.UniqueCode  + "\n"+
//                "User:" + ticketcito.user.id + "\n"+
//                "Name:" + ticketcito.user.fullname + "\n"+
//                "Date" + ticketcito.date + "\n"+
//                "Start time :" + ticketcito.initialHour+ "\n"+
//                "End time " + ticketcito.finishHour + "\n"+
//                "Have helment " + ticketcito.hasHelmet + "\n"+
//                "Good condition : " + ticketcito.hasDamage + "\n"+
//                "Status " + ticketcito.status + "\n"+
//                "Amount " + ticketcito.toPay + "\n"+
//                "");
//        String print = Menu.writeT(ticketcito);
//
//
//    }
//                    System.out.println("--------------");
//
//}
