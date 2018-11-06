/**
 * Implementação da Interface do Tipo Abstrato de dados de Lista
 */
public interface ListTAD<T>{
    public void adicionar(T e);
    public void adicionar(int index,T elemento);
    public void limpar();
    public boolean contem(T e);
    public T pegar(int index);
    public int indexDe(T e);
    public boolean estaVazio();
    public boolean remover(T e);
    public T remover(int index);
    public int tamanho();
    public T definir(int index,T elemento);
    public void addInicio(T e);
    public T pegarInicio();
    public T pegarFim();
    public boolean removerInicio();
    public boolean removerFim();
}