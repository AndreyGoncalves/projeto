import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class LoonTest {
    @Test
    public void cadastrar_ERB() throws Exception {
        ERB erb = new ERB(1,11.11f,22.22f);
        assertEquals(1,erb.ID);
        assertEquals(11.11f,erb.Latitude);
        assertEquals(22.22f,erb.Longitude);


    }

    @Test
    public void remover_ERB() throws Exception {
        List<ERB> lista_erb = new ArrayList<ERB>();
        ERB erb = new ERB(1, 11.11f, 22.22f);
        lista_erb.add(erb);
        assertEquals(1, lista_erb.size());
        lista_erb.remove(erb);
        assertEquals(0, lista_erb.size());
    }
    @Test
    public void imprimir_dados_todos_ERB() throws Exception {
        List<ERB> lista_erb = new ArrayList<ERB>();
        ERB erb = new ERB(1, 11.11f, 22.22f);
        lista_erb.add(erb);
        ERB erb1 = new ERB(2, 33.33f, 44.44f);
        lista_erb.add(erb1);
        assertEquals(2, lista_erb.size());
        assertEquals(1, lista_erb.get(0).ID);
        assertEquals(33.33f, lista_erb.get(1).Latitude);

    }

    @Test
    public void imprimir_dados_especifico_balao() throws Exception {
        Balloon balloon = new Balloon(20,1.1f,2.2f);
        List<Balloon> lista_balloon = new ArrayList<Balloon>();
        Balloon balloon1 = new Balloon(8,2.2f,3.3f);
        lista_balloon.add(balloon);
        assertEquals(20, lista_balloon.get(0).ID);
        lista_balloon.add(balloon1);
        assertEquals(2.2f, lista_balloon.get(1).Latitude);

    }

    @Test
    public void lancar() throws Exception {
        Balloon balloon = new Balloon(20,1.1f,2.2f);
        List<Balloon> lista_balloon = new ArrayList<Balloon>();
        lista_balloon.add(balloon);
        assertEquals(20, lista_balloon.get(0).ID);
    }

    @Test
    public void simular_movimentação() throws Exception {
        Balloon balloon = new Balloon(20,1.1f,2.2f);
        List<Balloon> lista_balloon = new ArrayList<Balloon>();
        lista_balloon.add(balloon);
        Loon loon = new Loon();
        float deslocamento= 2;
        for(int i=0; i<lista_balloon.size(); i++){
            lista_balloon.get(i).Latitude =lista_balloon.get(i).Latitude+deslocamento;
            lista_balloon.get(i).Longitude =lista_balloon.get(i).Longitude+deslocamento;
        }
        assertEquals(3.1f, lista_balloon.get(0).Latitude);


    }

    @Test
    public void imprimir_ID_coordenadas_todos_baloes() throws Exception {
        Balloon balloon = new Balloon(20,1.1f,2.2f);
        List<Balloon> lista_balloon = new ArrayList<Balloon>();
        Balloon balloon1 = new Balloon(8,2.2f,3.3f);
        lista_balloon.add(balloon);
        assertEquals(20, lista_balloon.get(0).ID);
        lista_balloon.add(balloon1);
        assertEquals(2.2f, lista_balloon.get(1).Latitude);
        for(int i=0; i<lista_balloon.size(); i++){
            System.out.println("ID: "+lista_balloon.get(i).ID + " " + "Latitude: "+lista_balloon.get(i).Latitude +" " + "Longitude: "+lista_balloon.get(i).Longitude);
        }
        assertEquals(2.2f, lista_balloon.get(1).Latitude);

    }

    @Test
    public void simular_rota_das_mensagens() throws Exception {
    }

}
