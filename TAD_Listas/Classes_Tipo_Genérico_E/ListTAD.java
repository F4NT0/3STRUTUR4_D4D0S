/**
 * Implementação da Interface do Tipo Abstrato de dados de Lista
 */
public interface ListTAD<E>{
    public void adicionar(E e);
    public void adicionar(int index,E elemento);
    public void limpar();
    public boolean contem(E e);
    public E pegar(int index);
    public int indexDe(E e);
    public boolean estaVazio();
    public boolean remover(E e);
    public E remover(int index);
    public int tamanho();
    public E definir(int index,E elemento);
    public void addInicio(E e);
    public E pegarInicio();
    public E pegarFim();
    public boolean removerInicio();
    public boolean removerFim();
}