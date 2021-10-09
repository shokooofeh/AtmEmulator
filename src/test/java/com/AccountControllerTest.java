package com;

import com.egs.controller.AccountController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTest {

    @Mock
//    DatabaseManager mockDatabaseManager;

    @InjectMocks
    AccountController accountController;

    final int[] bankAmount = {5, 5, 5, 5, 5};
    final int[] bankValues = {1000, 500, 100, 50, 20};

    @Before
    public void setUp(){
//        when(mockDatabaseManager.getBankAmount()).thenReturn(bankAmount);
//        when(mockDatabaseManager.getBankValues()).thenReturn(bankValues);
//        doNothing().when(mockDatabaseManager).updateBalanceAmt(any(int[].class), any(int[].class));
    }

    @Test
    public void subtractBankNumberCorrectly(){

        int[] usedBanks = {2, 1, 0, 2, 4};
        int[] balanceBanks = {5, 5, 5, 5, 5};
        int[] remainingBanks = {3, 4, 5, 3, 1};

//        int[] result = accountController.subtractBankAmt(balanceBanks, usedBanks);

//        Assert.assertArrayEquals(remainingBanks, result);
    }

    @Test
    public void calculateTotalBalanceCorrectly(){
        int[] remainingBanks = {1, 1, 1, 1, 1};
        int expectedAmt = 1670;
//        int result = accountController.calCurrentTotalAmt(remainingBanks, bankValues);
//
//        Assert.assertEquals(expectedAmt, result);
    }

    @Test
    public void findBanksCorrectly(){
        int[] currentBankAmt = new int[5];
        int[] balanceBankAmt = {10, 10, 10, 10, 10};

        List<int[]> expectedResult = new ArrayList<>();
        expectedResult.add(new int[]{0, 0, 1, 0, 4});
        expectedResult.add(new int[]{0, 0, 0, 2, 4});
        expectedResult.add(new int[]{0, 0, 0, 0, 9});

//        List<int[]> result = accountController.findBanks(180, currentBankAmt, balanceBankAmt, bankValues, 0);
//
//        Assert.assertEquals(expectedResult.size(), result.size());

//        for (int i = 0; i < result.size(); i++){
//            Assert.assertArrayEquals(result.get(i), expectedResult.get(i));
//        }
    }

    @Test
    public void calculateBankWorkCorrectlyWhenSuccess(){

        String expectedResultCode = "0";
        String expectedResultDesc = "SUCCESS";

//        ResponseEntity<ResponseWrapper> response = accountController.calculateBank(180);
//
//        Assert.assertEquals(expectedResultCode, response.getBody().getResponseCode());
//        Assert.assertEquals(expectedResultDesc, response.getBody().getResponseDesc());
    }

    @Test
    public void calculateBankWorkCorrectlyWhenFail(){

        String expectedResultCode = "1";
        String expectedResultDesc = "Amount less than min amount";

//        ResponseEntity<ResponseWrapper> response = accountController.calculateBank(10);
//
//        Assert.assertEquals(expectedResultCode, response.getBody().getResponseCode());
//        Assert.assertEquals(expectedResultDesc, response.getBody().getResponseDesc());
    }
}
