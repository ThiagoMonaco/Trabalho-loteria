public class Principal
{
    public static void main(String[] args)
    {
        Jogador p1 = new Jogador(Teclado.leString("Bem vindo ao Simulador de Mega Sena! Digite o seu nome para continuar"));        
        boolean menu = true;    
        //menu interativo
        while(menu)
        {   
            System.out.println("+------------------------------+");
            System.out.println("|--------Menu de opcões--------|");
            System.out.println("|1- Iniciar Partida            |");
            System.out.println("|2- Modo milionario            |");
            System.out.println("|3- Ler informações            |");
            System.out.println("|4- Valores                    |");
            System.out.println("|5- Sair                       |");
            System.out.println("+------------------------------+");
            System.out.println("|Nome:"+p1.getNome()+"|");
            System.out.printf("|Saldo:R$%.2f |\n",p1.getSaldo());            
            int op = Teclado.leInt();
            switch(op)
            {
                case 1: partida(p1);
                        break;
                case 2: p1.setSaldo(1000000);
                        partida(p1);
                        p1.setSaldo(70);
                        break;
                case 3: info();
                        break;                
                case 4: infoValores();
                        break;
                case 5: menu = false;          
                        break;
            }
        }
    }
    
    
    public static void partida(Jogador p1)
    {       
        int q = 0;
        
        while(q > p1.getNumMax() || q <= 0)
        {
            q = Teclado.leInt("Digite o numero de cartelas");
            p1.CriaMao(q);
            if(q > p1.getNumMax() || q <= 0)
            {
                System.out.println("Numero invalido, digite novamente");
            }
        }
        
        //Faz o jogador escolher se a cartela da vez sera um bolao ou um jogo normal
        for(int i = 0;i < q; i++)
        {
            int d = 0;
            while(d <= 0 || d > 3)
            {            
                d = Teclado.leInt("|1-Jogo normal\n|2-Bolão\n|3-Surpresinha");
                if(d == 1)
                {
                    JogoNormal(p1);
                }
                else if(d == 2)
                {
                    JogoBolao(p1);
                }else if(d == 3)
                {
                    surpresinha(p1);
                }                
                else
                {
                   System.out.println("Numero invalido, digite novamente"); 
                }
            }
        }
    
        //inicia a partida
        jogada(p1);
        //Reinicia a contagem de jogos após um termino de partida
        for(int i = 0;i < p1.getQntdDeJogo();i++)
        {
           if(p1.jogos[i] != null)
           {
           p1.jogos[i] = null;
           }
        }
        p1.setQntdDeJogo(0);
         }
    //cria um jogo normal e insere no array de jogos do usuario e imprime o valor do jogo
    public static void JogoNormal(Jogador p)
    {   
        System.out.println("Jogo numero " + (p.getQntdDeJogo()+1) + "(Jogo normal)");
        int num = 0;
        while(num < 6 || num >15)
        {
            num = Teclado.leInt("qual o tamanho da cartela do jogo?(minimo 6, maximo 15)");
            if(num <6 || num > 15)
            {
                System.out.println("Não é possivel uma cartela com essa quantidade de numeros");
            }
        }
        for(int i = 0; i < 1; i++)
        {
            Jogo j1 = new Jogo(num);    
            j1.CriaJogo();
            if(j1.getPreco() > p.getSaldo()){System.out.println("Valor do jogo maior que o saldo disponivel, cancelando compra");break;}
            p.insereJogo(j1);
            p.setValorCompra(p.getValorCompra() + p.jogos[p.getQntdDeJogo()-1].ValorJogo());
            p.setSaldo(p.getSaldo() - p.jogos[p.getQntdDeJogo()-1].ValorJogo());
            System.out.printf("Valor desse jogo:R$%.2f\n", (p.jogos[p.getQntdDeJogo()-1].ValorJogo()));
        }
    }
    
    //cria um Bolao e insere no array de jogos do usuario e imprime o valor do jogo
    public static void JogoBolao(Jogador p)
    {
        System.out.println("Jogo numero " + (p.getQntdDeJogo()+1) + "(Bolao)");
        int num = 0;
        while(num < 6 || num >15)
        {
            num = Teclado.leInt("qual o tamanho da cartela do jogo?(minimo 6, maximo 15)");
            if(num <6 || num > 15)
            {
                System.out.println("Não é possivel uma cartela com essa quantidade de numeros");
            }
        }
        for(int i = 0; i < 1;i++)
        {
            Bolao b1 = new Bolao(num);
            b1.CriaBolao();
            if(b1.getPreco() > p.getSaldo()){System.out.println("Valor do jogo maior que o saldo disponivel, cancelando compra");break;}
            p.insereJogo(b1);
            p.setValorCompra(p.getValorCompra() + ((Bolao)p.jogos[p.getQntdDeJogo()-1]).calculaValorBolao());
            p.setSaldo(p.getSaldo() - ((Bolao)p.jogos[p.getQntdDeJogo()-1]).calculaValorBolao());
            System.out.printf("Valor desse jogo:R$%.2f \n", ((Bolao)p.jogos[p.getQntdDeJogo()-1]).calculaValorBolao());
        }
    }
    //cria um jogo de surpresinha
    public static void surpresinha(Jogador p)
    {
        System.out.println("Jogo numero " + (p.getQntdDeJogo()+1) + "(Surpresinha)");
        int num = 0;
        while(num < 6 || num >15)
        {
            num = Teclado.leInt("qual o tamanho da cartela do jogo?(minimo 6, maximo 15)");
            if(num <6 || num > 15)
            {
                System.out.println("Não é possivel uma cartela com essa quantidade de numeros");
            }
        }
        for(int i = 0; i < 1; i++)
        {
            Jogo j1 = new Jogo(num);    
            j1.criaSurpresinha();
            if(j1.getPreco() > p.getSaldo()){System.out.println("Valor do jogo maior que o saldo disponivel, cancelando compra");break;}
            p.insereJogo(j1);
            p.setValorCompra(p.getValorCompra() + p.jogos[p.getQntdDeJogo()-1].ValorJogo());
            p.setSaldo(p.getSaldo() - p.jogos[p.getQntdDeJogo()-1].ValorJogo());
            System.out.printf("Valor desse jogo:R$%.2f\n", (p.jogos[p.getQntdDeJogo()-1].ValorJogo()));
        }       
    }
    // cria um partida com o jogador passado como argumento
    public static void jogada(Jogador j)
    {
       Sorteio s = new Sorteio();
       Premiacao pr = new Premiacao(1000000000);
       s.fazSort();
       System.out.println(j.getNome());
       System.out.printf("Valor da compra:R$%.2f \n",j.getValorCompra());
       System.out.println(s.toString());
       for(int i = 0;i < j.getQntdDeJogo();i++)
       {
           if(j.jogos[i] != null)
           {
               System.out.println("Jogo "+ (i+1) + "/"+j.getQntdDeJogo());
               j.jogos[i].ConfereRes(s);
               System.out.println(j.jogos[i].toString());
               System.out.println("Numero de acertos: "+j.jogos[i].getNumDeAcertos() + " numeros");
               switch(j.jogos[i].getNumDeAcertos())
               {
                   case 4: j.setSaldo(j.getSaldo() + pr.getPremio4());
                           break;
                   case 5: j.setSaldo(j.getSaldo() + pr.getPremio5());
                           break;
                   case 6: j.setSaldo(j.getSaldo() + pr.getPremio6());
                           break;
               }
               System.out.println("------------------------------");
           }
       }
    }
    //Imprime as informacoes do jogo
    public static void info()
    {        
        System.out.println("+------------------------------+");
        System.out.println("|----------Informações---------|");
        System.out.println("|O objetivo desse programa é   |");
        System.out.println("|Simular um sorteio de Mega    |");
        System.out.println("|Sena, o jogador tem direito a |");
        System.out.println("|comprar quantas cartelas puder|");
        System.out.println("|com seu saldo, que tem o valor|");
        System.out.println("|inicial de R$70,00, mas caso  |");
        System.out.println("|venca, o valor ganhado sera   |");
        System.out.println("|armazenado no saldo.          |");
        System.out.println("|------------------------------|");
        System.out.println("|-Como funciona uma Mega Sena?-|");
        System.out.println("|O jogador pode fazer um jogo  |");
        System.out.println("|(cartela), de ate 6 até 15    |");
        System.out.println("|numeros, sendo que quanto mais|");
        System.out.println("|numeros forem escolhidos maior|");
        System.out.println("|sera o valor da cartela(e     |");
        System.out.println("|maior a chance de vencer).Após|");
        System.out.println("|isso, serão sorteados 6       |");
        System.out.println("|numeros e caso esses 6 numeros|");
        System.out.println("|estiverem todos em um jogo,   |");
        System.out.println("|o jogador sera vencedor do    |");
        System.out.println("|prêmio,jogadores que acertarem|");
        System.out.println("|4 ou 5 numeros, também vão    |");
        System.out.println("|ganhar premios.               |");
        System.out.println("|------------------------------|");
        System.out.println("|Diferenca bolão, surpresinha e|");      
        System.out.println("|---------jogo normal----------|");
        System.out.println("|No bolão, o preco do jogo sera|");
        System.out.println("|dividido pela quantidade de   |");
        System.out.println("|participantes do bolão, ja na |");
        System.out.println("|surpresinha os numeros não    |");
        System.out.println("|serão escolhidos,serão gerados|");
        System.out.println("|aleatoriamente,no jogo normal |");
        System.out.println("|os numeros do jogo serão      |");
        System.out.println("|escolhidos manualmente pelo   |");
        System.out.println("|jogador, nenhum dos jogos pode|");
        System.out.println("|ter numeros maiores que 60 e  |");
        System.out.println("|e menores que 1, e nem numeros|");
        System.out.println("|repetidos.                    |");
        System.out.println("|--------Modo milionario-------|");
        System.out.println("|Como o nome sugere, nesse modo|");
        System.out.println("|o jogador ja começa com saldo |");
        System.out.println("|de R$1,000,000 para gastar em |");
        System.out.println("|mais jogos.                   |");
        System.out.println("+------------------------------+");
        int ds = Teclado.leInt("|insira algum numero para sair|");        
    }
    
    public static void infoValores()
    {
        System.out.println("+------------------------------+");
        System.out.println("|-----------Valores------------|");
        System.out.println("|Jogo de 6 numeros:R$4,50      |");
        System.out.println("|Jogo de 7 numeros:R$31,50     |");
        System.out.println("|Jogo de 8 numeros:R$126,00    |");
        System.out.println("|Jogo de 9 numeros:R$378,00    |");
        System.out.println("|Jogo de 10 numeros:R$945,00   |");
        System.out.println("|Jogo de 11 numeros:R$2079,00  |");
        System.out.println("|Jogo de 12 numeros:R$4158,00  |");
        System.out.println("|Jogo de 13 numeros:R$7722,00  |");
        System.out.println("|Jogo de 14 numeros:R$13.513,50|");
        System.out.println("|Jogo de 15 numeros:R$22.522,50|");
        System.out.println("+------------------------------+");
        int ds = Teclado.leInt("|insira algum numero para sair|");
    }
    
}
