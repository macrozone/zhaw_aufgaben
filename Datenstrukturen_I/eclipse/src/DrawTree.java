import java.util.Arrays;
import java.util.List;


public class DrawTree {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 5, 2, 3, 7, 6, 4, 8, 6);
		
		BinaryTree<Integer> tree = new BinaryTree<Integer>(4);
		tree.addValue(list);
		System.out.println(tree.toString());
	}
}
