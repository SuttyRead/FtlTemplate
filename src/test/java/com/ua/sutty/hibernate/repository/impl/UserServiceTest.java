package com.ua.sutty.hibernate.repository.impl;

import com.ua.sutty.spring.app.Application;
import com.ua.sutty.spring.domain.Role;
import com.ua.sutty.spring.domain.User;
import com.ua.sutty.spring.service.UserService;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    private IDatabaseTester iDatabaseTester;

    @Before
    public void loadProperties() throws Exception {
        IDataSet iDataSet = new FlatXmlDataSetBuilder()
                .build(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("dataset.xml"));
        iDatabaseTester = new DataSourceDatabaseTester(dataSource);
        iDatabaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        iDatabaseTester.setDataSet(iDataSet);
        iDatabaseTester.onSetup();
    }

    @Test(expected = NullPointerException.class)
    public void testCreateNull() {
        userService.save(null);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateNull() {
        userService.save(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNull() {
        userService.delete(null);
    }

    @Test(expected = NullPointerException.class)
    public void testFindByEmailNull() {
        userService.findUserByEmail(null);
    }

    @Test(expected = NullPointerException.class)
    public void testFindByLoginNull() {
        userService.findUserByLogin(null);
    }

    @Test
    public void findUserByLogin() throws Exception {
        User user = userService.findUserByEmail("secondUser@gmail.com");
        assertEquals("User after findByLogin must coincide with role in data base",
                user.getLogin(), iDatabaseTester.getDataSet()
                        .getTable("user").getValue(1, "login"));
        assertEquals("User after findByLogin must coincide with role in data base",
                user.getEmail(), iDatabaseTester.getDataSet()
                        .getTable("user").getValue(1, "email"));
    }

    @Test
    public void findByEmail() throws Exception {
        User user = userService.findUserByEmail("firstUser@gmail.com");
        assertEquals("User after findByEmail must coincide with role in data base",
                user.getLogin(), iDatabaseTester.getDataSet().getTable("user")
                        .getValue(0, "login"));
        assertEquals("User after findByLogin must coincide with role in data base",
                user.getEmail(), iDatabaseTester.getDataSet()
                        .getTable("user").getValue(0, "email"));
    }

    @Test
    public void findById() throws Exception {
        User user = userService.findUserById(1L);
        assertEquals("User after findByEmail must coincide with role in data base",
                user.getLogin(), iDatabaseTester.getDataSet()
                        .getTable("user").getValue(0, "login"));
        assertEquals("User after findByLogin must coincide with role in data base",
                user.getEmail(), iDatabaseTester.getDataSet()
                        .getTable("user").getValue(0, "email"));
    }

    @Test
    public void testSave() throws Exception {
        User user = User.builder()
                .login("fourth")
                .password("fourth")
                .email("fourth@gmail.com")
                .firstName("fourth")
                .lastName("fourth")
                .birthday(new Date(System.currentTimeMillis()))
                .role(new Role(1L, "USER"))
                .build();
        userService.save(user);
        assertEquals(4, iDatabaseTester.getConnection().createDataSet().getTable("user").getRowCount());
        assertEquals(user.getLogin(), iDatabaseTester.getConnection().createDataSet().getTable("user").getValue(3, "login"));
        assertEquals(user.getEmail(), iDatabaseTester.getConnection().createDataSet().getTable("user").getValue(3, "email"));
    }

    @Test
    public void testDelete() throws Exception {
        User someUser = User.builder()
                .id(1L)
                .login("firstUser")
                .password("123")
                .email("firstUser@gmail.com")
                .firstName("first")
                .lastName("user")
                .birthday(Date.valueOf("1999-4-6"))
                .role(new Role(1L, "USER"))
                .build();
        userService.delete(someUser);
        assertEquals(2, iDatabaseTester.getConnection().createDataSet().getTable("user").getRowCount());
    }

    @Test
    public void testUpdate() throws Exception {
        User someUser = User.builder()
                .id(2L)
                .login("secondUser")
                .password("123")
                .email("secondUser@gmail.com")
                .firstName("second")
                .lastName("user")
                .birthday(Date.valueOf("2000-1-28"))
                .role(new Role(2L, "ADMIN"))
                .build();
        someUser.setLogin("modifiedLogin");
        userService.save(someUser);
        assertEquals(someUser, userService.findUserById(someUser.getId()));
        assertEquals(3, iDatabaseTester.getConnection().getRowCount("user"));
    }

}
