public class Test {


    public static void main(String[] args) {






        AVLTree<Integer> treeIn = new AVLTree<Integer>();
        // 1 5 1 3 1 7 1 6 1 8 1 9
        treeIn.insert(5);        
        treeIn.insert(3);        
        treeIn.insert(7);
        
        treeIn.insert(6);      
        treeIn.insert(8);        
        treeIn.insert(9);
        //Obalans singel hoger rotation


        if(treeIn.findMin() != 3 || treeIn.findMax() != 9){
            System.out.println("Input Error test 1");
            treeIn.print();
        }
        if(treeIn.getNodeHeight (3) != 0 || treeIn.getNodeHeight(5) != 1 || treeIn.getNodeHeight(9) != 0 || treeIn.getNodeHeight(8) != 1 || treeIn.getNodeHeight(7) != 2 || treeIn.getNodeHeight(6) != 0){
            System.out.println("Input Text case 1 unexcpected height");
        }


        treeIn.clear();



        //Dubbel rotation vanster


        treeIn.insert(30);        
        treeIn.insert(20);        
        treeIn.insert(25);
        if(treeIn.findMin() != 20 || treeIn.findMax() != 30){
            System.out.println("Input Error test 1.5");
            treeIn.print();
        }
        if(treeIn.getNodeHeight(30) != 0 || treeIn.getNodeHeight(25) != 1 || treeIn.getNodeHeight(20) != 0){
            System.out.println("Input Text case 1.5 unexcpected height" + treeIn.getNodeHeight(30) + treeIn.getNodeHeight(25) + treeIn.getNodeHeight(20));
        }
        treeIn.clear();



        //Dubbel rotation höger
        treeIn.insert(10);        
        treeIn.insert(5);        
        treeIn.insert(17);

        treeIn.insert(18);
        treeIn.insert(14);      
        treeIn.insert(13);
        if(treeIn.findMin() != 5 || treeIn.findMax() != 18){
            System.out.println("Input Error test 2");
            treeIn.print();
        }
        if(treeIn.getNodeHeight(10) != 1 || treeIn.getNodeHeight(5) != 0 || treeIn.getNodeHeight(17) != 1 || treeIn.getNodeHeight(18) != 0 || treeIn.getNodeHeight(14) != 2 || treeIn.getNodeHeight(13) != 0){
            System.out.println("Input Text case 2 unexcpected height" + treeIn.getNodeHeight(10) + treeIn.getNodeHeight(5) + treeIn.getNodeHeight(17) + treeIn.getNodeHeight(18) + treeIn.getNodeHeight(14) + treeIn.getNodeHeight(13));
        }






        /************** TEST FÖR BORTAGNING AV NOD ENLIGT UPPGIFT **************/


        AVLTree<Integer> tree1 = new AVLTree<Integer>();

        //tree 1
        tree1.insert(6);
        tree1.insert(4);
        tree1.insert(10);
        tree1.insert(5);


        tree1.remove(10);


        if(tree1.findMin() != 4 || tree1.findMax() != 6){
            System.out.println("Error test 1");
            tree1.print();
        }
        if(tree1.getNodeHeight(6) != 0 || tree1.getNodeHeight(4) != 1 || tree1.getNodeHeight(5) != 0){
            System.out.println("Text case 1 unexcpected height");
        }




        //Tree 2
        AVLTree<Integer> tree2 = new AVLTree<Integer>();
        tree2.insert(6);
        tree2.insert(4);
        tree2.insert(10);
        tree2.insert(15);


        tree2.remove(4);




        if(tree2.findMin() != 6 || tree2.findMax() != 15){
            System.out.println("Error test 2");
            tree2.print();
        }
        if(tree2.getNodeHeight(6) != 0 || tree2.getNodeHeight(10) != 1 || tree2.getNodeHeight(15) != 0){
            System.out.println("Text case 2 unexcpected height");


        }


        //Tree 3
        AVLTree<Integer> tree3 = new AVLTree<Integer>();
        tree3.insert(9);
        tree3.insert(4);
        tree3.insert(11);
        tree3.insert(2);
        tree3.insert(6);
        tree3.insert(10);
        tree3.insert(12);
        tree3.insert(1);
        tree3.insert(3);
        tree3.insert(5);
        tree3.insert(7);
        tree3.insert(13);
        tree3.insert(8);


        tree3.remove(9);
        if(tree3.findMin() != 1 || tree3.findMax() != 13){
            System.out.println("Error test 3");
        }
        if(tree3.getNodeHeight(1) != 0 || tree3.getNodeHeight(3) != 0 ||tree3.getNodeHeight(8) != 0 ||tree3.getNodeHeight(11) != 0 ||tree3.getNodeHeight(13) != 0 ||tree3.getNodeHeight(2) != 1 ||tree3.getNodeHeight(5) != 0 ||tree3.getNodeHeight(7) != 1 ||tree3.getNodeHeight(12) != 1 ||tree3.getNodeHeight(4) != 2 ||tree3.getNodeHeight(10) != 2 ||tree3.getNodeHeight(6) != 3){
            System.out.println("Some element in test 3 has un expected height");
        }


        /************** TEST FÖR BORTAGNING AV NOD ENLIGT UPPGIFT **************/






    }


}



