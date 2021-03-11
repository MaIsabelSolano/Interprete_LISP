/**
 * @author Marco Orozco
 * @version 1.02 Esta interfaz es para usarla en Stackvector
 */
public interface Stack<T> {
    void Push(T info);

    // post:Agregar el dato al stack
    T Pop();

    // pre:revisar que no este vacio
    // pos: eliminar un elemento del stack
    T Peek();

    // pre: revisar que el stack no este vacio
    // post: muestra el stack mas reciente
    int Size();

    // post: regresa el tamano del stack
    boolean Empty();
    // post: true si esta vacio el stack

}