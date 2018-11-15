package com.mcc;

public class SBinaryTree<T extends Comparable<T>> implements IBinaryTree<T> {

  private Nodo<T> raiz;

  public SBinaryTree() {
    raiz = null;
  }

  @Override
  public boolean buscar(T d) {
    if (d == null) {
      throw new NullPointerException("El dato a buscar no debe ser nulo");
    }
    return buscar(raiz, d);
  }

  private boolean buscar(Nodo<T> nodo, T d) {
    if (nodo == null) {
      return false;
    }
    if (d.equals(nodo.getDato())) {
      return true;
    } else if (d.compareTo(nodo.getDato()) < 0) {
      return buscar(nodo.getIzquierdo(), d);
    } else {
      return buscar(nodo.getDerecho(), d);
    }
  }

  private Nodo<T> buscarNodo(Nodo<T> nodo, T n) {
    if (nodo == null) {
      return null;
    }

    if (n.equals(nodo.getDato())) {
      return nodo;
    } else if (n.compareTo(nodo.getDato()) < 0) {
      return buscarNodo(nodo.getIzquierdo(), n);
    } else {
      return buscarNodo(nodo.getDerecho(), n);
    }
  }

  @Override
  public void insertar(T d) {
    if (d != null) {
      raiz = insertar(raiz, d);
    }
  }

  private Nodo<T> insertar(Nodo<T> r, T n) {
    if (r == null) {
      r = new Nodo(n);
    } else if (n.compareTo(r.getDato()) <= 0) {
      r.setIzquierdo(insertar(r.getIzquierdo(), n));
    } else {
      r.setDerecho(insertar(r.getDerecho(), n));
    }
    return r;
  }

  @Override
  public int tamaño() {
    return tamaño(raiz);
  }

  private int tamaño(Nodo<T> raiz) {
    if (raiz == null) {
      return 0;
    } else {
      return 1 + tamaño(raiz.getIzquierdo()) + tamaño(raiz.getDerecho());
    }
  }

  @Override
  public String nodosGeneracion(int generacion) {
    if (generacion < 0) {
      throw new RuntimeException("La generacion no debe ser negativa.");
    }

    return nodosGeneracion(this.raiz, generacion);
  }

  private String nodosGeneracion(Nodo<T> raiz, int generacion) {
    if (raiz == null) {
      return "";
    }

    if (generacion == 0) {
      return raiz.getDato() + " ";
    }

    if (raiz.getDerecho() != null && raiz.getIzquierdo() != null) {
      return nodosGeneracion(raiz.getDerecho(), generacion - 1)
          + nodosGeneracion(raiz.getIzquierdo(), generacion - 1);
    } else if (raiz.getDerecho() != null) {
      return nodosGeneracion(raiz.getDerecho(), generacion - 1);
    } else {
      return nodosGeneracion(raiz.getIzquierdo(), generacion - 1);
    }
  }

  @Override
  public void remover(T d) {
    if (d == null) {
      throw new NullPointerException("El dato a buscar no debe ser nulo");
    }
    this.raiz = remover(this.raiz, d);
  }

  public Nodo<T> elementoMinimo(Nodo<T> raiz) {
    if (raiz.getIzquierdo() == null) {
      return raiz;
    }
    return elementoMinimo(raiz.getIzquierdo());
  }

  public Nodo<T> remover(Nodo<T> raiz, T dato) {
    if (raiz == null) {
      return null;
    }
    if (raiz.getDato().compareTo(dato) > 0) {
      raiz.setIzquierdo(remover(raiz.getIzquierdo(), dato));
    } else if (raiz.getDato().compareTo(dato) < 0) {
      raiz.setDerecho(remover(raiz.getDerecho(), dato));
    } else {
      if (raiz.getIzquierdo() != null && raiz.getDerecho() != null) {
        Nodo<T> minNodoDerecha = elementoMinimo(raiz.getDerecho());
        raiz.setDato(minNodoDerecha.getDato());
        remover(raiz.getDerecho(), minNodoDerecha.getDato());
      } else if (raiz.getIzquierdo() != null) {
        raiz = raiz.getIzquierdo();
      } else if (raiz.getDerecho() != null) {
        raiz = raiz.getDerecho();
      } else {
        raiz = null;
      }
    }
    return raiz;
  }

  @Override
  public boolean vacio() {
    return this.raiz == null;
  }

  @Override
  public void inorden() {
    inorden(raiz);
    System.out.println();
  }

  // (izquierda, Raiz, derecha)
  private void inorden(Nodo<T> r) {
    if (r != null) {
      inorden(r.getIzquierdo());
      System.out.print(r.getDato() + " ");
      inorden(r.getDerecho());
    }
  }

  @Override
  public void postorden() {
    postorden(raiz);
    System.out.println();
  }

  // (Izquierda, Derecha, Raiz)
  private void postorden(Nodo<T> r) {
    if (r != null) {
      postorden(r.getIzquierdo());
      postorden(r.getDerecho());
      System.out.print(r.getDato() + " ");
    }
  }

  @Override
  public void preorden() {
    preorden(raiz);
    System.out.println();
  }

  // (Raiz, izquierda, derecha)
  private void preorden(Nodo<T> r) {
    if (r != null) {
      System.out.print(r.getDato() + " ");
      preorden(r.getIzquierdo());
      preorden(r.getDerecho());
    }
  }

  @Override
  public T getPadre(T n) {
    if (n == null) {
      throw new NullPointerException("El dato a buscar no debe ser nulo");
    }

    return getPadre(raiz, n);
  }

  private T getPadre(Nodo<T> nodo, T n) {
    if (nodo == null) {
      return null;
    }

    if ((nodo.getDerecho() != null && nodo.getDerecho().getDato().equals(n))
        || (nodo.getIzquierdo() != null && nodo.getIzquierdo().getDato().equals(n))) {
      return nodo.getDato();
    } else if (nodo.getDato().compareTo(n) < 0) {
      return getPadre(nodo.getDerecho(), n);
    } else {
      return getPadre(nodo.getIzquierdo(), n);
    }
  }

  @Override
  public int nHijos(T n) {

    if (n == null) {
      throw new NullPointerException("El dato a buscar no debe ser nulo.");
    }

    if (raiz == null) {
      return -2;
    }
    return nHijos(raiz, n);
  }

  private int nHijos(Nodo<T> raiz, T n) {
    Nodo nodo = buscarNodo(raiz, n);
    int valor = 0;

    if (nodo == null) {
      return -1;
    } else {
      if (nodo.getIzquierdo() != null) {
        valor++;
      }

      if (nodo.getDerecho() != null) {
        valor++;
      }
    }

    return valor;
  }

  @Override
  public int balance() {
    return balance(this.raiz);
  }

  @Override
  public int balance(T dato) {
    if (dato == null) {
      throw new NullPointerException("el dato a buscar no debe ser nulo");
    }
    return balance(buscarNodo(this.raiz, dato));
  }

  private int balance(Nodo<T> nodo) {
    if (nodo == null) {
      throw new NullPointerException("El nodo es nulo.");
    }

    return tamaño(nodo.getIzquierdo()) - tamaño(nodo.getDerecho());
  }

  public T elementoMayor() {
    return elementoMayor(this.raiz);
  }

  private T elementoMayor(Nodo<T> raiz) {
    if (raiz == null) {
      throw new NullPointerException("La raiz en nula");
    } else if (raiz.getDerecho() == null) {
      return raiz.getDato();
    }
    return elementoMayor(raiz.getDerecho());
  }

  @Override
  public double promedio() {
    if (this.raiz == null) {
      throw new NullPointerException("La raiz es nula");
    }

    if (!(this.raiz.getDato() instanceof Integer)) {
      throw new RuntimeException("Para obtener promedio el arbol debe contener enteros.");
    }

    return (double) suma(this.raiz) / tamaño();
  }

  private Integer suma(Nodo<T> nodo) {
    if (nodo == null) {
      return 0;
    }
    return (Integer) nodo.getDato() + suma(nodo.getIzquierdo()) + suma(nodo.getDerecho());
  }
}
