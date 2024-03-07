import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TesteLift {

    // Verifica se o elevador não está cheio quando é criado
    @Test
    public void testarNaoCheioQuandoCriaElevador() {
        Lift elevador = new Lift(10); // Criar um elevador com 10 andares
        assertFalse(elevador.isFull()); // Verificar se o elevador não está cheio
    }

     // Verifica se o elevador está cheio após adicionar número máximo de passageiros
    @Test
    public void testarCheioAposAdicionarMaxPassageiros() {
        Lift elevador = new Lift(10, 5); // Criar um elevador com 10 andares e capacidade máxima de 5 passageiros
        elevador.addRiders(5); // Adicionar 5 passageiros (capacidade máxima)
        assertTrue(elevador.isFull()); // Verificar se o elevador está cheio
    }
    
    // Verifica se o elevador atinge a capacidade máxima após tentar adicionar passageiros acima do limite
    @Test
    public void testarCheioAposAdicionarPassageirosAcimaDoLimite() {
        Lift elevador = new Lift(10, 5); // Criar um elevador com 10 andares e capacidade máxima de 5 passageiros
        elevador.addRiders(6); // Adicionar 5 passageiros (capacidade máxima)
        assertTrue(elevador.isFull()); // Verificar se o elevador está cheio
    }

    // Verifica se o elevador não está cheio após adicionar passageiros dentro da capacidade
    @Test
    public void testarNaoCheioAposAdicionarPassageirosDentroCapacidade() {
        Lift elevador = new Lift(10, 5); // Criar um elevador com 10 andares e capacidade máxima de 5 passageiros
        elevador.addRiders(3); // Adicionar 3 passageiros (abaixo da capacidade máxima)
        assertFalse(elevador.isFull()); // Verificar se o elevador não está cheio
    }
    
 // Verifica se o método getTopFloor retorna o andar mais alto corretamente
    @Test
    public void testarGetTopFloor() {
        Lift elevador = new Lift(10); // Criar um elevador com 10 andares
        assertEquals(10, elevador.getTopFloor()); // Verificar se o método retorna o andar mais alto corretamente
    }

    // Verifica se o método getCurrentFloor retorna o andar atual corretamente
    @Test
    public void testarGetCurrentFloor() {
        Lift elevador = new Lift(10); // Criar um elevador com 10 andares
        assertEquals(0, elevador.getCurrentFloor()); // Verificar se o método retorna o andar atual corretamente (inicialmente 0)
    }

    // Verifica se o método getCapacity retorna a capacidade correta do elevador
    @Test
    public void testarGetCapacity() {
        Lift elevador = new Lift(10, 5); // Criar um elevador com 10 andares e capacidade máxima de 5 passageiros
        assertEquals(5, elevador.getCapacity()); // Verificar se o método retorna a capacidade correta do elevador
    }

    // Verifica se o método getNumRiders retorna o número de passageiros corretamente
    @Test
    public void testarGetNumRiders() {
        Lift elevador = new Lift(10); // Criar um elevador com 10 andares
        assertEquals(0, elevador.getNumRiders()); // Verificar se o método retorna 0 passageiros inicialmente
    }
    
    // Verifica se o método goUp() aumenta corretamente o andar atual quando possível
    @Test
    public void testarGoUp() {
        Lift elevador = new Lift(10); // Criar um elevador com 10 andares
        elevador.goUp(); // Subir um andar
        assertEquals(1, elevador.getCurrentFloor()); // Verificar se o método aumenta corretamente o andar atual
    }
    
 // Verifica se o método goUp() não incrementa o andar quando o elevador já está no andar máximo
    @Test
    public void testarGoUpNivelMax() {
        Lift elevador = new Lift(10); // Criar um elevador com 10 andares
        elevador.call(10); // sobe até o andar 10
        elevador.goUp(); // Tenta subir um andar
        assertEquals(10, elevador.getCurrentFloor()); // Verificar se o elevador está no andar correto
    }

    // Verifica se o método goDown() diminui corretamente o andar atual quando possível
    @Test
    public void testarGoDown() {
        Lift elevador = new Lift(10); // Criar um elevador com 10 andares
        elevador.goUp(); // Subir um andar (para não estar no térreo inicialmente)
        elevador.goDown(); // Descer um andar
        assertEquals(0, elevador.getCurrentFloor()); // Verificar se o método diminui corretamente o andar atual
    }
    
    // Verifica se o método goDown() não decrementa o andar quando o elevador já está no nível zero 
    @Test
    public void testarGoDownNivelZero() {
        Lift elevador = new Lift(10); // Criar um elevador com 10 andares
        elevador.goDown(); // Tenta sescer um andar
        assertEquals(0, elevador.getCurrentFloor()); // Verificar se o método não diminui o andar atual
    }

    // Verifica se o método call(int floor) move o elevador para o andar especificado corretamente
    @Test
    public void testarCall() {
        Lift elevador = new Lift(10); // Criar um elevador com 10 andares
        elevador.call(5); // Chamar o elevador para o andar 5
        assertEquals(5, elevador.getCurrentFloor()); // Verificar se o método move o elevador para o andar especificado corretamente
        elevador.call(1);
        assertEquals(1, elevador.getCurrentFloor());
    }
    
 // Verifica se o método call mantem o elevador no mesmo andar quando é passado um andar inválido
    @Test
    public void testarCallComValorInvalido() {
        Lift elevador = new Lift(10); // Criar um elevador com 10 andares
        elevador.call(12); // Chamar o elevador para o andar 12
        assertEquals(0, elevador.getCurrentFloor()); // Elevador deve ser mantido no térreo
    }
    
 // Verifica se o elevador não desce abaixo do térreo
    @Test
    public void testarNaoDescerAbaixoTerreo() {
        Lift elevador = new Lift(10); // Criar um elevador com 10 andares
        elevador.call(-1); // Chamar o elevador para o andar -1
        assertEquals(0, elevador.getCurrentFloor()); // Verificar se o elevador não desceu abaixo do térreo (0)
    }
}
