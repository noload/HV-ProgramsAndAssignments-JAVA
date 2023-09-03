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

    
    def intersectionPresent(head1, head2):
        while head2 != None:
            temp = head1
            while temp != None:
                # if both nodes are same
                if temp == head2:
                    return head2
                temp = temp.next
            head2 = head2.next
    # intersection is not present between the lists
        return None
        
        
       
            

        

if __name__ == "__main__":
    linked_list1 = LinkedList()
    linked_list2=LinkedList()


    # Insert elements into the linkedlist1
    linked_list1.insert(1)
    linked_list1.insert(2)
    linked_list1.insert(3)
    linked_list1.insert(4)

    # Insert elements into the linkedlist1
    linked_list2.insert(7)
    linked_list2.insert(6)
    linked_list2.insert(5)
    linked_list2.insert(4)

    # Print the initial linked list
    print("Initial Linked List:")
    linked_list1.print_list()

    # Print the initial linked list
    print("Initial Linked List:")
    linked_list2.print_list()

    point=LinkedList.intersectionPresent(linked_list1,linked_list1)
    print(point.head.data)
    


