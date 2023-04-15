import java.util.*;
import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.*;


public class AgentSimulationTests {

    @Test
    public void testSimulationExample() {

        // this is the test of the example, feel free to modify it
        // this test does not really concern your TODO tasks

        List contacts = new LinkedList();
        contacts.add(new int[]{0,1});
        contacts.add(new int[]{1,3});
        contacts.add(new int[]{1,2});
        contacts.add(new int[]{2,6});
        contacts.add(new int[]{6,3});
        contacts.add(new int[]{4,3});
        contacts.add(new int[]{0,4});
        contacts.add(new int[]{4,5});
        contacts.add(new int[]{5,6});
        contacts.add(new int[]{5,7});
        contacts.add(new int[]{6,7});

        AgentSimulation as = new AgentSimulation(8,contacts);
        as.population[1].contaminateUnlessImmune();

        assertTrue(!as.population[1].isImmune());
        assertTrue(as.population[1].isContaminated());
        assertTrue(!as.population[1].isContagious());


        as.simulateOneDay(); // time 1

        assertTrue(!as.population[1].isImmune());
        assertTrue(as.population[1].isContaminated());
        assertTrue(as.population[1].isContagious());

        as.simulateOneDay(); // time 2

        assertTrue(!as.population[1].isImmune());
        assertTrue(as.population[1].isContaminated());
        assertTrue(as.population[1].isContagious());

        as.simulateOneDay(); // time 3

        assertTrue(!as.population[1].isImmune());
        assertTrue(as.population[1].isContaminated());
        assertTrue(as.population[1].isContagious());

        as.simulateOneDay(); // time 4

        assertTrue(as.population[1].isImmune());
        assertTrue(!as.population[1].isContaminated());
        assertTrue(!as.population[1].isContagious());


        as.simulateOneDay(); // time 5

        as.simulateOneDay(); // time 6

        for (int i : new int [] {0,1,2,3,4,6}) {
            assertTrue(as.population[i].isImmune());
            assertTrue(!as.population[i].isContaminated());
            assertTrue(!as.population[i].isContagious());
        }

        for (int i : new int [] {5,7}) {

            assertTrue(!as.population[i].isImmune());
            assertTrue(as.population[i].isContaminated());
            assertTrue(as.population[i].isContagious());
        }




    }


    @Test
    public void testObserverBasic() {

        List<int[]> contacts = new LinkedList<>();
        contacts.add(new int[] {0,1});
        contacts.add(new int[] {1,2});
        contacts.add(new int[] {2,3});

        AgentSimulation as = new AgentSimulation(4,contacts);

        int [] cpt = new int[] {0,0};
        as.addContaminationListener(p -> {
            cpt[0] += 1;
        });

        // set the first person as contaminated
        as.population[0].contaminateUnlessImmune();

        assertEquals(as.currentTime(),0);

        as.addContaminationListener(p -> {
            cpt[1] += 1;
            if (as.currentTime() == 0){
                assertTrue(p == as.population[1]);
            }
            if (as.currentTime() == 2){
                assertTrue(p == as.population[2]);
            }
            if (as.currentTime() == 3){
                assertTrue(p == as.population[3]);
            }
        });

        as.simulateOneDay();// t=0, incubation of population[0] contaminated
        as.simulateOneDay();// t=1, 1 is contaminated
        as.simulateOneDay();// t=2, 2 is contaminated
        as.simulateOneDay();// t=3, 3 is contaminated

        assertEquals(4,as.currentTime());

        assertEquals(cpt[0],4);
        assertEquals(cpt[1],3);


    }

    @Test
    public void testObserverExample() {


        List contacts = new LinkedList();
        contacts.add(new int[]{0,1});
        contacts.add(new int[]{1,3});
        contacts.add(new int[]{1,2});
        contacts.add(new int[]{2,6});
        contacts.add(new int[]{6,3});
        contacts.add(new int[]{4,3});
        contacts.add(new int[]{0,4});
        contacts.add(new int[]{4,5});
        contacts.add(new int[]{5,6});
        contacts.add(new int[]{5,7});
        contacts.add(new int[]{6,7});

        AgentSimulation as = new AgentSimulation(8,contacts);


        List<Integer> contaminated = new LinkedList<>();
        as.addContaminationListener(p -> contaminated.add(p.id));

        as.population[1].contaminateUnlessImmune();

        System.out.println(as);

        as.simulate(4);
        for (int i = 0; i < 8; i++) {
            contaminated.contains(i);
        }

        assertEquals(8,contaminated.size());

    }



    @Test
    public void testChainOfContaminationBasic() {

        List<int[]> contacts = new LinkedList<>();
        contacts.add(new int[] {0,1});
        contacts.add(new int[] {1,2});
        contacts.add(new int[] {2,3});

        AgentSimulation as = new AgentSimulation(4,contacts);

        // set the first person as contaminated
        as.population[0].contaminateUnlessImmune();


        as.simulateOneDay();// t=0, incubation of population[0] contaminated
        as.simulateOneDay();// t=1, 1 is contaminated
        as.simulateOneDay();// t=2, 2 is contaminated
        as.simulateOneDay();// t=3, 3 is contaminated


        assertEquals(Arrays.asList(),as.population[0].chainOfContamination());
        assertEquals(Arrays.asList(as.population[0]),as.population[1].chainOfContamination());
        assertEquals(Arrays.asList(as.population[0],as.population[1]),as.population[2].chainOfContamination());
        assertEquals(Arrays.asList(as.population[0],as.population[1],as.population[2]),as.population[3].chainOfContamination());

    }


    @Test
    public void testChainOfContaminationExample() {

        List contacts = new LinkedList();
        contacts.add(new int[]{0,1});
        contacts.add(new int[]{1,3});
        contacts.add(new int[]{1,2});
        contacts.add(new int[]{2,6});
        contacts.add(new int[]{6,3});
        contacts.add(new int[]{4,3});
        contacts.add(new int[]{0,4});
        contacts.add(new int[]{4,5});
        contacts.add(new int[]{5,6});
        contacts.add(new int[]{5,7});
        contacts.add(new int[]{6,7});

        AgentSimulation as = new AgentSimulation(8,contacts);
        as.population[1].contaminateUnlessImmune();
        as.simulate(4);

        assertEquals(Arrays.asList(as.population[1],as.population[2],as.population[6]),as.population[7].chainOfContamination());
        assertEquals(Arrays.asList(as.population[1],as.population[3],as.population[4]),as.population[5].chainOfContamination());


    }




}

