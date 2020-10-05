package com.github.patriquejarry;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.patriquejarry.entities.Product;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@DBRider
@QuarkusTest
@QuarkusTestResource(DatabaseLifecycle.class)
public class ProductTest {

	@Test
	@DataSet("product_one.yml")
	public void testOne() {
		Assert.assertEquals(1, Product.count());

	}

}