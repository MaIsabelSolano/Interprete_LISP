import java.util.ArrayList;

/**
 * @author: Marco Orozco
 * @version 1.02 Esta clase es la implementaciond e un vector a mi estilo
 */

public class StackVector<T> implements Stack<T> {

    public ArrayList<T> lista = new ArrayList<T>();

    /**
     * @param info
     */
    // Metodo para meter elementos
    public void Push(T info) {
        // Se añade un valor
        lista.add(info);
    }

    /**
     * @return T
     */
    public T Pop() {

        // Se obtiene un elemento
        int index = lista.size() - 1;

        // Se guarda ese elemento en una variable para posteriormente eliminarlo y
        // devolverlo
        T elemento = lista.get(index);
        lista.remove(index);
        return elemento;
    }

    /**
     * @return boolean
     */
    public boolean Empty() {

        // Devuelve un false si la lista tiene un elemento

        return lista.isEmpty();
    }

    /**
     * @return T
     */
    public T Peek() {

        // Se devuelve el ultimo valor de la lista

        int index = lista.size() - 1;
        return lista.get(index);
    }

    /**
     * @return int
     */
    public int Size() {

        // Se devuelve el tamaño del almacenamiento del stackvector

        return lista.size();
    }

    public T get(int index){
        return lista.get(index);
    }

    public T Popfirst() {

        // Se obtiene un elemento
        int index = 0;

        // Se guarda ese elemento en una variable para posteriormente eliminarlo y
        // devolverlo
        T elemento = lista.get(index);
        lista.remove(index);
        return elemento;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return lista.toString();
    }

    public void Clear(){
        lista.clear();
    }
    
     /**
     * Remplazar una variable específica
     */
    public void Set(int indice, T valor){
        lista.set(indice,valor);
    }
}
