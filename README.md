# Email Management Application

## Description
This is a simple yet powerful console-based Email Management System. The program allows users to create, read, delete, and manage emails across different folders such as Inbox, Sent, and Archive.

The application is implemented in Java and uses linked lists to store and handle emails effectively. It also includes functionality for marking emails as read, archiving, and printing email details in various formats.

---

## Features
1. **Email Operations:**
   - Create new emails.
   - Read individual emails.
   - Delete emails from specific folders.
   - Archive emails from Inbox or Sent folder.

2. **Folder Operations:**
   - Show all emails in a folder.
   - Show only unread emails in a folder.
   - Clear the contents of a folder (Inbox, Sent, or Archive).

3. **Formatting Options:**
   - Specially formatted email printouts.
   - Details include subject, message, time, and read status.

4. **Interactive Command-Based Interface:**
   - User-friendly command-based system for all operations.

---

## File Overview

### 1. `Email.java`
Defines the `Email` class with properties:
- `subject`: The subject of the email.
- `id`: A unique identifier for the email.
- `message`: The content of the email.
- `time`: The time the email was created.
- `isRead`: Read status of the email.
- `whereAmI`: Tracks the folder location of the email.

Methods include:
- Getters for email details.
- Mark email as read.
- Print detailed email information.
- Manage folder location.

---

### 2. `ListOfEmails.java`
Implements a `LinkedList` to manage multiple emails. Key methods:
- Add an email.
- Create and insert a new email.
- Read, delete, and display emails.
- Print emails in a formatted manner.

---

### 3. `Application.java`
Main application class that ties together all functionality. Features:
- Handles `Inbox`, `Sent`, and `Archive` folders using `ListOfEmails`.
- Includes methods to find, delete, or archive emails.
- Command-based user interaction for operations like:
  - **N**: Create a new email.
  - **R [ID]**: Read an email by ID.
  - **A [ID]**: Archive an email by ID.
  - **D [ID]**: Delete an email by ID.
  - **S [Folder]**: Show all emails in a folder.
  - **U [Folder]**: Show only unread emails in a folder.
  - **C [Folder]**: Clear all emails from a folder.

---

## How to Run
1. Compile all Java files:
   ```bash
   javac Email.java ListOfEmails.java Application.java
