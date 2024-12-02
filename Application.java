/*************************************/
/*                                   */
/*             This is               */
/*         the final version         */
/*      of the mail application.     */ 
/*            30.10.2024             */
/*                                   */
/*************************************/
import java.util.Scanner;

public class Application {
    private ListOfEmails inbox;
    private ListOfEmails archive;
    private ListOfEmails sent;
    private int emailCounter;

    /* Class Constructor */
    public Application() {
        inbox = new ListOfEmails();
        archive = new ListOfEmails();
        sent = new ListOfEmails();
        emailCounter = 0;
    }

    /***************/
    /*             */
    /*   Methods   */
    /*             */
    /***************/

    /* Email finder */
    private Email findEmailById(int id) {
        // Check if the email is in inbox
        for(Email email : inbox.getEmails()) {
            if(email.getId() == id) {
                email.setLocation("Inbox");
                return email;
            }
        }

        // Check if the email is in archive
        for(Email email : archive.getEmails()) {
            if(email.getId() == id) {
                email.setLocation("Archive");
                return email;
            }
        }

        // Check if the email is in sent
        for(Email email : sent.getEmails()) {
            if(email.getId() == id) {
                email.setLocation("Sent");
                return email;
            }
        }

        // Invalid input
        return null;
    }

    /* Email deleter */
    private void deleteEmailById(int id) {
        // Check if ID is valid & find email
        Email emailToBeDeleted = findEmailById(id);
        if(emailToBeDeleted == null) {
            System.out.println("Invalid ID!");
            return;
        } 

        // Find desired emails location and delete it
        switch(emailToBeDeleted.findLocation()) {
            case "Inbox":
                inbox.delete(id);
                break;
            case "Archive":
                archive.delete(id);
                break;
            case "Sent":
                sent.delete(id);
                break;
        }
        System.out.println("Email " + id + " deleted from " + emailToBeDeleted.findLocation() + ".");
    }

    /* Folder deleter */
    private void clearFolder(String folder) {
        switch(folder) {
            // If inbox selected, move emails to the archive
            case "Inbox":
                archive.getEmails().addAll(inbox.getEmails());
                inbox.getEmails().clear();
                System.out.println("Inbox cleared.");
                break;

             // If sent selected, move emails to the archive
            case "Sent":
                archive.getEmails().addAll(sent.getEmails());
                sent.getEmails().clear();
                System.out.println("Sent folder cleared.");
                break;

             // If archive selected, remove everything
            case "Archive":
                archive.getEmails().clear();
                System.out.println("Archive cleared.");
                break;

            // Invalid folder selection
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    /*********************/
    /*                   */
    /*   Main Function   */
    /*                   */
    /*********************/

    public static void main(String[] args) {
        /*      Declaring Variables       */
        Application app = new Application();
        Scanner scanner = new Scanner(System.in);

        /*        No exit condition defined       */
        /* loop continues until program is closed */
        while(true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String usrInput = parts[0];
            String usrInput2 = "undefined";
            if(parts.length < 1) {
                System.out.println("Invalid input.");
                continue;
            }

            /*        Actions        */
            /*     by user input     */
            switch(usrInput) {

                // Creating new email
                case "N": 
                    System.out.print("Enter Subject: ");
                    String newSubject = scanner.nextLine();
                    System.out.print("Enter Message: ");
                    String newMessage = scanner.nextLine();
                    app.sent.createNewEmail(newSubject, app.emailCounter++, newMessage, System.currentTimeMillis(), "Sent");
                    System.out.println("Email sent.");
                    break;

                // Reading the desired email
                case "R": 
                    usrInput2 = parts[1];
                    int idToRead = Integer.valueOf(usrInput2);
                    Email emailToRead = app.findEmailById(idToRead);
                    if(emailToRead == null) {
                        System.out.println("No such email.");
                    } else {
                        switch(emailToRead.findLocation()) {
                            case "Inbox":
                                app.inbox.read(idToRead);
                                break;
                            case "Archive":
                                app.archive.read(idToRead);
                                break;
                            case "Sent":
                                app.sent.read(idToRead);
                                break;
                        }
                    }
                    break;

                // Archiving an email
                case "A":
                    usrInput2 = parts[1];
                    int idToArchive = Integer.valueOf(usrInput2);
                    Email emailToArchive = app.findEmailById(idToArchive);
                    if(emailToArchive == null) {
                        System.out.println("No such email.");
                    } else {
                        app.archive.addEmail(emailToArchive);
                        switch(app.findEmailById(idToArchive).findLocation()) {
                            case "Inbox":
                                app.inbox.delete(idToArchive);
                                System.out.println("Email " + idToArchive + " is Archived from Inbox.");
                                break;
                            case "Sent":
                                app.sent.delete(idToArchive);
                                System.out.println("Email " + idToArchive + " is Archived from Sent.");
                                break;
                            default:
                                System.out.println("Email " + idToArchive + " removing is unsuccessful.");
                                break;
                        }
                    }
                    break;

                // Deleting an email
                case "D":
                    usrInput2 = parts[1];
                    int idToDelete = Integer.valueOf(usrInput2);
                    app.deleteEmailById(idToDelete);
                    break;

                // Showing contents of the desired folder
                case "S":
                    usrInput2 = parts[1];
                    String folderToShow = usrInput2;
                    switch(folderToShow) {
                        case "Inbox":
                            app.inbox.specialPrinter();
                            break;
                        case "Archive":
                            app.archive.specialPrinter();
                            break;
                        case "Sent":
                            app.sent.specialPrinter();
                            break;
                        default:
                            System.out.println("Invalid folder!");
                            break;
                    }
                    break;
                
                // Showing unread emails at the desired folder
                case "U":
                    usrInput2 = parts[1];
                    String folderToShowUnread = usrInput2;
                    switch(folderToShowUnread) {
                        case "Inbox":
                            app.inbox.specialPrint = true;
                            app.inbox.specialPrinter();
                            break;
                        case "Archive":
                            app.archive.specialPrint = true;
                            app.archive.specialPrinter();
                            break;
                        case "Sent":
                            app.sent.specialPrint = true;
                            app.sent.specialPrinter();
                            break;
                        default:
                            System.out.println("Invalid folder!");
                            break;
                        }
                    break;
                
                // Clearing the contents of the desired folder
                case "C":
                    usrInput2 = parts[1];
                    String folderToClear = usrInput2;
                    app.clearFolder(folderToClear);
                    break;

                // Handling invalid inputs
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}