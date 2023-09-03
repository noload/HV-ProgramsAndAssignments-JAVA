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

    # def print_list(self):
    #     current = self.head
    #     while current != None:
    #         print(current.data, end=" -> ")
    #         current = current.next
        
    def printList(self):
        head=self.head
        while head.next != None:
            print(head.data, end='->')
            head = head.next
        print(head.data)


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
    linked_list.printList()

    

    # Print the updated linked list
    print("Updated Linked List:")
    linked_list.printList()
