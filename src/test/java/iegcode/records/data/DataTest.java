package iegcode.records.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @Test
    void generic() {
        var data = new Data<String>("Gibran");
        assertEquals("Gibran", data.data());

        var data2 = new Data<Integer>(100);
        assertEquals(100, data2.data());
    }
}