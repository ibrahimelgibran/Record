package iegcode.records.data;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.RecordComponent;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void createNewRecord() {
        var customer = new Customer("1", "Gibran", "gibran@gmail.com", "081234567");
        assertNotNull(customer);

        System.out.println(customer);
    }

    @Test
    void getProperty() {
        var customer = new Customer("1", "Gibran", "gibran@gmail.com", "081234567");
        assertEquals("1", customer.id());
        assertEquals("Gibran", customer.name());
        assertEquals("gibran@gmail.com", customer.email());
        assertEquals("081234567", customer.phone());
        System.out.println(customer);
    }

    @Test
    void constructor() {
        var customer = new Customer("1", "Gibran", "gibran@gmail.com", "081234567");
        assertEquals("1", customer.id());
        assertEquals("Gibran", customer.name());
        assertEquals("gibran@gmail.com", customer.email());
        assertNotNull(customer);
    }

    @Test
    void canonicalConstructor() {
        var customer = new Customer("1", "Gibran", "GIBRAN@GMAIL.COM");
        assertEquals("1", customer.id());
        assertEquals("Gibran", customer.name());
        assertEquals("gibran@gmail.com", customer.email());
        assertNotNull(customer);
    }

    @Test
    void recordMethod() {
        var customer = new Customer("1", "Gibran", "GIBRAN@GMAIL.COM");
        assertEquals("Hello Ci, my name is Gibran", customer.sayHello("Ci"));
    }


    @Test
    void recordEquals() {
        var customer1 = new Customer("1", "Gibran", "gibran@gmail.com");
        var customer2 = new Customer("1", "Gibran", "gibran@gmail.com");

        assertTrue(customer1.equals(customer2));
        assertEquals(customer1.hashCode(), customer2.hashCode());
        assertEquals(customer1.toString(), customer2.toString());
    }

    @Test
    void reflection() {
        assertTrue(Customer.class.isRecord());

        RecordComponent[] components = Customer.class.getRecordComponents();
        assertEquals(4, components.length);

        for (RecordComponent component : components){
            System.out.println(component.getName());
            System.out.println(component.getType());
        }
    }


}