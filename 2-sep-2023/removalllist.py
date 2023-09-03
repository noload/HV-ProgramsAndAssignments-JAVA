class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def insert(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
        else:
            current = self.head
            while current.next:
                current = current.next
            current.next = new_node

    def print_list(self):
        current = self.head
        while current:
            print(current.data, end=" -> ")
            current = current.next
        print("None")

    def remove_by_value(self, value_to_remove):
        """
        Task-based Approach:
        1. Start with the head of the linked list.
        2. Traverse the linked list until you find a node whose value matches the value you want to remove.
        3. Update the `next` pointer of the previous node to skip the node you want to remove.
        4. If the value is found, remove the node and update the pointers.
        5. If the value is not found, handle the case where the value is not present in the list.
        """
        prev=None
        current=self.head
        while current:
            if current.data==value_to_remove:
                break
            
            prev=current
            current=current.next
        
        if not current:
            return 
        
        prev.next=current.next
        current=None




    def remove_by_position(self, position):
        """
        Task-based Approach:
        1. Start with the head of the linked list.
        2. Traverse the linked list until you reach the specified position.
        3. Update the `next` pointer of the previous node to skip the node at the specified position.
        4. Handle the case where the specified position is out of bounds.
        """
        #handling the empty list
        if not self.head:
            return

# Task 1
        current = self.head

        if position == 0:
            self.head = current.next
            current = None
            return

        prev = None
        count = 0
        while current and count != position:
            prev = current
            current = current.next
            count += 1

        if not current:
            return

        prev.next = current.next
        current = None



    def remove_head(self):
        """
        Task-based Approach:
        1. Update the head pointer to point to the next node in the linked list.
        """
        if(self.head):
            self.head=self.head.next
        else:
            print("linked list  is empty")

    def remove_from_end(self):
        """
        Task-based Approach:
        1. Start with the head of the linked list.
        2. Traverse the linked list until you reach the second-to-last node (i.e., the node just before the last node).
        3. Update the `next` pointer of the second-to-last node to point to `None`, effectively removing the last node.
        4. Handle the case where the linked list is empty or contains only one node.
        """
        if not self.head:
            return print("linked list is empty")
        if not self.head.next:
            self.head=None
            return 
        current = self.head
        while current.next and current.next.next:
            current = current.next
        current.next = None
        



# Example usage:
if __name__ == "__main__":
    linked_list = LinkedList()

    # Insert elements into the linked list
    linked_list.insert(1)
    linked_list.insert(2)
    linked_list.insert(3)
    linked_list.insert(4)

    # Print the initial linked list
    print("Initial Linked List:")
    linked_list.print_list()

    # linked_list.remove_by_value(3)
    # linked_list.remove_by_position(2)
    linked_list.remove_head()
    # linked_list.remove_from_end()

    # Print the updated linked list
    print("Updated Linked List:")
    linked_list.print_list()
