import com.grum.geocalc.Coordinate;
import com.grum.geocalc.DegreeCoordinate;
import com.grum.geocalc.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*@author Andrey Gonçalves
* @version 1.0
* */

public class Loon {
    /*Cria listas usadas para armazenar as ERB e Balões*/
    static List<ERB> lista_erb = new ArrayList<ERB>();
    static List<Balloon> lista_balloon = new ArrayList<Balloon>();
    int distancia;

    public static void main(String[] args) {
      //chama menu;
        menu();
        System.out.println("Programa fechado.");
    }
    private static void menu() {

        int opcao = 0;
        do {       /*IMPRIME MENU*/
            System.out.println("  | ===========================================================|");
            System.out.println("  | ######################## Projeto Loon #####################|");
            System.out.println("  | ===========================================================|");
            System.out.println("  |     1 - Cadastrar estação de rádio base (ERB)              |");
            System.out.println("  |     2 - Remover estação de rádio base                      |");
            System.out.println("  |     3 - Imprimir todos dados da ERB                        |");
            System.out.println("  |     4 - Imprimir dados de especifico balão                 |");
            System.out.println("  |     5 - Lançar balão                                       |");
            System.out.println("  |     6 - Simular movimentação                               |");
            System.out.println("  |     7 - Imprimir ID e as coordenadas de todos os balões    |");
            System.out.println("  |     8 - Simular rota das mensagens                         |");
            System.out.println("  |     0 - Sair                                               |");
            System.out.println("   ============================================================\n");
            System.out.println("Opção:");
            Scanner ent_opcao = new Scanner(System.in);
            opcao = ent_opcao.nextInt();                //le inteiro do teclado para selecionar opcao do menu
            Loon loon1 = new Loon();
            switch (opcao){
                case 1:
                    /*onde chama o método para cadastrar ERB*/
                    System.out.println("Digite número do ID da ERB a ser criada");
                    Scanner ent_id = new Scanner(System.in);
                    int id = ent_id.nextInt();
                    System.out.println("Digite a latitude de onde a ERB será criada");
                    Scanner lati = new Scanner(System.in);
                    float latitude = lati.nextFloat();
                    System.out.println("Digite a longitude de onde a ERB será criada");
                    Scanner lon = new Scanner(System.in);
                    float longitude = lon.nextFloat();
                    /*@param id - id da ERB a ser cadastrada
                    * @param latitude - latitude de onde a ERB vai ser cadastrada
                    * @param longitude - longitude de onde a ERB vai ser cadastrada*/
                    loon1.Cadastrar_ERB(id,latitude,longitude);
                    break;
                case 2:
                    /*onde chama o método para excluir ERB*/
                    System.out.printf("\nInforme o ID da ERB a ser excluída:\n");
                    Scanner entrada1 = new Scanner(System.in);
                    int remove_ERB = entrada1.nextInt();
                    /*@param remove_ERB - numero de indificação a ser excluido*/
                    loon1.Remover_ERB(remove_ERB);
                    break;
                case 3:
                    /*onde chama o método para imprimir todos os dados de todas ERB cadastrada*/
                    System.out.println("Os dados de todas ERB são:");
                    loon1.imprimir_dados_todos_ERB();
                    break;
                case 4:
                     /*onde chama o método para imprimir  os dados de especifica ERB cadastrada*/
                    System.out.println("Digite o ID do balão a ser listado:");
                    Scanner entrada2 = new Scanner(System.in);
                    int lst_ballon = entrada2.nextInt();
                    /*@param lst_ballon - número do indentificador a ser listado*/
                    loon1.Imprimir_dados_especifico_balao(lst_ballon);
                    break;
                case 5:
                    /*onde chama o método para lançar um balão*/
                    System.out.println("Digite a latitude de onde o balão será lançado:");
                    Scanner entrada43 = new Scanner(System.in);
                    float lat = entrada43.nextFloat();
                    System.out.println("Digite a longitude de onde o balão será lançado:");
                    Scanner entrada44 = new Scanner(System.in);
                    float longi = entrada44.nextFloat();
                    /*@param lat - latitude de onde o balão vai ser lançado
                    * @param longi - longitude de onde o balão vais er lançado*/
                    loon1.Lancar(lat,longi);
                    break;
                case 6:
                    /*onde chama o método para fazer um deslocamento horizontal dos baloes*/
                    System.out.println("Entre com o deslocamento horizontal desejado:");
                    Scanner entrada_des = new Scanner(System.in);
                    float deslocamento = entrada_des.nextFloat();
                    /*@param deslocamento - valor do deslocamento*/
                    loon1.Simular_movimentação(deslocamento);
                    break;
                case 7:
                    /*onde chama o método para imprimir ID e coordenadas de todos os baloes*/
                    System.out.println("Imprimindo ID e as coordenadas dos baloes...");
                    loon1.Imprimir_ID_coordenadas_todos_baloes();
                    break;
                case 8:
                    /*onde chama o método que simuna a rota de uma mensagem passada pelo usuario*/
                    System.out.println("simulando rota de mensagens...\n");
                    float latit = 0, llong=0;
                    String sms = null;
                    System.out.println("Digite sua latitude atual:\n");
                    Scanner entradal = new Scanner(System.in);
                    latit = entradal.nextFloat();
                    System.out.println("Digite sua longitude atual:\n");
                    Scanner entradalng = new Scanner(System.in);
                    llong = entradalng.nextFloat();
                    System.out.println("Digite String a ser enviada:\n");
                    Scanner entrada_sms = new Scanner(System.in);
                    sms = entrada_sms.next();
                    /*@param latit - latitude da posição atual
                    * @param llong longitude da posição atual
                    * @param sms - mensagem passada pelo usuário*/
                    loon1.Simular_rota_das_mensagens(latit,llong,sms);
                    break;
                case 0:
                    /*chama o método para sair do programa*/
                    loon1.Sair();
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    /*A distância mínima entre uma ERB terrestre e outra deve ser de 40km. Não existe distância máxima.
        Ou seja, não é permitido cadastrar uma ERB que esteja a uma distância menor que 40km de qualquer outra ERB
        já cadastrada. A localização de cada ERB se por coordenadas geográficas (latitude, longitude)*/
    /*@param id - parametro que numera o indificador de cada ERB
    * @param latitude - parametro da latitude aonde será cadastrada a ERB
    * @param longitude - parametro da longitude aonde será cadastrada a ERB*/
    public static boolean Cadastrar_ERB(int id,float latitude,float longitude) {
        Coordinate lat = new DegreeCoordinate(latitude);
        Coordinate lng = new DegreeCoordinate(longitude);
        Point pointer_new_erb = new Point(lat, lng); //ponto da nova ERB

        for (int i = 0; i < lista_erb.size(); i++) {  //pecorre a lista de ERB
            Coordinate latt = new DegreeCoordinate(lista_erb.get(i).Latitude);
            Coordinate lngg = new DegreeCoordinate(lista_erb.get(i).Longitude);
            Point pointer_list_erb = new Point(latt, lngg);   // pontos das erb cadastrada na lista
            if (ERB.getDistancia(pointer_new_erb, pointer_list_erb) < (double) 40000|| id == lista_erb.get(i).ID) {
                System.out.printf("A distância de um ERB para outra tem que ser maior que 40Km...\n \n");
                /*@return - se a distancia for menor q 40km*/
                return false;

            }
        }
        /*adiciona nova ERB na lista de ERB cadastradas se a mesma tiver uma distancia maior q 40km de qualquer outra ERB*/
        ERB erb = new ERB(id,latitude,longitude);
        lista_erb.add(erb);
        /*@return - se for maior q 40km */
        return true;
    }

    /*Remover estação rádio base terrestre*/
    /*@param remove_ERB - parametro passado pelo usuário para excluir ERB. no caso exclui a ERB com o ID passado pelo parametro remove_ERB*/
    public void Remover_ERB(int remove_ERB) {
        for(int i = 0;i <lista_erb.size();i++){      //pecorre lista de erb
            if(lista_erb.get(i).ID == remove_ERB){
                final ERB remove = lista_erb.remove(i);                    //remove a ERB pelo ID passado por parametro
            }
        }
    }

    /*Imprimir os dados de todas estações rádio base terrestres*/

    public void imprimir_dados_todos_ERB() {
        for(int i=0; i<lista_erb.size(); i++){
            System.out.println("ID: "+lista_erb.get(i).ID + " " + "Latitude: "+lista_erb.get(i).Latitude +" " + "Longitude: "+lista_erb.get(i).Longitude);
        }

    }

    /*Imprimir todos os dados de um balão específico Usuário fornece o identificador do balão*/
    /*@param lst_ballon - usado para definir qual ERB imprimir, ou seja, ela vai imprimir os dados da ERB cadastrada com o ID lst_ballon */
    public void Imprimir_dados_especifico_balao(int lst_balloon) {
        System.out.println("ID: " + lista_balloon.get(lst_balloon).ID + " " + "Latitude: " + lista_balloon.get(lst_balloon).Latitude + " " + "Longitude: " + lista_balloon.get(lst_balloon).Longitude);

    }

    /*Se for o primeiro balão a ser lançado, então esse não terá vizinho. Se houver algum balão lançado,
        então o sistema deverá automaticamente preencher o identificador desse como sendo vizinho do balão que está para
        ser lançado*/
/*@param lat - latitude de onde o balao será lançado
* @param longi - longitude de onde o balao será lançado
*/
    public void Lancar( float lat,float longi) {
        if(!lista_balloon.isEmpty()){
            int pos = lista_balloon.size();

            Balloon balloon = new Balloon(pos,lat,longi);
            lista_balloon.add(balloon);
            }else{
            int k=0;
            Balloon balloon = new Balloon(k,lat,longi);
            lista_balloon.add(balloon);
        }
    }

    /*Usuário fornece a unidade de deslocamento horizontal e essa é aplicada em todos os balões*/
    /*@param deslocamento - número do deslocamento horiontal a ser realizado... passado pelo user*/
    public void Simular_movimentação(float deslocamento) {
        System.out.println("O deslocamento foi efetuado...para ver selecione a opção 7\n");
        for(int i=0; i<lista_balloon.size(); i++){
            lista_balloon.get(i).Latitude =lista_balloon.get(i).Latitude+deslocamento; // sobreescreve as latitudes na lista de baloes somando com o deslocamento
            lista_balloon.get(i).Longitude =lista_balloon.get(i).Longitude+deslocamento;// sobreescreve as longitudes na lista de baloes somando com o deslocamento
        }
    }
    /*método que imprime todos os dados de todos os balões cadastrados*/
    public void Imprimir_ID_coordenadas_todos_baloes() {
        for(int i=0; i<lista_balloon.size(); i++){
            System.out.println("ID: "+lista_balloon.get(i).ID + " " + "Latitude: "+lista_balloon.get(i).Latitude +" " + "Longitude: "+lista_balloon.get(i).Longitude);
        }
    }

    /****Simular o usuário enviando uma mensagem e essa sendo entregue em uma ERB
     A - O usuário fornecerá a sua localização e o conteúdo da mensagem a ser enviada. O sistema deverá
     automaticamente enviar a mensagem para o balão mais próximo do usuário
     B - Deve-se imprimir a rota percorrida pela mensagem até ser entregue na ERB
     (i.e. identificadores dos balões por onde passou a mensagem)*/
    public void Simular_rota_das_mensagens(float latitude,float longitude, String mensagem) {

    }
/*metodo para sair do programa*/
    public void Sair() {
        System.exit(0);
    }

}