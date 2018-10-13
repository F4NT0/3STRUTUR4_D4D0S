/**
 * Interface das Filas
 */
public interface FilaTAD<E>{
    public int tamanho();
    public boolean estaVazio();
    public E pegarPrimeiro();
    public void inserir(E elemento);
    public E retirar();
}
