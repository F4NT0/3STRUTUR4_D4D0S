public interface PilhaTAD<E>{
    public int tamanho();
    public boolean estaVazio();
    public E topo();
    public void push(E elemento);
    public E pop();
}