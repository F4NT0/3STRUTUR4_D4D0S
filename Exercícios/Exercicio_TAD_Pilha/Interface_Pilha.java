/**
 * Classe Interface da Pilha
 * @author Gabriel Fanto Stundner, Marcius Moraes e Pedro Vieira
 */
public interface Interface_Pilha<T>{
    public int tamanho();
    public boolean estaVazio();
    public T topo();
    public void push(T elemento);
    public T pop();
}