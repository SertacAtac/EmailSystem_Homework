/*************************************/
/*                                   */
/*        This file introduces       */
/*            Linked Lists           */
/*      for the mail application.    */ 
/*            30.10.2024             */
/*                                   */
/*************************************/

import java.util.LinkedList;

public class ListOfEmails {
    
    private LinkedList<Email> emails;
    public boolean specialPrint = false;

    /* Class Constructor */
    public ListOfEmails() {
        emails = new LinkedList<>();
    }

    /***************/
    /*             */
    /*   Methods   */
    /*             */
    /***************/


    /* Email adder */
    public void addEmail(Email ex) {
        emails.add(ex);
    }

    /* Email create & inserter */
    public void createNewEmail(String subject, int id, String message, Long time, String newLoc) {
        Email createdEmail = new Email(subject, id, message, time);
        createdEmail.setLocation(newLoc);
        emails.add(createdEmail);
    }

    /* Email reader */
    public void read(int id) {
        for (Email email : emails) {
            if (email.getId() == id) {
                System.out.println(email.showDetails());
                email.markAsRead(); 
                return;
            }
        }
        System.out.println("No email found with ID: " + id);
    }

    /* Email deleter for list*/
    public void delete(int id) {
        boolean isEmailDeleted = false;
        for (Email email : emails) {
            if (email.getId() == id) {
                emails.remove(email);
                isEmailDeleted = true;
            }
        }
        if(!isEmailDeleted) {
            System.out.println("No email found with ID: " + id);
        }
    }

    /* Detail printer for email lists */
    public void showAll(boolean flag) {
        for(Email email : emails) {
            if(flag) {
                email.showDetails();
            } else {
                if(!email.isRead) {
                    email.showDetails();
                }
            }
        }
    }

    /* Special formatted printer */
    public void specialPrinter() {
        if(specialPrint) {
            System.out.println("Email     Subject              Message                                  Time          Read");
            for(Email email : emails) {
                if(!email.isRead) {
                    System.out.printf("%-10d%-20s%-40s%d    No%n", email.getId(), email.getSubject(), email.getMessage(), email.getTime());
                }
            }
            specialPrint = false; 
        } else {
            System.out.println("Email     Subject              Message                                  Time          Read");
            for(Email email : emails) {
                System.out.printf("%-10d%-20s%-40s%d", email.getId(), email.getSubject(), email.getMessage(), email.getTime());
                System.out.print("    " + (email.isRead() ? "Yes" : "No"));
                System.out.printf("%n");
            }
        }
    }

    /* List getter */
    public LinkedList<Email> getEmails() {
        return emails;
    }
}