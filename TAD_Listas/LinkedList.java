/**
 * Implementação de uma classe de Listas Encadeadas com Nodos
 * utiliza os métodos da interface TAD
 * possui uma classe interna de Nodos
 */
public class LinkedList<T> {//implements ListTAD{
    //Variáveis
    private Nodo primeiro,ultimo;
    //primeiro é o HEAD
    //ultimo é o TAIL
    private int totalElementos;

    //Classe Interna Nodo
    public class Nodo{
        private T elemento;
        private Nodo proximo;
        //Método construtor
        public Nodo(T e){
            elemento = e;
            proximo = null;
        }
        //Métodos da Classe Nodo
        public void definirElemento(T e){elemento = e;}
        public void definirProximo(Nodo n){proximo = n;}
        public T pegarElemento(){return elemento;}
        public Nodo pegarProximo(){return proximo;}    
    }

    //Método construtor da LinkedList
    public LinkedList(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
    }

    //Métodos da LinkedList implementados da interface TAD

    /**
     * Método de inserção de um elemento na lista
     * elemento sempre inserido no fim
     * @param e
     */
    public void adicionar(T e){
        Nodo novo = new Nodo(e); //criado um novo nodo com o elemento
        if(primeiro == null){  //se a referencia do primeiro nodo for null
            primeiro = novo; //define o primeiro como o novo
        }else{ // se o primeiro for diferente de null
            //O proximo nodo depois do ultimo será o novo Nodo
            ultimo.definirProximo(novo); 
        }
        ultimo = novo; //ultimo nodo se torna o novo
        totalElementos++; //sobe o total de elementos do nodo
    }

    /**
     * Método para zerar a Lista 
     */
    public void limpar(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
    }


    /**
     * Método para verificar se o elemento existe na Lista Encadeada
     * @param e
     * @return
     */
    public boolean contem(T e){
        Nodo auxiliar; //criado um nodo auxiliar
        auxiliar = primeiro; //definimos o auxiliar como o primeiro
        while(auxiliar != null){//enquanto o auxiliar não for nulo
            //verifica se o elemento é igual ao elemento de entrada
            if(auxiliar.pegarElemento().equals(e)){
                return true;
            }
            //pega o proximo Nodo depois de verificado
            auxiliar = auxiliar.pegarProximo();
        }
        return false;
    }

    /**
     * Para pegar um Nodo especifico, devemos 
     * criar um contador que irá passar por todos os nodos
     * até chegar no nodo que fica na posição do index
     * @param index
     */
    public T pegar(int index){
        //verificação se o index está dentro do tamanho total
        if((index < 0) || (index >= totalElementos)){
            throw new IndexOutOfBoundsException();
        }
        Nodo auxiliar = primeiro; //colocamos o primeiro nodo no auxiliar
        int contador = 0; //criamos um contador zerado
        while(contador < index){ //enquanto o contador for menor que o index
            //o auxiliar vai passando pelos nodos até chegar no nodo do index
            auxiliar = auxiliar.pegarProximo();
            contador++;
        }
        //quando chegar no index, retorna o elemento do Nodo
        return auxiliar.pegarElemento();

    }

    /**
     * Método para verificar se a lista esta vazia
     */
    public boolean estaVazio(){
        if(primeiro == null){
            return true;
        }
        else{return false;}
    }

    /**
     * Método para remover um elemento da lista 
     * Pesquisando pelo elemento
     * @param e
     * @return
     */
    public boolean remover(T e){
        //criado um nodo auxiliar e um anterior
        Nodo anterior,auxiliar;
        //se o primeiro for nulo, retorna false
        if(primeiro == null){return false;}
        //faz uma verificação para ver se o primeiro Nodo
        //possui o mesmo elemento do parâmetro
        if(primeiro.pegarElemento().equals(e)){
            //se o ultimo Nodo for igual ao primeiro
            //O ultimo será definido null
            if(ultimo == primeiro){ultimo = null;}
            //se não forem iguais
            //primeiro irá se tornar o proximo
            primeiro = primeiro.pegarProximo();
            totalElementos--; //diminui o total de elementos
            return true;
        }
        //se não for o mesmo elemento, devemos andar pelos Nodos
        anterior = primeiro; //anterior se torna o primeiro
        //auxiliar se torna o proximo
        auxiliar = primeiro.pegarProximo();

        while(auxiliar != null){//enquanto o auxiliar for diferente de null
           //Verifica se o elemento do auxiliar é igual ao elemento do parametro
            if(auxiliar.pegarElemento().equals(e)){
                //se o auxiliar for igual ao ultimo, o ultimo se torna anterior
                if(auxiliar == ultimo){ultimo = anterior;}
                //sera definido o proximo do anterior, pegando o proximo do auxiliar
                anterior.definirProximo(auxiliar.pegarProximo());
                //diminui o tamanho
                totalElementos--;
                return true;
            }
            else{
                //se não for igual, ele pega o proximo Nodo
                anterior = auxiliar;
                auxiliar = auxiliar.pegarProximo();
            }
        }
        return false;
    }

    /**
     * Método para retornar o tamanho da lista
     * @return
     */
    public int tamanho(){
        return totalElementos;
    }


    /**
     * Método para adicionar um elemento pela Posição
     * Podemos adicionar no inicio da lista
     * Podemos adicionar no meio da lista
     * Podemos adicionar no fim da lista
     * @param index
     * @param elemento
     */
    public void adicionar(int index,T elemento){
        //fazer uma verificação se o index esta dentro do tamanho
        if((index < 0) || (index >= totalElementos)){
            throw new IndexOutOfBoundsException();
        }
        //Criando um Nodo novo com o elemento
        Nodo novo = new Nodo(elemento);

        //Adicionando o Nodo no Inicio da Lista
        if(index == 0){
            //Pegamos o Nodo do inicio da lista e o colocamos como proximo
            novo.definirProximo(primeiro);
            //Definimos então o novo Nodo como o Primeiro
            primeiro = novo;
            if(ultimo == null){
                //Se o ultimo for nulo, dizemos então que o ultimo
                //também é o novo Nodo
                ultimo = novo;
            }
        }else{
            //Adicionando o Nodo no Final da Lista
            if(index == totalElementos){
                //Se o index for o tamanho da lista
                //definimos que o proximo do novo Nodo é o antigo ultimo
                novo.definirProximo(ultimo);
                //e transformamos o ultimo no novo Nodo
                ultimo = novo;
            }else{
                //Adicionando o Nodo no Meio da Lista
                //Criamos um Nodo auxiliar para andar entre os Nodos
                Nodo auxiliar = primeiro;
                //Criamos um for que irá fazer até index - 1
                for(int i = 0 ; i < index - 1 ; i++){
                    //ele vai andando pelos Nodos até chegar no Nodo do index
                    // é index -1 porque ele faz uma interação a mais no for
                    auxiliar = auxiliar.pegarProximo();
                }
                //Depois de encontrado o local do index
                //pegamos o Nodo que ficou no auxiliar depois do for
                //definimos que o proximo do auxiliar é o proximo do novo nodo
                novo.definirProximo(auxiliar.pegarProximo());
                //depois definimos que o proximo do nodo auxiliar é o novo nodo
                auxiliar.definirProximo(novo);
                
                
            }
        } 
        //não importando qual operação, o total da lista aumenta
        totalElementos++;
    }
    /**
     * Método para remover um elemento tendo index como parametro
     * @param index
     * @return
     */
    public T remover(int index){
        //primeiramente verificamos se o index esta dentro do tamanho
        if((index < 0) || (index >= totalElementos)){
            throw new IndexOutOfBoundsException();
        }
        //criamos um Nodo auxiliar para andar pela lista
        Nodo auxiliar = primeiro;
        //se o index for zero, iremos deletar o primeiro Nodo
        if(index == 0 ){
            //se somente tiver um Nodo na lista, o ultimo se torna null
            if(ultimo == primeiro){
                ultimo = null;
            }
            //o primeiro Nodo se torna o proximo Nodo, apagando a referencia do Nodo antigo
            primeiro = primeiro.pegarProximo();
            totalElementos--;
            return auxiliar.pegarElemento();
        }
        //se o index não for zero, iremos andar pela lista com um contador
        int contador = 0;
        while(contador < index - 1){
            auxiliar = auxiliar.pegarProximo();
            contador++;
        }
        //Se armazena o valor do elemento do Nodo em outra variavel
        //para que o elemento não seja perdido na hora de deletar
        T elemento = auxiliar.pegarElemento();
        //quando chegar no Nodo desejado,deve ser testado se ele é o ultimo
        if(ultimo == auxiliar.pegarProximo()){
          //assim retiramos a referencia do ultimo elemento e colocamos o auxiliar no lugar
            ultimo = auxiliar;
        }
        //definimos agora que o proximo Nodo depois do nodo no auxiliar é o proximo do proximo
        //com isso retiramos a referencia do proximo do Nodo auxiliar e defimos o proximo dele como proximo
        auxiliar.proximo = auxiliar.proximo.proximo; 
        //diminuimos o tamanho
        totalElementos--;
        //retornamos o elemento armazenado do Nodo que foi removido
        return elemento;
    }

    /**
     * Método para descobrir o index de um elemento especifico na lista
     * @param e
     * @return
     */
    public int indexDe(T e){
        //criamos uma variavel para armazenar o index
        int index = 0;
        //criamos um nodo auxiliar para andar pela lista
        Nodo auxiliar = primeiro;
        //vamos andar pela lista enquanto o auxiliar não seja null
        while(auxiliar != null){
            //temos que verificar se o elemento de parametro é igual ao elemento do auxiliar
            if(auxiliar.elemento.equals(e)){
                //se forem iguais,retorna o index
                return index;
            }
            //se o nodo do auxiliar que passou não tiver o elemento, iremos para o proximo
            auxiliar = auxiliar.pegarProximo();
            index++;
        }
        //se não tiver o elemento na lista, irá retornar -1
        return -1;
    }

    /**
     * Método para redefinir um elemento dentro de um Nodo
     * @param index
     * @param elemento
     * @return
     * @throws IndexOutOfBoundsException 
     */
    public T definir(int index, T elemento){
        //primeiramente verificamos se o index esta dentro do tamanho da lista
        if((index < 0) || (index >= totalElementos)){
            throw new IndexOutOfBoundsException();
        }
        //criamos um Nodo auxiliar para andar pela Lista
        Nodo auxiliar = primeiro;
        //andamos pela lista até o index
        for(int i = 0 ; i < index ; i++){
            auxiliar = auxiliar.pegarProximo();
        }
        //chegando no Nodo do index, armazenamos o elemento existente nele em uma variavel
        T elementoAntigo = auxiliar.pegarElemento();
        //definimos o elemento que irá ficar no Nodo
        auxiliar.definirElemento(elemento);
        //retornamos o antigo elemento que estava no Nodo
        return elementoAntigo;
    }

    /**
     * Método para somente adicionar no inicio do Nodo
     */
    public void addInicio(T e){
        //criaremos um Nodo novo para colocar o elemento
        Nodo novo = new Nodo(e);
        //tornamos o primeiro Nodo como o proximo do novo Nodo
        novo.definirProximo(primeiro);
        //depois definimos o primeiro Nodo como o novo
        primeiro = novo;
        //fazemos uma verificação se o ultimo nodo é null
        if(ultimo == null){
            ultimo = novo;
        }
        totalElementos++;
    }
    
    /**
     * Método para pegar o elemento no primeiro Nodo
     */
    public T pegarInicio(){
        return primeiro.pegarElemento();
    }

    /**
     * Método para pegar o elemento no ultimo Nodo
     */
    public T pegarFim(){
        return ultimo.pegarElemento();
    }
    
    /**
     * Método para remover o primeiro elemento do Nodo
     */
    public boolean removerInicio(){
        //verificamos se o primeiro é igual ao ultimo
        if(primeiro == ultimo){
            //primeiro se torna null
            primeiro = null;
            //remove o tamanho de elementos no Nodo
            totalElementos--;
            //retorna true
            return true;
        }else{
            //se tiverem mais elementos, o proximo elemento se torna o primeiro
            //retira a referencia para o antigo primeiro elemento
            primeiro = primeiro.pegarProximo();
            totalElementos--;
            return true;
        }
    }
    public boolean removerFim(){
        //criamos um Nodo auxiliar para andar pela lista
        Nodo auxiliar = primeiro;
        //verificamos se o primeiro Nodo é igual ao ultimo
        if(primeiro == ultimo){
            primeiro = null;
            totalElementos--;
            return true;
        }
        //se não forem iguais, iremos até o penultimo Nodo
        for(int i = 0 ; i < totalElementos-1; i++){
            auxiliar = auxiliar.pegarProximo();
        }
        //agora iremos transformar o ultimo no penultimo Nodo
        ultimo = auxiliar;
        totalElementos--;
        return true;
    }

}