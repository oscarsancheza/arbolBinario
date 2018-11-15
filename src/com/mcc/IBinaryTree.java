package com.mcc;

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

  int balance();

  int balance(T dato);

  T elementoMayor();

  double promedio();

  String nodosGeneracion(int generacion);
}
