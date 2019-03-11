class Node
{
    private int data;
    private Node next;

    public Node()
    {
        data = 0;
        next = null;
    }

    public int getData()
    {
        return data;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }
}

public class CircularList
{
    Node head;

    public boolean isEmpty()
    {
        return head == null;
    }

    public void display()
    {
        if(isEmpty()){
            System.out.println("List is Empty");
            return;}
        else
        {
            Node temp = head;

            while (temp.getNext()!=head)
            {
                System.out.println(temp.getData());
                temp = temp.getNext();
            }
            System.out.println(temp.getData());
        }
    }

    public void insertEnd(int data)
    {
        Node n = head;
        Node temp = new Node();
        temp.setData(data);

        if(isEmpty())
        {
            head = temp;
            temp.setNext(head);
        }
        else
        {
             while (n.getNext() != head)
             {
                n = n.getNext();
             }
             n.setNext(temp);
             temp.setNext(head);
        }
    }

    public void insertBegin(int data)
    {
        Node temp = new Node();
        temp.setData(data);

        if(isEmpty())
        {
            head = temp;
            temp.setNext(head);
        }
        else
        {
            Node n = head;
            while (n.getNext()!=head)
            {
                n = n.getNext();
            }
            n.setNext(temp);
            temp.setNext(head);
            head = temp;
        }
    }

    public void insertPos(int data,int p)
    {
        if(p==0)
            System.out.println("Its not a position");
        else if(p>count()+1)
            System.out.println("List is not long enough");
        else if(p==1)
            insertBegin(data);
        else if(p==count()+1)
            insertEnd(data);
        else
        {
            Node n = new Node();
            n.setData(data);
            Node temp = head;
            int t = 1;
            while(t!= p-1)
            {
                temp = temp.getNext();
                t++;
            }
            n.setNext(temp.getNext());
            temp.setNext(n);
        }
    }

    public void deleteFirst()
    {
        if(isEmpty())
        {
            System.out.println("Liat is Empty");
            return;
        }
        else
        {
            Node n = head;
            while (n.getNext()!=head)
            {
                n = n.getNext();
            }
            n.setNext(head.getNext());
            head = head.getNext();
        }
    }

    public void deleteLast()
    {
        if(isEmpty())
            System.out.println("List is Empty");
        else if(count()==1)
            head = null;
        else
        {
            Node n = head;
            int k = count()-1;
            while(k>1)
            {
                n = n.getNext();
                k--;
            }
            n.setNext(head);
        }
    }

    public int count()
    {
        if(isEmpty())
            return 0;
        else
           {
               int c = 1;
               Node temp = head;
               while (temp.getNext() != head)
               {
                   c++;
                   temp = temp.getNext();
               }
               return c++;
           }
    }

    public static void main(String[] args) {

        CircularList obj = new CircularList();

        obj.insertEnd(10);
        obj.insertEnd(20);
        obj.insertEnd(30);
        obj.insertBegin(-10);
        obj.insertEnd(40);
        obj.insertPos(50,5);
        obj.deleteLast();
        obj.deleteFirst();
        obj.display();
        System.out.println(obj.count());
    }
}
