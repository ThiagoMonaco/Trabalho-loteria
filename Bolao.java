public class Bolao extends Jogo
{
    protected int NumDePart;
    
    public Bolao(int tam){
        super(tam);
        this.tam = tam;
        this.numeros = new int[this.tam];
        this.numDeAcertos = 0;
        this.preco = 0;
    }
    
    public int getNumDePart(){return this.NumDePart;}
    public int setNumDePart(int NumDePart){return this.NumDePart = NumDePart;}
    
    // valor do bolao é o valor do jogo divido pelo numero de pessoas no bolao
    public double calculaValorBolao()
    {   
        return this.ValorJogo()/this.NumDePart;            
    }
    
    
    public void CriaBolao()
    {   
        this.NumDePart = Teclado.leInt("Qual o numero de jogadores do bolão?");
        this.CriaJogo();
        this.preco = this.calculaValorBolao();
    }
    
}



