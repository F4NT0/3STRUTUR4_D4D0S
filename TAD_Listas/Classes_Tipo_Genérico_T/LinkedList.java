
public class LinkedList<T> implements ListTAD<T>{
    
    private Nodo primeiro,ultimo;
    private int totalElementos;

    public class Nodo{
        private T elemento;
        private Nodo proximo;
        public Nodo(T e){
            elemento = e;
            proximo = null;
        }
        
        public void definirElemento(T e){elemento = e;}
        public void definirProximo(Nodo n){proximo = n;}
        public T pegarElemento(){return elemento;}
        public Nodo pegarProximo(){return proximo;}    
    }

    
    public LinkedList(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
    }

    
    @Override
    public void adicionar(T e){
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
    public boolean contem(T e){
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
    public T pegar(int index){
        
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
    public boolean remover(T e){
        
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
    public void adicionar(int index,T elemento){
        
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
    public T remover(int index){
       
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
        
        T elemento = auxiliar.pegarElemento();
        
        if(ultimo == auxiliar.pegarProximo()){
          
            ultimo = auxiliar;
        }
        
        auxiliar.proximo = auxiliar.proximo.proximo; 
        
        totalElementos--;
        
        return elemento;
    }

    
    @Override
    public int indexDe(T e){
        
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
    public T definir(int index, T elemento){
        
        if((index < 0) || (index >= totalElementos)){
            throw new IndexOutOfBoundsException();
        }
        
        Nodo auxiliar = primeiro;
        
        for(int i = 0 ; i < index ; i++){
            auxiliar = auxiliar.pegarProximo();
        }
        
        T elementoAntigo = auxiliar.pegarElemento();
        
        auxiliar.definirElemento(elemento);
        
        return elementoAntigo;
    }

    @Override
    public void addInicio(T e){
        
        Nodo novo = new Nodo(e);
        
        novo.definirProximo(primeiro);
        
        primeiro = novo;
        
        if(ultimo == null){
            ultimo = novo;
        }
        totalElementos++;
    }
    
    @Override
    public T pegarInicio(){
        return primeiro.pegarElemento();
    }

    @Override
    public T pegarFim(){
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