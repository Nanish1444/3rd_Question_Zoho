import java.util.*;
class SinglyLinkedList {
    int size=0;
    Node root;
    //tightly coupling
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=next=null;
        }
    }

    public void addData(int data){
        if(root==null){
            root=new Node(data);
            size++;
            return;
        }
        Node temp = root;
        while(temp.next!=null){
            temp=temp.next;
        }

        temp.next=new Node(data);
        temp=temp.next;
        size++;
    }
    public void addFirst(int data){
        if(root==null){
            addData(data);
            return;
        }
        Node temp=new Node(data);
        temp.next=root;
        root=temp;
        size++;
    }
    public void addIndex(int index,int data){
        // 1 Based Index
        index--;
        
        
        if(index==0){
            addFirst(data);
            return;
        }
        if(index+1==size()){
            addData(data);
            return;
        }
        
        if(size()<index)return;

        Node temp = root;
        int tempLength=1;
        while(temp!=null){
            if(tempLength==index){
                break;
            }
            temp=temp.next;
            tempLength++;
        }
        Node head=temp.next;

        Node use = new Node(data);
        use.next=head;
        temp.next=use;
        size++;

    }
    public int size(){
        return size;
    }
    @Override
    public String toString(){
        Node temp = root;
        String str ="[";
        while(temp!=null){
            str+=temp.data;
            if(temp.next!=null){ 
                str+=" , ";
            }
            temp=temp.next;
        }
        str+="]";
        return str;
    }

}

class Singly{
    public static void main(String[] args) {
        SinglyLinkedList single = new SinglyLinkedList();
        single.addData(5);
        single.addData(6);
        single.addData(7);
        single.addData(8);
        single.addData(9);
        single.addFirst(10);
        single.addData(8);
        single.addIndex(2,2);
        single.addIndex(4,4);
        single.addIndex(9,4);
        System.out.println(single);
    }
}