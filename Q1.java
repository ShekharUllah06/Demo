 // Where n is a positive integer, the function f(n) satisfies the following: 
 //f(0)=0
 //f(1)=1
 //f(n)=f(n-1)+f(n-2)
 //(a) Please create a program to find f(n). (You can write in any language that you are good at.) 

 
public class Q1 {

	public String solve(int n){
	 	if(n<0) return "Not a postive integer";
	 	if(n==0) return "0";
	 	if(n==-1) return "1";

	 	ListNode preOne = new ListNode(0);
	 	ListNode preTwo = new ListNode(1);
	 	ListNode res = addTwoNumbers(preOne, preTwo);
	 	
	 	for(int i=2; i<=n ; i++){
	 		res = addTwoNumbers(preOne, preTwo);
	 		preOne = preTwo;
	 		preTwo = res;
	 	} 

	 	return printToString(res);
	 }
	 //turn the reverse-order LinkedList back to normal-order String form.
	 // ex : 8--->2  =====> 28
	public String printToString(ListNode node){
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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
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
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int val) {
	     	this.val = val;
	  	 }
	 }
	
}