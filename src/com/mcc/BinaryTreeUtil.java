package com.mcc;

import java.util.List;

public class BinaryTreeUtil {

  public static <T extends Number> Double promedio(IBinaryTree<T> binaryTree) {
    if (binaryTree == null) {
      throw new NullPointerException("El arbol no debe ser nulo.");
    }

    return suma(binaryTree.getData()) / binaryTree.tamaño();
  }

  public static <T extends Number> Double suma(List<T> numeros) {
    Double total = 0.0;

    if (numeros == null || numeros.isEmpty()) {
      return 0.0;
    }
    for (T item : numeros) {
      total += item.doubleValue();
    }

    return total;
  }

}
