package org.test;

import org.dao.EmployDao;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EmployMockTest {

    @Mock
    private EmployDao employDaoMock;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

}
