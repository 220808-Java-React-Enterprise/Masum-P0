package models;
import models.*;
import Daos.*;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class UserserviceTest  {
    private Userservice sut; // sut = system under test
    private final UserDaos mockUserDao = mock(UserDaos.class);

    /* jank constructor */
    @Before
    public void setup() {
        sut = new Userservice(mockUserDao);
    }


    @Test
    public void test_isValidUsername_givenCorrectUsername() {

        String validUsername = "ChickenWings!234";


        boolean TheTruth = sut.isValidUsername(validUsername);


        Assert.assertTrue(TheTruth);
    }
    @Test
    public void test_isValidUsername_givenInCorrectUsername() {

        String validUsername = "barber";


        boolean TheTruth = (sut.isValidUsername(validUsername));


        Assert.assertTrue(TheTruth);
    }
    @Test
    public void test_isInvalidPassword_givenInCorrectPassword() {

        String validPassword = "popular";


        boolean TheTruth = sut.isValidPassword(validPassword);


        Assert.assertTrue(TheTruth);
    }
    @Test
    public void test_isValidPassword_givenCorrectPassword() {

        String validPassword = "barberMo!123";


        boolean TheTruth = sut.isValidPassword(validPassword);


        Assert.assertTrue(TheTruth);
    }

    @Test
    public void test_isValidEmail_givenCorrectEmail(){
        String validEmail="Whereisthelove@gmail.com";
        boolean TheTruth=sut.isValidEmail(validEmail);
        Assert.assertTrue(TheTruth);
    }
    @Test
    public void test_isValidEmail_givenCorrectInEmail2(){
        String validEmail="BULGOGI";
        boolean TheTruth=!sut.isValidEmail(validEmail);
        Assert.assertTrue(TheTruth);
    }
    @Test
    public void test_isinValidEmail_givenInCorrectEmail(){
        String validEmail="SHAZAAAAAM";
        boolean TheTruth=!(sut.isValidEmail(validEmail));
        Assert.assertTrue(TheTruth);
    }
    public void test_isinValidEmail_givenInCorrectEmail2(){
        String validEmail="Batman";
        boolean TheTruth=!(sut.isValidEmail(validEmail));
        Assert.assertTrue(TheTruth);
    }
    @Test
    public void UserDaosTest() {
        // Arrange
        Userservice spiedSut = Mockito.spy(sut);
        String newUsername = "50021Days";
        String newPassword = "Andover100weeks";
        when(spiedSut.isValidUsername(newUsername)).thenReturn(true);
        when(spiedSut.isValidPassword(newPassword)).thenReturn(true);
        when(mockUserDao.getUserByUsernameAndPassword(newUsername, newPassword)).thenReturn(new Users());

        // Act
        Users user = spiedSut.Loging(newUsername, newPassword);

        // Assert
        Assert.assertNotNull(user);
    }
    @Test
    public void UserDaosTestCorrect() {
        // Arrange
        Userservice spiedSut = Mockito.spy(sut);
        String newUsername = "claim";
        String newPassword = "yours";
        when(spiedSut.isValidUsername(newUsername)).thenReturn(true);
        when(spiedSut.isValidPassword(newPassword)).thenReturn(true);
        when(mockUserDao.getUserByUsernameAndPassword(newUsername, newPassword)).thenReturn(new Users());

        // Act
        Users user = spiedSut.Loging(newUsername, newPassword);

        // Assert
        Assert.assertNotNull(user);
    }

    }

