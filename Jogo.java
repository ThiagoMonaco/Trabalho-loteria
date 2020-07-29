public class Jogo
{
    int numeros[];
    protected int tam;
    protected int numDeAcertos;
    protected double preco;
    public Jogo(int tam)    
    {
        this.tam = tam;
        this.numeros = new int[tam];
        this.numDeAcertos = 0;
        this.preco = this.ValorJogo();
    }
    
    public Jogo()    
    {
        this.tam = 6;
        this.numeros = new int[tam];    
    }    
    
    public int getTam(){return this.tam;}
    public int setTam(int tam){return this.tam = tam;}
    
    public int getNumDeAcertos(){return this.numDeAcertos;}
    public int setNumDeAcertos(int numDeAcertos){return this.numDeAcertos = numDeAcertos;}
    
    public double getPreco(){return this.preco;}
    public double setPreco(double preco){return this.preco= preco;}
    
    public double ValorJogo()
    {
        switch(this.numeros.length)
        {   //valores dos jogos para a quantidade de numeros especificada
            case 6: return 4.50;
            case 7: return 31.50;
            case 8: return 126.00;
            case 9: return 378.00;
            case 10: return 945.00;
            case 11: return 2079.00;
            case 12: return 4158.00;
            case 13: return 7722.00;
            case 14: return 13513.50;
            case 15: return 22522.50;
            
            default:
                System.out.println("Não é possivel uma cartela com essa quantidade de numeros");
                return 0;
               
        }            
    }
    
    public void CriaJogo()
    {   
        boolean invalido;
        int qntNum = 0;
        //armazena os numeros digitados pelo usuario e verifica se eles sao maiores que 60 ou menores que 0 e se sao repetidos 
        for(int i = 0;i < this.numeros.length;i++)
        {   
           do{
                this.numeros[i] = Teclado.leInt("Digite um numero de 1 a 60 |"+ qntNum +"/" +this.numeros.length);
                int ix = 0;
                while (ix < i && this.numeros[ix] != this.numeros[i]){ ix++;}
                               
                invalido = ix < i;
                
                if(invalido)
                {
                    System.out.println("Numero ja selecionado,digite outro");
                }else if(this.numeros[i] < 1 || this.numeros[i] > 60)
                {
                    System.out.println("Numero invalido, apenas numeros de 1 a 60");
                    invalido = true;
                }
            }while(invalido);
           qntNum++;
        }
    }
    //confere resultado de algum jogo e retorna o numero de acertos
    public int ConfereRes(Sorteio s)
    {  
        for(int i = 0;i < this.numeros.length;i++)
        {   for(int j = 0; j < 6;j++)
            {
                if(this.numeros[i] == s.numSort[j])
                {
                    this.numDeAcertos++;
                }
            }
        }
        return this.numDeAcertos;
    }
    //metodo toString que imprime os numeros do jogo
    public String toString()
    {   String s = "| - ";
        for(int i = 0;i <this.numeros.length;i++)
        {
            s+=this.numeros[i] + " - ";
        }
        s+= "|";
        return s;
    }
    
    public void criaSurpresinha()
    {
        boolean invalido;
        int qntNum = 0;
        //armazena os numeros digitados pelo usuario e verifica se eles sao maiores que 60 ou menores que 0 e se sao repetidos 
        for(int i = 0;i < this.numeros.length;i++)
        {             
           do
           {
                this.numeros[i] = (int)(Math.random()*60)+1;
                int ix = 0;
                while(ix < i && this.numeros[ix] != this.numeros[i]){ ix++;}
                               
                invalido = ix < i;
                
                if(invalido)
                {
                    this.numeros[i]=(int)(Math.random()*60)+1;
                }
            }while(invalido);
           qntNum++;
        } 
        
    }

}

    








