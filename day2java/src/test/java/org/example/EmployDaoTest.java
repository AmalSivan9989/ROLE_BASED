package org.example;

import org.hexa.dao.EmployDao;
import org.hexa.dao.EmployDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class EmployDaoTest {
    private EmployDao employDaoMock;

    @Before
    public void setUp(){
        employDaoMock=new EmployDaoImpl();
    }
    @Test
    public void testShowEmployDao() throws SQLException {
        assertEquals(9,employDaoMock.showEmployDao().size());
    }
}
