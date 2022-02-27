package com.leetcode.linkedlist;

public class MergeKLists {
	public ListNodeS mergeKLists(ListNodeS[] lists) {
        int len = lists.length;
        for (int i = 0; i < lists.length - 1; i++) {
            lists[i] = mergeTwoLists(lists[i], lists[i+1]);
            lists[i + 1] = lists[i];
        }
        
        return lists.length != 0 ? lists[0] : null;
    }
    
    private ListNodeS mergeTwoLists(ListNodeS l1, ListNodeS l2) {
    	ListNodeS ans = new ListNodeS(0);
    	ListNodeS current = ans;
        if (l1 != null || l2 != null) {
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                }
                else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }
            if (l1 == null) current.next = l2;
            if (l2 == null) current.next = l1;
        }
        return ans.next;
    }
    
    public void printAll(ListNodeS head) {
		int index = 0;
		ListNodeS current = head;
		while (current != null) {
			System.out.println("Element at index " + index + " : " + current.val);
			current = current.next;
			index++;
		}
	}
    
    public static void main(String[] args) {
    	MergeKLists mergeKLists = new MergeKLists();
    	ListNodeS l1 = new ListNodeS(2);
    	ListNodeS l2 = new ListNodeS();
    	ListNodeS l3 = new ListNodeS(-1);
    	ListNodeS[] lists = new ListNodeS[3];
    	lists[0] = l1;
    	lists[1] = l2;
    	lists[2] = l3;
    	ListNodeS ans = mergeKLists.mergeKLists(lists);
    	mergeKLists.printAll(ans);
    	
	}		
	

}


  class ListNodeS {
      int val;
      ListNodeS next;
      ListNodeS() {}
      ListNodeS(int val) { this.val = val; }
      ListNodeS(int val, ListNodeS next) { this.val = val; this.next = next; }
  }
 