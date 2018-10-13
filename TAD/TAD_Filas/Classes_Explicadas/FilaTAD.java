/**
 * Interface das Filas
 */
public interface FilaTAD<T>{
    public int tamanho();
    public boolean estaVazio();
    public T pegarPrimeiro();
    public void inserir(T elemento);
    public T retirar();
}
