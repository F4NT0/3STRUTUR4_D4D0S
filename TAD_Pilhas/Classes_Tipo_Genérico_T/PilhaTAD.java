public interface PilhaTAD<T>{
    public int tamanho();
    public boolean estaVazio();
    public T topo();
    public void push(T elemento);
    public T pop();
}