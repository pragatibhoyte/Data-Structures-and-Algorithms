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

class DoublyCircularLL
{
    private int iCount;
    private Node first;
    private Node last;

    public DoublyCircularLL()
    {
        this.iCount = 0;
        this.first = null;
        this.last = null;
    }

    public void Display()
    {
        if(first == null || last == null)
        {
            System.out.println("List is Empty");
            return;
        }

        Node temp = first;

        do
        {
            System.out.print("| "+temp.data+" | <=> ");
            temp = temp.next;

        }while(temp != last.next);

        System.out.println();
    }

    public int Count()
    {
        return iCount;
    }

    public void InsertFirst(int iNo)
    {
        Node newn = new Node(iNo);

        if(first == null || last == null)
        {
            first = newn;
            last = newn;
        }
        else
        {
            newn.next = first;
            first.prev = newn;
            first = newn;
        }

        last.next = first;
        first.prev = last;
        iCount++;
    }

    public void InsertLast(int iNo)
    {
        Node newn = new Node(iNo);

        if(first == null || last == null)
        {
            first = newn;
            last = newn;
        }
        else
        {
            last.next = newn;
            newn.prev = last;
            last = newn;
        }

        last.next = first;
        first.prev = last;
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
            Node newn = new Node(iNo);
            Node temp = first;
            
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
        if(first == null || last == null)
        {
            return;
        }
        else if(first == last)
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.next;

            last.next = first;
            first.prev = last;
        }

        iCount--;
    }

    public void DeleteLast()
    {
        if(first == null || last == null)
        {
            return;
        }
        else if(first == last)
        {
            first = null;
            last = null;
        }
        else
        {
            last = last.prev;

            last.next = first;
            first.prev = last;
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

class DoublyCL
{
    public static void main(String A[])
    {
        DoublyCircularLL dobj = new DoublyCircularLL();
        int iRet = 0;

        dobj.InsertFirst(51);
        dobj.InsertFirst(21);
        dobj.InsertFirst(11);

        dobj.Display();

        iRet = dobj.Count();
        System.out.println("Total Number of Nodes : "+iRet);

        dobj.InsertLast(101);
        dobj.InsertLast(121);

        dobj.Display();

        iRet = dobj.Count();
        System.out.println("Total Number of Nodes : "+iRet);

        dobj.InsertAtPos(105, 5);

        dobj.Display();

        iRet = dobj.Count();
        System.out.println("Total Number of Nodes : "+iRet);

        dobj.DeleteAtPos(5);

        dobj.Display();

        iRet = dobj.Count();
        System.out.println("Total Number of Nodes : "+iRet);

        dobj.DeleteFirst();

        dobj.Display();

        iRet = dobj.Count();
        System.out.println("Total Number of Nodes : "+iRet);

        dobj.DeleteLast();

        dobj.Display();

        iRet = dobj.Count();
        System.out.println("Total Number of Nodes : "+iRet);
    }
}