package org.test;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class EmployServiceTest {
    @Test
    public void testMockList() {
        // Create a mock list
        List<String> mockList = mock(List.class);

        // Define behavior
        when(mockList.get(0)).thenReturn("Hello Mockito");

        // Verify behavior
        System.out.println(mockList.get(0));  // Output: Hello Mockito
        verify(mockList).get(0);
    }
}
