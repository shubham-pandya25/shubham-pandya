package com.shubham.monefy.tests;

import com.shubham.monefy.base.BaseTest;
import com.shubham.monefy.pages.CategoryPage;
import com.shubham.monefy.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IncomeCategoryTest extends BaseTest {

    @Test
    void salaryExistsInIncomeCategories() {

        HomePage home = new HomePage(driver).stabilize();

        CategoryPage category = home.openNewIncome()
                .enterAmount("1")
                .tapChooseCategory();

        boolean exists = category.isCategoryPresent("Salary");

        Assertions.assertTrue(exists,
                "Salary category was NOT found in Income categories.");
    }
}