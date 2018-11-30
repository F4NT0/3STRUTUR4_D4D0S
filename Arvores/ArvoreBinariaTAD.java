public interface ArvoreBinariaTAD<T> extends Comparable<T>{
    void definirRaiz(T elemento);
    void inserir(T elemmento);
    boolean remove(T elemento);
    boolean removeGalho(T elemento);
    T pegarEsquerda(T elemento);
    T pegarDireita(T elemento);
    T pegarPai(T elemento);
    boolean contem(T elemento);
    T definir(T antigo, T elemento);
    LinkedList<T> prefixado();
    LinkedList<T> posFixado();
    LinkedList<T> central();
    LinkedList<T> largura();
    String pre();
    String pos();
    String centralPrint();
    boolean vazio();
    T pegarRaiz();
    int contador();
    int tamanho();
}