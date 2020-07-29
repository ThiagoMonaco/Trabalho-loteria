public class Premiacao
{   //O Valor da variavel "valor "ja é os 46% do valor arrecadado(os outros 44% vao para outras instituicoes e progrmas))
    private double valor;
    private double premio6;
    private double premio5;
    private double premio4;

    
    public double getValor(){return this.valor;}
    public double getPremio6(){return this.premio6;}
    public double getPremio5(){return this.premio5;}
    public double getPremio4(){return this.premio4;}

    
    public double setValor(double valor){return this.valor = valor;}
    public double setPremio6(double premio6){return this.premio6 = premio6;}
    public double setPremio5(double premio5){return this.premio5 = premio5;}
    public double setPremio4(double premio4){return this.premio4 = premio4;}

    
    
    
    public Premiacao(double valor)
    {
        this.valor = valor;

        this.premio6 = this.valor * 0.35;
        this.premio5 = this.valor * 0.20;
        this.premio4 = this.valor * 0.20; 
    }
    // as funcoes premioNum calculam o premio para cada vencedor baseado em quantos venceram e na porcentagem do premio 
    
    //calcula o premio para vencedores de bolao
    public double premioBolao()
    {   Bolao bt = new Bolao(0);
        if(bt.getNumDeAcertos() == 4)
        {
            return this.premio4/bt.NumDePart;
        }
        else if(bt.getNumDeAcertos() == 5)
        {
            return this.premio5/bt.NumDePart;  
        }
        else
        {
            return this.premio6/bt.NumDePart;
        }
    }   
}
