package com.mcc;

public class Nodo<T> {
  private Nodo<T> izquierdo;
  private Nodo<T> derecho;
  private T dato;

  public Nodo(T d) {
    izquierdo = null;
    derecho = null;
    dato = d;
  }

  public Nodo<T> getIzquierdo() {
    return izquierdo;
  }

  public void setIzquierdo(Nodo<T> izquierdo) {
    this.izquierdo = izquierdo;
  }

  public Nodo<T> getDerecho() {
    return derecho;
  }

  public void setDerecho(Nodo<T> derecho) {
    this.derecho = derecho;
  }

  public T getDato() {
    return dato;
  }

  public void setDato(T dato) {
    this.dato = dato;
  }
}
