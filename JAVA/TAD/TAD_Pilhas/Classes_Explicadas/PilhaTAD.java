/**
 * Classe Interface de Pilhas
 */
public interface PilhaTAD<T>{
    public int tamanho();
    public boolean estaVazio();
    //método para retornar o elemento do topo da pilha
    public T topo();
    //método para adicionar elemento na pilha
    public void push(T elemento);
    //método para remover elemento da pilha
    public T pop();
}