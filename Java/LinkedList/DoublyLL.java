class Node
{
    public int data;
    public Node next;
    public Node prev;

    public Node(int iNo)
    {
        this.data = iNo;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList
{
    private Node first;
    private int iCount;

    public DoublyLinkedList()
    {
        this.first = null;
        this.iCount = 0;
    }

    public void Display()
    {
        Node temp = first;

        System.out.print("null <=>");

        while(temp != null)
        {
            System.out.print("| "+temp.data+" | <=> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public int Count()
    {
        return iCount;
    }

    public void InsertFirst(int iNo)
    {
        Node newn = new Node(iNo);

        if(first == null)
        {
            first = newn;
        }
        else
        {
            newn.next = first;
            first.prev = newn;
            first = newn;
        }

        iCount++;
    }

    public void InsertLast(int iNo)
    {
        Node newn = new Node(iNo);

        if(first == null)
        {
            first = newn;
        }
        else
        {
            Node temp = first;

            while(temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newn;
            newn.prev = temp;
        }

        iCount++;
    }

    public void InsertAtPos(int iNo, int iPos)
    {
        if(iPos < 1 || iPos > iCount+1)
        {
            System.out.println("Invalid Position");
            return;
        }

        if(iPos == 1)
        {
            InsertFirst(iNo);
        }
        else if(iPos == iCount+1)
        {
            InsertLast(iNo);
        }
        else
        {
            Node temp = first;

            Node newn = new Node(iNo);

            for(int i = 1; i < iPos-1; i++)
            {
                temp = temp.next;
            }

            newn.next = temp.next;
            newn.prev = temp;

            temp.next.prev = newn;
            temp.next = newn;

            iCount++;
        }
    }

    public void DeleteFirst()
    {
        if(first == null)
        {
            return;
        }
        else if(first.next == null)
        {
            first = null;
        }
        else
        {
            first = first.next;
            first.prev = null;
        }

        iCount--;
    }

    public void DeleteLast()
    {
        if(first == null)
        {
            return;
        }
        else if(first.next == null)
        {
            first = null;
        }
        else
        {
            Node temp = first;

            while(temp.next.next != null)
            {
                temp = temp.next;
            }

            temp.next = null;
        }

        iCount--;
    }

    public void DeleteAtPos(int iPos)
    {
        if(iPos < 1 || iPos > iCount)
        {
            System.out.println("Invalid Position");
            return;
        }

        if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == iCount)
        {
            DeleteLast();
        }
        else
        {
            Node temp = first;

            for(int i = 1; i < iPos-1; i++)
            {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            temp.next.prev = temp;

            iCount--;
        }
    }
}

class DoublyLL
{
    public static void main(String A[])
    {
        DoublyLinkedList dobj = new DoublyLinkedList();
        int iRet = 0;

        dobj.InsertFirst(51);
        dobj.InsertFirst(21);
        dobj.InsertFirst(11);

        dobj.Display();
        iRet = dobj.Count();
        System.out.println("Total Number of nodes : "+iRet);

        dobj.InsertLast(101);
        dobj.InsertLast(121);

        dobj.Display();
        iRet = dobj.Count();
        System.out.println("Total Number of nodes : "+iRet);

        dobj.InsertAtPos(105, 5);

        dobj.Display();
        iRet = dobj.Count();
        System.out.println("Total Number of nodes : "+iRet);

        dobj.DeleteAtPos(5);

        dobj.Display();
        iRet = dobj.Count();
        System.out.println("Total Number of nodes : "+iRet);

        dobj.DeleteFirst();

        dobj.Display();
        iRet = dobj.Count();
        System.out.println("Total Number of nodes : "+iRet);

        dobj.DeleteLast();

        dobj.Display();
        iRet = dobj.Count();
        System.out.println("Total Number of nodes : "+iRet);
    }
}