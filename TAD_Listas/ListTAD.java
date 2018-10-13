/**
 * Implementação da Interface do Tipo Abstrato de dados de Lista
 */
public interface ListTAD<E>{
    public void add(E e);
    public void add(int index,E element);
    public void clear();
    public boolean contains(E e);
    public E get(int index);
    public int indexOf(E e);
    public boolean isEmpty();
    public boolean remove(E e);
    public E remove(int index);
    public int size();
    public E set(int index,E element);
    public void addFirst(E e);
    public E getFirst();
    public E getLast();
    public boolean removeFirst();
    public boolean removeLast();
}