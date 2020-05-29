import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BagTest {

    private Bag bag1;

    @Before
    public void before(){
        bag1 = new Bag("Suitcase1");
    }

    @Test
    public void canGetBagType(){
        assertEquals("Suitcase1", bag1.getBagType());
    }

    @Test
    public void cenGetBagWeight(){
        assertEquals(10.00, bag1.getWeight(), 0.1);
    }
}
