package com.example.projectCode.controller;


import java.io.ByteArrayOutputStream;
import java.io.IOException;


import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
//import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.projectCode.entity.ProductDetails;
import com.example.projectCode.repository.ProductDetailsRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin("*")
@RequestMapping(path = "/api/productDetails")
public class ProductDetailsController {
	
	@Autowired
	ProductDetailsRepository productRepository;
	
	
	
	//Get All Product
	

	@GetMapping("AllProducts")
	public  List<ProductDetails> getAllProduct(){
		
		
		
		return productRepository.findAll() ;
	}
	
	//Add New Product 
	
	@PostMapping("/productDetailsImage" )
	//@Consumes(MediaType.MULTIPART_FORM_DATA)
	public org.springframework.http.ResponseEntity.BodyBuilder uploadProductDetails(@RequestParam("file") MultipartFile file,
			@RequestParam("productName") String productName,
			@RequestParam("productId") String productId,
			@RequestParam("productDescription") String productDescription,
			@RequestParam("productPrice") Double productPrice,
			@RequestParam("productCategory") String productCategory)throws IOException {
	
	System.out.println("Original Image Byte Size - " + file.getBytes().length);
	
	
	  ProductDetails products=new ProductDetails(
			  productName,
			  productId,
			  productDescription,
			  productPrice,
			  file.getContentType(),
			  file.getOriginalFilename(),
			  file.getBytes(),
			  
			  productCategory
			 
			 );
	
	//compressBytes(file.getBytes()),
	  productRepository.save(products);
	  return null;
	
	
	}
	
	
	//get product by ProductName
	
	@GetMapping(path = {"get/{productName}"})
	public ProductDetails getProduct(@RequestParam("productName") String productName) throws IOException
	{
		final Optional<ProductDetails> retrievedProduct = Optional.ofNullable(productRepository.findByproductName(productName));
		
		ProductDetails product=new ProductDetails(
				retrievedProduct.get().getProductName(),
				retrievedProduct.get().getProductDescription(),
				retrievedProduct.get().getProductId(),
				retrievedProduct.get().getProductPrice(),
				retrievedProduct.get().getType(),
				retrievedProduct.get().getName(),
				decompressBytes(retrievedProduct.get().getPicByte()),
				retrievedProduct.get().getProductCategory()
			
				);
		
		return product;
	}
	
	
	//Update Product By Id
	
	@PutMapping("/{id}")
	public org.springframework.http.ResponseEntity.BodyBuilder updateProduct(
			@RequestParam("id") long id,
			@RequestParam("file") MultipartFile file,
			@RequestParam("productName") String productName,
			@RequestParam("productId") String productId,
			@RequestParam("productDescription") String productDescription,
			@RequestParam("productPrice") Double productPrice,
			@RequestParam("productCategory") String productCategory	)throws IOException {
			
		
	
				
	ProductDetails oldProduct= productRepository.findById(id);
	
	oldProduct.setProductName(productName);
	oldProduct.setProductId(productId);
	oldProduct.setProductDescription(productDescription);
	oldProduct.setProductPrice(productPrice);
	oldProduct.setType(file.getContentType());
	oldProduct.setName(file.getOriginalFilename());
	oldProduct.setPicByte(file.getBytes());
	oldProduct.setProductCategory(productCategory);
	
	
	ProductDetails updateProduct=productRepository.save(oldProduct);
		
		
						
			return ResponseEntity(updateProduct, HttpStatus.OK);
	}
	
	private BodyBuilder ResponseEntity(ProductDetails updateProduct, HttpStatus ok) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	// Delete product by primary key -Id
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductDetails> deleteProduct(
			@PathVariable("id") long id)throws IOException {
		ProductDetails deleteProduct=this.productRepository.findById(id);
		this.productRepository.delete(deleteProduct);
		return ResponseEntity.ok().build();
		
	}
	
	
	@GetMapping("/{id}")
	public org.springframework.http.ResponseEntity<Optional<ProductDetails>> getProductById(@PathVariable Long id) throws IOException {
		Optional<ProductDetails> gotProduct = productRepository.findById(id);
				
		return ResponseEntity.ok(gotProduct);
	}
	
	
	
	// find by Category
	
	@GetMapping("getCategory/{productCategory}")
	public List<ProductDetails> getByCategory(@RequestParam("productCategory") String productCategory) throws IOException {
		
	 
		
		productRepository.findByProductCategory(productCategory);
				return null;
	
}


	




	// compress the image bytes before storing it in the database
		public static byte[] compressBytes(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

			return outputStream.toByteArray();
		}

		// uncompress the image bytes before returning it to the angular application
		public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}
	
	
}
