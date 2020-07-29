public class Sorteio
{   
    //array que armazena os 6 numeros sorteados
    int numSort[];
    Sorteio()
    {
       this.numSort = new int[6];
    }
    //realiza sorteio
    public void fazSort()
    {   
        for(int i = 0;i < this.numSort.length;i++)
        {  //caso numeros repetidos sejam digitados ele sorteia novamente
           boolean invalido;
           do
           {
                this.numSort[i] = (int)(Math.random()*60)+1;
                int ix = 0;
                while(ix < i && this.numSort[ix] != this.numSort[i]){ ix++;}
                               
                invalido = ix < i;
                
                if(invalido)
                {
                    this.numSort[i]=(int)(Math.random()*60)+1;
                }
            }while(invalido);
        }
    }
    //metodo toString para imprimir os numeros sorteados
    public String toString()
    { 
        String s = "Numeros sorteados:|";
        for(int i = 0;i < this.numSort.length;i++)
        {
            s+=this.numSort[i] + "|";
        }
        
        return s;
    }

    
      
    
    
    
}
