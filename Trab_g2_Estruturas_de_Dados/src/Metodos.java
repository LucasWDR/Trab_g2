import java.util.List;
import java.util.Scanner;

public class Metodos {

    Scanner tc = new Scanner(System.in);

    public Aluno new_Aluno() {

        Aluno dadosAluno = new Aluno();

        dadosAluno.cod=Utils.valid_num("Codigo do Aluno:");
        System.out.println("Nome do aluno:");
        dadosAluno.nome=tc.next();
        dadosAluno.email =Utils.lerEmail();
        dadosAluno.telefone =Utils.lerTelefone();
        System.out.println("A Nota da G1:");
        dadosAluno.g1=tc.nextDouble();
        System.out.println("A Nota da G2:");
        dadosAluno.g2=tc.nextDouble();

        dadosAluno.media_final=(dadosAluno.g1 +(dadosAluno.g2*2))/3;

    return (dadosAluno);
    }

    public void imprimir(Aluno sc){
        System.out.println("\n");
        System.out.println("Codigo do aluno:"+ sc.cod);
        System.out.println("Nome:"+ sc.nome);
        System.out.println("Email do Aluno:"+ sc.email);
        System.out.println("Telefone:"+ sc.telefone);
        System.out.println("Nota da G1:"+ sc.g1);
        System.out.println("Nota da G2:"+ sc.g2);
        System.out.println("Media Final:"+ sc.media_final);
    }
    public void adc_esquerda(Lista list){
        Aluno novo_Aluno;
        Aluno aux;
        char resp;
        System.out.println("Coolocar no comeco da lista:");
        do{
            if(list.quant==0){
                novo_Aluno=new_Aluno();

                novo_Aluno.bj= null;

                list.primeiro= novo_Aluno;
                list.ultimo = novo_Aluno;
                list.quant++;
            }
            else{
                aux=list.primeiro;
                novo_Aluno=new_Aluno();
                novo_Aluno.bj=aux;
                list.primeiro=novo_Aluno;
                list.quant++;
            }
            System.out.println("Aluno incluido com Sucesso!!");
            System.out.println("Deseja Incluir mais ? (S / N)");
            resp=tc.next().toUpperCase().charAt(0);
        }while ((resp=='S') || (resp=='s'));
    }
    public void adc_direita(Lista list){
        Aluno novo_Cont;
        Aluno aux;
        char resp;

        System.out.println(" Colocar no Final");
        do{
            if (list.quant==0){
                novo_Cont= new_Aluno();

                novo_Cont.bj=null;

                list.primeiro=novo_Cont;
                list.ultimo=novo_Cont;
                list.quant++;
            }
            else{
                aux=list.primeiro;

                while (aux.bj !=null){
                    aux=aux.bj;
                }
                novo_Cont=new_Aluno();
                novo_Cont.bj=null;

                aux.bj=novo_Cont;
                list.ultimo=novo_Cont;
                list.quant++;
                }
            System.out.println("Aluno incluido com Sucesso!!");
            System.out.println("Deseja Continuar adicionando ?( S / N)");
            resp =tc.next().toUpperCase().charAt(0);

        }while(( resp =='S') || (resp == 's'));

    }

    public void adc_apos_nome(Lista lista){

        Aluno aux;
        Aluno novoAluno;
        String nome;

        System.out.println("inclusão após o nome");
        System.out.println("Nome:");
        nome=tc.next();

        aux=lista.primeiro;
        while(aux != null){
            if(nome.toUpperCase().equals(aux.nome.toUpperCase())){
                novoAluno= new_Aluno();
                novoAluno.bj=aux.bj;
                aux.bj=novoAluno;
                lista.quant++;
                System.out.println("Aluno foi incluido após o nome" +nome);
                if(novoAluno.bj== null){
                    lista.ultimo=novoAluno;
                }
                break;
            }
            else{
                aux=aux.bj;
                if(aux.bj==null){
                    System.out.println("Aluno não foi encontrado!!");
                }
            }
        }
    }

    public  void consulta_Nome(Lista lista){

        Aluno aux;
        String nome;

        System.out.println("Consulte por nome");
        System.out.println("Nome:");
        nome= tc.next();

        aux=lista.primeiro;
        while(aux != null){
            if(nome.toUpperCase().equals(aux.nome.toUpperCase())){
                imprimir(aux);
                System.out.println("Média das notas:"+aux.media_final);
                break;
            }
            else{
                aux= aux.bj;
                if(aux.bj ==null){
                    System.out.println("Aluno não encontrado!!");
                }
            }
        }
    }
    public void ExcluiDireita(Lista lista){

        System.out.println("Exclui do fim");

        Aluno aux = lista.primeiro;
        Aluno remover =lista.ultimo;

        if(lista.quant==0){
            System.out.println("Lista vazia!");
        }
        else if(lista.quant==1){
            lista.primeiro=null;
            lista.ultimo=null;
            lista.quant--;
        }

        while(aux.bj !=lista.ultimo){
            if(aux.bj== remover){
            aux.bj=null;
            lista.quant--;
            lista.ultimo=aux;
                System.out.println("Aluno removido com Sucesso!!");

            }else{
                aux=aux.bj;
            }
        }

    }
    public void Excluir_Esquerda(Lista lista){

        Aluno aux;

        aux=lista.primeiro;
        lista.primeiro=aux.bj;
        lista.quant--;
    }
    public void Excluir_por_codigo(Lista lista){

        Aluno aux;
        int codigo;
        System.out.println("Excluir por codigo");
        codigo=Utils.valid_num("Código:");

        aux=lista.primeiro;
        if(codigo==aux.cod){
            lista.primeiro=aux.bj;
            lista.quant--;
            System.out.println("Aluno excluido com sucesso!!");
        }
        else{
            while(aux.bj != null){
                if(codigo== aux.bj.cod){
                    Aluno aux1=aux.bj;
                    lista.quant--;
                    if(aux.bj==null){
                        lista.ultimo=aux;
                    }
                    System.out.println("Aluno excluido!!");
                    break;
                }else{
                    aux=aux.bj;
                    if (aux.bj==null){
                        System.out.println("Aluno não econtrado");
                    }
                }
            }
        }
    }

    public void listar_Registro(Lista lista){

        Aluno correrLista=lista.primeiro;
        System.out.println("Quantidade de Regisitros" + lista.quant);

        if(correrLista.bj== null){
            imprimir(correrLista);
        }
        else{
            while(correrLista !=null){
                imprimir(correrLista);
                correrLista=correrLista.bj;
            }
        }

    }

    public void listar_mediasfinais(Lista lista){
        Aluno correrLista=lista.primeiro;

        if (correrLista.bj==null){
            imprimir(correrLista);
            System.out.println("Medias dos Alunos:"+ correrLista.media_final);
        }
        else{
            while (correrLista!= null){
                imprimir(correrLista);
                System.out.println("Medias dos Alunos:"+correrLista);
                System.out.println("\n");
                correrLista=correrLista.bj;
            }
        }
    }



}
