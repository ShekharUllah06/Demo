import java.util.ArrayList;
import java.util.List;


//If the finishing point is “n” spaces away from the starting point,
//please implement a program that calculates how many possible ways are there to arrive exactly at the finishing point. 

public class Q3 {

	public String countHelper(int n){
		
		ListNode[] arr = new ListNode[n];
		arr[0]= new ListNode(1);
		arr[1]= new ListNode(2);
		arr[2]= new ListNode(4);
		arr[3]= new ListNode(8);
		
		arr[4]= new ListNode(6);
		arr[4].next= new ListNode(1);
		
		arr[5]= new ListNode(2);
		arr[5].next= new ListNode(3);
		
		for(int i=6; i<n; i++){
			ListNode temp = new ListNode(0);
			for(int j=1; j<=6; j++){
				temp = addTwoNumbers(temp, arr[i-j]);
			}
			arr[i]=temp;
		}
				
						
		return printToString(arr[n-1]);
	}
	
	//turn the reverse-order LinkedList back to normal-order String form.
	// ex : 8--->2  =====> 28
	public static String printToString(ListNode node){
		ListNode cur = node;
		StringBuffer sb = new StringBuffer();
		while(cur!=null){
			sb.append(String.valueOf(cur.val));
			cur=cur.next;
		}
		return sb.reverse().toString();
	}
	
	// Add up two numbers by turning the number into reverse order as a Linkedlist
	// ex: 18+10 = 28
	// 8-->1 + 0-->1 = 8--->2
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode res = new ListNode(0);
        if(l1==null || l2==null) return res;
        
        ListNode start = res;
        int next=0;
        int sum=0;
        while(l1!=null || l2!=null){
            sum=0;
            ListNode temp = new ListNode(0);
            if(l1!=null) sum+=l1.val;
            if(l2!=null) sum+=l2.val;
            
            if(sum+next<10){
                temp.val=sum+next;
                next=0;
            }
            else{
                temp.val=sum+next-10;
                next=1;
            }
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            res.next=temp;
            res=res.next;
        }
        if(next>0) res.next=new ListNode(1);
        
        return start.next;
        
    }
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }

}
