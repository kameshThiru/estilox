package com.estilox.application.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.estilox.application.entityModel.ProductCategory;
import com.estilox.application.entityModel.ProductColourList;
import com.estilox.application.entityModel.ProductService;
import com.estilox.application.entityModel.ProductSizeList;
import com.estilox.application.entityModel.ProductSubCategory;
import com.estilox.application.entityModel.Products;
import com.google.gson.Gson;

@CrossOrigin
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService; 
	
	@PostMapping(name="/addProduct",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String saveProducts(@RequestParam(value="file") MultipartFile[] filesList,
								@RequestParam(value="productObj") String productObj,
								@RequestParam(value="subCategoryId") String subCategoryId){
		Gson gson = new Gson();
		Products products = gson.fromJson(productObj.toString(), Products.class);
		if(productService.getProductByName(products.getProductName())) {
			return "Product already exists.";
		}
		products = productService.getProductObject(Long.valueOf(subCategoryId),products);
		products.setProductPictures(productService.saveProductImage(filesList,products));
		productService.add(products);
		return "Submitted Successfully";
	}
	
	@RequestMapping("/getProducts")
	public List<Products> getProducts(){
		return productService.getAllProducts();
	}

	
	/**
	 * Add Category
	 * @param productCategory
	 * @return productCategory
	 */
	
	@PostMapping("/addCategory")
	public ProductCategory saveCategory(@RequestBody ProductCategory productCategory) {
		ProductCategory productCategoryDbObj = productService.getProductCategory(productCategory.getCategoryName());
		if(productCategoryDbObj != null) {
			for(ProductSubCategory productSubCategoryItr: productCategory.getProductSubCategory()) {
				productSubCategoryItr.setProductCategory(productCategoryDbObj);
			}
			productCategoryDbObj.getProductSubCategory().addAll(productCategory.getProductSubCategory());
			Set<ProductSubCategory> productSubCategories = productCategoryDbObj.getProductSubCategory();
			productSubCategories = productSubCategories.stream().collect(
					Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ProductSubCategory::getSubCategoryName,Comparator.nullsLast(Comparator.naturalOrder())))));
			productCategoryDbObj.setProductSubCategory(productSubCategories);
			productService.add(productCategoryDbObj);
			return productCategoryDbObj;
		}else {
			productCategory.getProductSubCategory().stream().forEach(productSubCategory -> productSubCategory.setProductCategory(productCategory));
			productService.add(productCategory);
			return productCategory;
		}
	}
	
	
	/**
	 * GetAllProductCategory
	 * @return List<ProductCategory>
	 */
	@GetMapping("/getProductCategoryList")
	public List<ProductCategory> getProductCategory() {
		return productService.getAllCategory();
	}
	
	
	@PostMapping(value="/addColours")
	public String addColour(@RequestBody ProductColourList productColourList){
		productService.addColour(productColourList);
		return "Added Colours";
	}
	
	@GetMapping(value="/getColoursList")
	public List<ProductColourList> getColoursList(){
		return productService.getColourList();
	}
	
	@PostMapping(value="/addSizes")
	public String addSizes(@RequestBody ProductSizeList productSizeList) {
		productService.addSize(productSizeList);
		return "Added Sizes";
	}
	
	@GetMapping(value="/getSizeList")
	public List<ProductSizeList> addColour(){
		return productService.getSizeList();
	}
	
	@GetMapping(value="/getProductsByCategory/{categoryName}")
	public List<Products> getProductListByCategory(@PathVariable("categoryName") String categoryName){
		List<Products> products = productService.getProductByCategoryName(categoryName.trim());
		return products;
	}
	
	@GetMapping(value="/getProductDetails/{id}")
	public Products getProductDetails(@PathVariable("id") Long id) {
		return productService.getProductDetails(id);
	}
	
}