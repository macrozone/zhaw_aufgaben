import java.util.Arrays;
import java.util.List;


public class DrawTree {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 5, 2, 3, 7, 6, 4, 8, 6,12,3,1,4,1,2,3,1,2,3,5,3,54,7,68,452,342);
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>(4);
		tree.addValue(list);
		System.out.println(tree.toString());
		
	}
}
