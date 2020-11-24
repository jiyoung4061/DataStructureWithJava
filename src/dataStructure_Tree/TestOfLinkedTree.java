package dataStructure_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestOfLinkedTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		//
//		LinkedTree<String> tree = new LinkedTree<String>("A");
//		List<String> list = new ArrayList<String>();
		
//		LinkedTree.TreeNode<String> nodeA = tree.getRoot();
//		LinkedTree.TreeNode<String> nodeB = tree.insertLeft(nodeA, "B");
//		LinkedTree.TreeNode<String> nodeC = tree.insertRight( nodeA, "C" );
//		
//		LinkedTree.TreeNode<String> nodeD = tree.insertLeft( nodeB, "D" );
//		LinkedTree.TreeNode<String> nodeE = tree.insertRight( nodeB, "E" );
//				
//		LinkedTree.TreeNode<String> nodeF = tree.insertLeft( nodeC, "F" );
//		LinkedTree.TreeNode<String> nodeG = tree.insertRight( nodeC, "G" );
//		
//		//단말 노드라서 따로 node생성 X
//		tree.insertLeft( nodeD, "H" );
//		tree.insertRight( nodeD, "I" );
//				
//		tree.insertLeft( nodeE, "J" );
//
//		tree.insertRight( nodeF, "K" );
//
//		tree.insertLeft( nodeG, "L" );
//		tree.insertRight( nodeG, "M" );
//
//		tree.traversalPostorder(list);
//		System.out.println(Arrays.toString(list.toArray()));
//		
//		list.clear();
//		tree.traversalPreorder( list );
//		System.out.println( Arrays.toString( list.toArray() ) );
//
//		list.clear();
//		tree.traversalInorder( list );
//		System.out.println( Arrays.toString( list.toArray() ) );
		
		List<String> list = new ArrayList<String>();
		
//		TreeCalculator<String> cal = new TreeCalculator<String>("7+4*2-1");
//		TreeCalculator<String> cal = new TreeCalculator<String>("5+2-4+3*7+1*8/4-3");
//		TreeCalculator<String> cal = new TreeCalculator<String>("4*2+7-1+4+6*6");
		TreeCalculator<String> cal = new TreeCalculator<String>("1+1+1*9*1*4");

		
		System.out.println(cal.infixToPostfix());
		System.out.println("====================================");
		LinkedTree<String> tree = cal.makeExpressionTree();
		tree.traversalPostorder(list); // list에 순회된 값 들어감.
		System.out.println(Arrays.toString(list.toArray())); // 출력
		
		int result = cal.evaluateExpressionTree(tree.getRoot()); //
		System.out.println("Result:"+result);
		

	}

}
