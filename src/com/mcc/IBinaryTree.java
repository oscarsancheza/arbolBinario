package com.mcc;

import java.util.List;

public interface IBinaryTree<T> {
  boolean buscar(T d);

  void insertar(T d);

  int tamaño();

  void remover(T d);

  boolean vacio();

  void inorden();

  void postorden();

  void preorden();

  int nHijos(T n);

  T getPadre(T n);

  int balance() throws Exception;

  int balance(T dato) throws Exception;

  T elementoMayor();

  String nodosGeneracion(int generacion);

  List<T> getData();
}
