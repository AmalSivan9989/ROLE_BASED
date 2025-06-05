package org.example;

import org.hexa.dao.EmployDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EmployDaoMockTest {
    @Mock
    private EmployDao employDaoMock;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


}
