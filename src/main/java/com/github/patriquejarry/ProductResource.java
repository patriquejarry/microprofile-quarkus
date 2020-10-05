package com.github.patriquejarry;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.patriquejarry.dtos.ProductDTO;
import com.github.patriquejarry.entities.Product;

@Path("products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

	@GET
	public List<Product> readProducts() {
		return Product.listAll();
	}

	@POST
	@Transactional
	public void createProduct(ProductDTO dto) {
		Product product = new Product();
		product.name = dto.name;
		product.value = dto.value;
		product.persist();
	}

	@PUT
	@Path("{id}")
	@Transactional
	public void updateProduct(@PathParam("id") Long id, ProductDTO dto) {

		Optional<Product> productOp = Product.findByIdOptional(id);
		if (!productOp.isPresent()) {
			throw new NotFoundException();
		}

		Product product = productOp.get();
		product.name = dto.name;
		product.value = dto.value;
		product.persist();
	}

	@DELETE
	@Path("{id}")
	@Transactional
	public void deleteProduct(@PathParam("id") Long id) {

		Optional<Product> productOp = Product.findByIdOptional(id);
		productOp.ifPresentOrElse(Product::delete, () -> {
			throw new NotFoundException();
		});
	}

}
