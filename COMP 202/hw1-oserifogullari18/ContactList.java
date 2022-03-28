
/**
 * Contact List class for linked list implementation.
 * Node class and displayList method are already given for you. You need to implement rest of the methods.
 *
 * addToEnd(Contact new_contact): Add a new contact to the end of linked list.
 * Notice that if the list is empty, this new contact will be your first contact.
 * If new_contact is null, throw a NullPointerException with the message 'Null contact entry denied!'.
 *
 * insertAfter(Contact prev_contact, Contact new_contact) :  Add a new contact after a given previous contact.
 * If there is no such previous contact, do not do anything.
 * If new_contact is null, throw a NullPointerException with the message 'Null contact entry denied!'.
 *
 * insertBefore(Contact next_contact, Contact new_contact) : Add a new contact before a given 'next contact' .
 * If there is no such next contact, do not do anything.
 * If new_contact is null, throw a NullPointerException with the message 'Null contact entry denied!'.
 * If new_contact is null, throw a NullPointerException with the message 'Null contact entry denied!'.
 *
 * delete(Contact del_contact): Delete a given contact from the ContactList.
 * If there is no such contact, do not do anything.
 *
 * addToFav(Contact contact_to_fav): Change position of the given contact to the very beginning of the linked list.
 * If the given contact is already in favourites do not change its position.
 * Change the fav boolean of the contact to true.
 * Do not add a new contact to list with this method.
 *
 * removeFromFav(Contact contact_to_fav): Change position of the given contact to the very end of the linked list.
 * If the given contact is already not in favourites do not change its position.
 * Change the fav boolean of the contact to false.
 * Do not add a new contact to list with this method.
 *
 * displayList(): DO NOT change this method. It is important to have same output format.
 *
 * You are free to add some helper methods in the ContactList class (e.g. search, addToBeginning).
 * But you can also implement this class without any helper methods.
 */

class ContactList
{
    Node head;

    class Node
    {
        Contact data;
        Node next;
        Node(Contact d)
        {
            data = d;
            next = null;
        }
    }

    public void addToEnd(Contact new_contact) {
        // Your code here
        if(new_contact == null){
            throw new NullPointerException("Null  contact  entry  denied!");
        }
        Node new_node = new Node(new_contact);
        new_node.next = null;
        if(head == null){
            head = new_node;
        }
        else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new_node;
        }
    }

    public void insertAfter(Contact prev_contact, Contact new_contact) {
        // Your code here
        if(new_contact == null){
            throw new NullPointerException("Null  contact  entry  denied!");
        }
        Node current = head;
        while(current.data != prev_contact && current != null){
            current = current.next;
        }
        if(current != null){
            Node temp = current.next;
            current.next = new Node(new_contact);
            current.next.next = temp;
        }

    }

    public void insertBefore(Contact next_contact, Contact new_contact) {
        // Your code here
        if(new_contact == null){
            throw new NullPointerException("Null  contact  entry  denied!");
        }
        if(head != null && head.data == next_contact){//head case
            Node temp = head;
            head = new Node(new_contact);
            head.next = temp;
        }
        else{
            Node current = head;
            while(current != null && current.next != null && current.next.data != next_contact){
                current = current.next;
            }
            if(current != null && current.next != null){
                Node temp = current.next;
                current.next = new Node(new_contact);
                current.next.next = temp;
            }
        }
    }

    public void delete(Contact del_contact) {
        // Your code here
        if(head != null && head.data == del_contact){//head case
            head = head.next;
        }
        else{
            Node current = head;
            while(current != null && current.next != null && current.next.data != del_contact){
                current = current.next;
            }
            if(current != null && current.next != null){
                current.next = current.next.next;
            }
        }
    }


    public void addToFav(Contact contact_to_fav){
        // Your code here
        if(head != null && head.data == contact_to_fav && !head.data.getFav()){//head case
            head.data.setFav(true);
        }
        else{
            Node current = head;
            while(current != null && current.next != null && current.next.data != contact_to_fav){
                current = current.next;
            }
            if(current != null && current.next != null && !current.next.data.getFav()){
                Node temp1= head;
                Node temp2 = current.next;
                current.next = current.next.next;
                head = temp2;
                head.next = temp1;
                head.data.setFav(true);
            }
        }
    }

    public void removeFromFav(Contact contact_to_fav){
        // Your code here
        if(head != null && head.data == contact_to_fav && head.data.getFav()){//head case
            head.data.setFav(false);
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next = head;
            head = head.next;
            last.next.next = null;
        }
        else{
            Node current = head;
            while(current != null && current.next != null && current.next.data != contact_to_fav){
                current = current.next;
            }
            if(current != null && current.next != null && current.next.data.getFav()){
                current.next.data.setFav(false);
                Node last = current;
                while(last.next != null){
                    last = last.next;
                }
                last.next = current.next;
                current.next = current.next.next;
                last.next.next = null;
            }
        }
    }

    public void displayList() {
        Node temp = head;
        while (temp != null)
        {
            temp.data.displayInfo();
            temp = temp.next;
        }
    }

}