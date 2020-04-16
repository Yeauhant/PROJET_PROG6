package ai;
public class TestTree {
	
	public static void main(String[] args) {
		
		System.out.println("Test de la classe Tree");
		System.out.println();
		
		Tree<Integer> test = new Tree<Integer>(0);
		
		test.root().addNode(1);
		test.root().addNode(2);
		test.root().addNode(3);
		test.root().addNode(4);
		test.root().addNode(5);
		
		System.out.println("Valeur de la racine : "+test.root().toString());
		System.out.println();
		
		System.out.println("Valeur des fils : ");
		for(int i = 0; i < test.root().nodes().size(); i++) System.out.print(test.root().nodes().get(i).toString()+" ; ");
		System.out.println();
		System.out.println();
		
		Node<Integer> n = test.root().nodes().get(4);
		System.out.println("Valeur des fils de "+n.toString());
		n.addNode(8);
		n.addNode(9);
		for(int i = 0; i < n.nodes().size(); i++) System.out.print(n.nodes().get(i).toString()+" ; ");
		System.out.println();
	}
	
}
