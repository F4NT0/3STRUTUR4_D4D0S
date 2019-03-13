public class LinkedList<E> implements ListTAD<E>{
    private Nodo primeiro,ultimo;
    private int totalElementos;

    public class Nodo{
        private E elemento;
        private Nodo proximo;
        
        public Nodo(E e){
            elemento = e;
            proximo = null;
        }
       
        public void definirElemento(E e){elemento = e;}
        public void definirProximo(Nodo n){proximo = n;}
        public E pegarElemento(){return elemento;}
        public Nodo pegarProximo(){return proximo;}    
    }

    
    public LinkedList(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
    }

    @Override
    public void adicionar(E e){
        Nodo novo = new Nodo(e); 
        if(primeiro == null){  
            primeiro = novo; 
        }else{
           
            ultimo.definirProximo(novo); 
        }
        ultimo = novo; 
        totalElementos++;
    }

    @Override
    public void limpar(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
    }


    @Override
    public boolean contem(E e){
        Nodo auxiliar; 
        auxiliar = primeiro;
        while(auxiliar != null){
            if(auxiliar.pegarElemento().equals(e)){
                return true;
            }
            auxiliar = auxiliar.pegarProximo();
        }
        return false;
    }

    @Override
    public E pegar(int index){
       
        if((index < 0) || (index >= totalElementos)){
            throw new IndexOutOfBoundsException();
        }
        Nodo auxiliar = primeiro; 
        int contador = 0; 
        while(contador < index){
           
            auxiliar = auxiliar.pegarProximo();
            contador++;
        }
       
        return auxiliar.pegarElemento();

    }

    @Override
    public boolean estaVazio(){
        if(primeiro == null){
            return true;
        }
        else{return false;}
    }

    @Override
    public boolean remover(E e){
        
        Nodo anterior,auxiliar;
        
        if(primeiro == null){return false;}
        
        if(primeiro.pegarElemento().equals(e)){
            
            if(ultimo == primeiro){ultimo = null;}
            
            primeiro = primeiro.pegarProximo();
            totalElementos--;
            return true;
        }
       
        anterior = primeiro; 
        
        auxiliar = primeiro.pegarProximo();

        while(auxiliar != null){
           
            if(auxiliar.pegarElemento().equals(e)){
                
                if(auxiliar == ultimo){ultimo = anterior;}
                
                anterior.definirProximo(auxiliar.pegarProximo());
                
                totalElementos--;
                return true;
            }
            else{
                
                anterior = auxiliar;
                auxiliar = auxiliar.pegarProximo();
            }
        }
        return false;
    }

    
    @Override
    public int tamanho(){
        return totalElementos;
    }


    
    @Override
    public void adicionar(int index,E elemento){
        
        if((index < 0) || (index >= totalElementos)){
            throw new IndexOutOfBoundsException();
        }
        
        Nodo novo = new Nodo(elemento);

        
        if(index == 0){
            
            novo.definirProximo(primeiro);
            
            primeiro = novo;
            if(ultimo == null){
                
                ultimo = novo;
            }
        }else{
            
            if(index == totalElementos){
                
                novo.definirProximo(ultimo);
                
                ultimo = novo;
            }else{
                
                Nodo auxiliar = primeiro;
                
                for(int i = 0 ; i < index - 1 ; i++){
                    
                    auxiliar = auxiliar.pegarProximo();
                }
               
                novo.definirProximo(auxiliar.pegarProximo());
                
                auxiliar.definirProximo(novo);
                
                
            }
        } 
        
        totalElementos++;
    }
    
    @Override
    public E remover(int index){
        
        if((index < 0) || (index >= totalElementos)){
            throw new IndexOutOfBoundsException();
        }
        
        Nodo auxiliar = primeiro;
        
        if(index == 0 ){
            
            if(ultimo == primeiro){
                ultimo = null;
            }
            
            primeiro = primeiro.pegarProximo();
            totalElementos--;
            return auxiliar.pegarElemento();
        }
        
        int contador = 0;
        while(contador < index - 1){
            auxiliar = auxiliar.pegarProximo();
            contador++;
        }
        
        E elemento = auxiliar.pegarElemento();
        
        if(ultimo == auxiliar.pegarProximo()){
          
            ultimo = auxiliar;
        }
        
        auxiliar.proximo = auxiliar.proximo.proximo; 
        
        totalElementos--;
        
        return elemento;
    }

    @Override
    public int indexDe(E e){
        
        int index = 0;
        
        Nodo auxiliar = primeiro;
        
        while(auxiliar != null){
            
            if(auxiliar.elemento.equals(e)){
                
                return index;
            }
            
            auxiliar = auxiliar.pegarProximo();
            index++;
        }
        
        return -1;
    }

    @Override
    public E definir(int index, E elemento){
        
        if((index < 0) || (index >= totalElementos)){
            throw new IndexOutOfBoundsException();
        }
        
        Nodo auxiliar = primeiro;
        
        for(int i = 0 ; i < index ; i++){
            auxiliar = auxiliar.pegarProximo();
        }
        
        E elementoAntigo = auxiliar.pegarElemento();
        
        auxiliar.definirElemento(elemento);
        
        return elementoAntigo;
    }

    
    @Override
    public void addInicio(E e){
        
        Nodo novo = new Nodo(e);
        
        novo.definirProximo(primeiro);
        
        primeiro = novo;
        
        if(ultimo == null){
            ultimo = novo;
        }
        totalElementos++;
    }
    
    @Override
    public E pegarInicio(){
        return primeiro.pegarElemento();
    }

    @Override
    public E pegarFim(){
        return ultimo.pegarElemento();
    }
    
    @Override
    public boolean removerInicio(){
        
        if(primeiro == ultimo){
            
            primeiro = null;
            
            totalElementos--;
            
            return true;
        }else{
           
            primeiro = primeiro.pegarProximo();
            totalElementos--;
            return true;
        }
    }
    
    @Override
    public boolean removerFim(){
        
        Nodo auxiliar = primeiro;
        
        if(primeiro == ultimo){
            primeiro = null;
            totalElementos--;
            return true;
        }
        
        for(int i = 0 ; i < totalElementos-1; i++){
            auxiliar = auxiliar.pegarProximo();
        }
        
        ultimo = auxiliar;
        totalElementos--;
        return true;
    }

}