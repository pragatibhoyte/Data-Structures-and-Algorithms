class Node
{
    public int data;
    public Node next;

    public Node(int iNo)
    {
        this.data = iNo;
        this.next = null;
    }
}

class SinglyCircularLL
{
    private int iCount;
    private Node first;
    private Node last;

    public SinglyCircularLL()
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
            System.out.print("| "+temp.data+" | -> ");
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
            first = newn;
        }

        last.next = first;
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
            last = newn;
        }

        last.next = first;
        iCount++;
    }

    public void InsertAtPos(int iNo, int iPos)
    {
        if(iPos < 1 || iPos > iCount+1)
        {
            System.out.println("Invalid Position/");
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
        else if(first == last)
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.next;
            last.next = first;
        }

        iCount--;
    }

    public void DeleteLast()
    {
        if(first == null)
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
            Node temp = first;

            while(temp.next != last)
            {
                temp = temp.next;
            }

            last = temp;
            last.next = first;
        }

        iCount--;
    }

    public void DeleteAtPos(int iPos)
    {
        if(iPos < 1 || iPos > iCount)
        {
            System.out.println("Invalid Position/");
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
            iCount--;
        }
    }
}

class SinglyCL
{
    public static void main(String A[])
    {
        SinglyCircularLL sobj = new SinglyCircularLL();
        int iRet = 0;

        sobj.InsertFirst(51);
        sobj.InsertFirst(21);
        sobj.InsertFirst(11);

        sobj.Display();

        iRet = sobj.Count();
        System.out.println("Total number of Nodes : "+iRet);

        sobj.InsertLast(101);
        sobj.InsertLast(111);

        sobj.Display();
        iRet = sobj.Count();
        System.out.println("Total number of Nodes : "+iRet);

        sobj.InsertAtPos(105, 5);

        sobj.Display();
        iRet = sobj.Count();
        System.out.println("Total number of Nodes : "+iRet);

        sobj.DeleteAtPos(5);

        sobj.Display();
        iRet = sobj.Count();
        System.out.println("Total number of Nodes : "+iRet);

        sobj.DeleteFirst();

        sobj.Display();
        iRet = sobj.Count();
        System.out.println("Total number of Nodes : "+iRet);

        sobj.DeleteLast();

        sobj.Display();
        iRet = sobj.Count();
        System.out.println("Total number of Nodes : "+iRet);
    }
}