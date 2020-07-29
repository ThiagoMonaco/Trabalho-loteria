public class Jogador
{   
    Jogo jogos[];
    private String nome;
    private double saldo;
    private int qntdDeJogo;
    private double valorCompra;
    private int numMax;
    
    public Jogador(String nome)
    {
        //this.jogos = new Jogo[5]; //maximo de jogos que cada jogador pode ter = 5
        this.nome = nome;
        this.saldo = 70.00; // saldo inicial de cada jogador
        this.qntdDeJogo = 0;
    }
    
    public double getSaldo(){return this.saldo;}
    public double setSaldo(double saldo){return this.saldo = saldo;}
    
    public String getNome(){return this.nome;}
    public String setNome(String nome){return this.nome = nome;}   
    
    public int getQntdDeJogo(){return this.qntdDeJogo;}
    public int setQntdDeJogo(int qntdDeJogo){return this.qntdDeJogo = qntdDeJogo;}       

    public double getValorCompra(){return this.valorCompra;}
    public double setValorCompra(double valorCompra){return this.valorCompra = valorCompra;}    
    
    public int getNumMax(){return this.numMax;}    
    
    //Insere um novo jogo para o array jogos e incrementa a variavel qntdDeJogo
    public void insereJogo(Jogo j)
    {   
        this.jogos[this.qntdDeJogo] = j;
        this.qntdDeJogo++;        
    }
    
    public void CriaMao(int n)
    {
        this.numMax = n;
        this.jogos = new Jogo[n];
    }
}
