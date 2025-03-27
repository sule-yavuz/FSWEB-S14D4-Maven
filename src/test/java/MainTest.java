import org.example.model.Bread;
import org.example.model.Chocolate;
import org.example.model.Coke;
import org.example.model.ProductForSale;
import org.example.rpg.Monster;
import org.example.rpg.Troll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.reflect.Method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ResultAnalyzer.class)
public class MainTest {

    ProductForSale bread;
    ProductForSale chocolate;
    ProductForSale coke;

    Monster troll;

    @BeforeEach
    void setUp() {
        // Doğru constructor kullanımları
        bread = new Bread(10.0, "Test Bread", "Whole Wheat");
        chocolate = new Chocolate(23.0, "Test Chocolate", 70);
        coke = new Coke(10.0, "Test Coke", false);
        troll = new Troll("Shrek", 1000, 100.0);
    }

    @DisplayName("Subclasslar Superclass değişkenlerinin değerlerine ulaşabiliyor mu?")
    @Test
    public void testProductForSaleAccessModifiers() {
        assertEquals(bread.getType(), "Bread");
        assertEquals(bread.getPrice(), 10.0);
        assertEquals(bread.getDescription(), "Test Bread");

        assertEquals(chocolate.getType(), "Chocolate");
        assertEquals(chocolate.getPrice(), 23.0);
        assertEquals(chocolate.getDescription(), "Test Chocolate");
    }

    @DisplayName("Tüm sınıflar doğru sınıftan türetilmiş mi?")
    @Test
    public void testClassInheritance() {
        assertThat(bread, instanceOf(ProductForSale.class));
        assertThat(chocolate, instanceOf(ProductForSale.class));
        assertThat(coke, instanceOf(ProductForSale.class));
    }

    @DisplayName("getSalesPrice doğru sonuçlar üretiyor mu?")
    @Test
    public void testGetSalesPrice() {
        assertEquals(bread.getSalesPrice(3), 30.0);
        assertEquals(chocolate.getSalesPrice(3), 69.0);
        assertEquals(coke.getSalesPrice(4), 40.0);
    }

    @DisplayName("showDetails methodu tanımlanmış mı?")
    @Test
    public void testShowDetails() throws NoSuchMethodException {
        Method showDetailsMethod = bread.getClass().getDeclaredMethod("showDetails");
        assertEquals(showDetailsMethod.getModifiers(), 1);
    }

    @DisplayName("Troll sınıfı doğru veri tiplerine sahip mi?")
    @Test
    public void testTrollDataTypes() {
        assertThat(troll.getName(), instanceOf(String.class));
        assertThat(troll.getHitPoints(), instanceOf(Integer.class));
        assertThat(troll.getDamage(), instanceOf(Double.class));

        assertEquals(troll.getName(), "Shrek");
        assertEquals(troll.getHitPoints(), 1000);
        assertEquals(troll.getDamage(), 100.0);
    }

    @DisplayName("attack metodu doğru çalışıyor mu?")
    @Test
    public void testAttackMethod() {
        assertEquals(troll.attack(), 155.0);
    }
}
