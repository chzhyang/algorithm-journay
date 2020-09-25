package com;

import java.util.*;

class Node {
	int val;
	Node left;
	Node right;
	Node(int x){
		val =x;
	}
}
public class Main {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,-1,-1,5,-1,-1,6,-1,-1,7,-1,-1};
		System.out.println();
	}
	public static Node constructTree(int[] arr){
		if(arr==null){
			return null;
		}
		Node root = null;
		for(int i=0; i<arr.length;i++){
			if(arr[i]!=-1){
				Node node = new Node(arr[i]);
				if(i==0){
					root = node;
				}
			}
		}
		return root;
	}
	public static void preOrder1(Node root) {
		// TODO:
		Stack<Node> st = new Stack<>();
		Node node = root;
		while(node != null  ||  !st.isEmpty()){
			if(node != null){
				System.out.print(node.val+ " " );
				st.push(node);
				node = node.left;
			}else{
				Node t = st.pop();
				node = t.right;
			}
		}
	}
	public static void preOrder2(Node root) {
		Stack<Node> st = new Stack<>();
		if(root==null){
			return;
		}else {
			st.push(root);
		}
		while(!st.isEmpty()){
			Node node = st.pop();
			System.out.print(node.val+" ");
			if(node.right!=null){
				st.push(node.right);
			}
			if(node.left!=null){
				st.push(node.left);
			}
		}
		System.out.println();
	}

	public static void in(Node root){
		Stack<Node> st = new Stack<>();
		Node node = root;
		while(node != null  ||  !st.isEmpty()){
			if(node != null ){
				st.push(node);
				node =node.left;
			}else{
				Node t = st.pop();
				System.out.print(t.val + " ");
				node = t.right;
			}
		}
	}
	public static void post(Node root) {
		Stack<Node> st = new Stack<>();
		st.push(root);
		Node cur, pre =null;
		while(!st.isEmpty()){
			cur = st.pop();
			if( (cur.left==null&&cur.right==null) ||
					(pre != null && ( pre==cur.left|| pre==cur.right))
			){
				System.out.print(cur.val + " ");
			}else{
				if(cur.right!=null){
					st.push(cur.right);
				}
				if(cur.left!=null){
					st.push(cur.left);
				}
			}
		}
	}

}
