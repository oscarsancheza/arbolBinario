package com.mcc;

public class Main {

  public static void main(String[] args) {
    int[] valores = new int[] {50, 30, 20, 40, 70, 60, 80};

    // String[] valores = {"oscar", "cesar"};

    IBinaryTree<Integer> sBinaryTree = new SBinaryTree<>();
    for (int i = 0; i < valores.length; i++) {
      sBinaryTree.insertar(valores[i]);
    }

    /*
          50
       /     \
      30      70
     /  \    /  \
    20   40  60   80 */

    System.out.println("buscar 50:" + sBinaryTree.buscar(50));
    System.out.println("tamaño:" + sBinaryTree.tamaño());

    System.out.println("inorden");
    sBinaryTree.inorden();
    System.out.println("eliminar 20:");
    sBinaryTree.remover(20);
    System.out.println("inorden");
    sBinaryTree.inorden();
    System.out.println("eliminar 30:");
    sBinaryTree.remover(30);
    System.out.println("inorden");
    sBinaryTree.inorden();
    System.out.println("eliminar 50:");
    sBinaryTree.remover(50);
    System.out.println("inorden");
    sBinaryTree.inorden();

    System.out.println("vacio:" + sBinaryTree.vacio());

    System.out.println("inorden");
    sBinaryTree.inorden();
    System.out.println("postorden");
    sBinaryTree.postorden();
    System.out.println("preorden");
    sBinaryTree.preorden();

    System.out.println("Numero de hijos de 70:" + sBinaryTree.nHijos(70));
    System.out.println("padre de 70:" + sBinaryTree.getPadre(70));

    System.out.println("balance raiz:" + sBinaryTree.balance());
    System.out.println("balance de 70:" + sBinaryTree.balance(70));

    System.out.println("generacion 3");
    String generacion = sBinaryTree.nodosGeneracion(2);
    System.out.println(generacion.isEmpty() ? "No existe esa generacion" : generacion);

    System.out.println("elemento mayor:" + sBinaryTree.elementoMayor());

    System.out.println("promedio:" + sBinaryTree.promedio());
  }
}
