package com.estilox.application.product;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ProductService {

	@Autowired
	public ProductRepository productRepository;
	
	@Autowired
	public ProductCategoryRepository productCategoryRepository;
	
	@Autowired
	public ProductSubCategoryRepository productSubCategoryRepository;
	
	@Autowired
	public ProductColourRepository productColourRepository; 
	
	@Autowired
	private ProductSizeRepository productSizeRepository;
	
	@Value("${image.upload.directory}")
	private String imagePathDirectory;

	
	
	
	public List<Products> getAllProducts() {
		List<Products> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	public void add(Products products) {
		productRepository.save(products);
	}
	
	public void add(ProductCategory productCategory) {
		productCategoryRepository.save(productCategory);
	}
	
	public ProductCategory getProductCategory(String categoryName) {
		return productCategoryRepository.getProductCategoryByName(categoryName);
	}

	public List<ProductCategory> getAllCategory() {
		// TODO Auto-generated method stub
		List<ProductCategory> productCategories = new ArrayList<ProductCategory>();
		productCategoryRepository.findAll().forEach(productCategories::add);
		return productCategories;
	}
	
	public Set<ProductImages> saveProductImage(MultipartFile[] filesList,Products products) {
		String fileName = null;
		int i = 0;
		Set<ProductImages> productImagesList = new HashSet<ProductImages>();
		for(MultipartFile file : filesList) {
			ProductImages productImages = new ProductImages();
			i++;
			try {
				byte[] bytes = file.getBytes();
				File dir = new File(imagePathDirectory + File.separator + products.getProductName().replace(" ", "_"));
				if (!dir.exists()) {
					dir.mkdirs();
				}
				fileName = products.getProductName()+"_"+System.currentTimeMillis()+"_"+i+".jpeg";
				productImages.setVisible(true);
				productImages.setPath(fileName);
				productImages.setProducts(products);
				productImagesList.add(productImages);
				productImages.setCreatedDate(new Date());
				productImages.setUpdatedDate(new Date());
				File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
			} catch (IOException e) {
				productImages = null;
				e.printStackTrace();
			}
		}
		productImagesList.stream().sorted(Comparator.comparing(ProductImages::getPath));
		return productImagesList;
	}

	public Products getProductObject(Long productSubCategoryId,Products products) {
		products.setProductSubCategory(productSubCategoryRepository.findOne(productSubCategoryId));
		products.setInsertedAt(new Date());
		products.setUpdatedAt(new Date());
		return products;
	}

	public void addColour(ProductColourList productColourList) {
		productColourRepository.save(productColourList);
	}
	
	public void addSize(ProductSizeList productSizeList) {
		productSizeRepository.save(productSizeList);
	}

	public List<ProductSizeList> getSizeList() {
		List<ProductSizeList> productSizeLists = new ArrayList<ProductSizeList>();
		productSizeRepository.findAll().forEach(productSizeLists::add);
		return productSizeLists;
	}

	public List<ProductColourList> getColourList() {
		List<ProductColourList> productColourLists = new ArrayList<ProductColourList>();
		productColourRepository.findAll().forEach(productColourLists::add);
		return productColourLists;
	}

	public boolean getProductByName(String productName) {
		Products products = productRepository.getProductByName(productName);
		if(products != null )
		return true;
		else
		return false;
	}
	
}
