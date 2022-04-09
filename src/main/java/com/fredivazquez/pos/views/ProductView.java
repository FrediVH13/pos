package com.fredivazquez.pos.views;

import com.fredivazquez.pos.models.Product;
import com.fredivazquez.pos.models.ProductBrand;
import com.fredivazquez.pos.models.ProductCategory;
import com.fredivazquez.pos.models.Status;
import com.fredivazquez.pos.services.ProductBrandService;
import com.fredivazquez.pos.services.ProductCategoryService;
import com.fredivazquez.pos.services.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ManagedBean
@Component
@ViewScoped
public class ProductView implements Serializable {

    private List<Product> products;
    private List<ProductCategory> productCategories;
    private List<ProductBrand> productBrands;
    private Status[] statuses;
    private Product newProduct;
    private final ProductService productService;
    private final ProductCategoryService productCategoryService;
    private final ProductBrandService productBrandService;

    ProductView (ProductService productService, ProductCategoryService productCategoryService, ProductBrandService productBrandService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
        this.productBrandService = productBrandService;
    }

    @PostConstruct
    public void init() {
        this.products = this.productService.getProducts();
        this.productCategories = this.productCategoryService.getProductCategories();
        this.productBrands = this.productBrandService.getProductBrands();
        this.statuses = Status.values();
    }

    public void openNew() {
        this.newProduct = new Product();
        PrimeFaces.current().ajax().update("form:manage-product-content");
    }

    public void saveProduct() {
        Product product;
        if (this.newProduct.getProductId() == null) {
            product = this.productService.saveProduct(newProduct);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added", product.toString()));
        }
        this.products = this.productService.getProducts();
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String statusSeverity(Status status) {
        String result = "success";
        switch (status) {
            case IN_STOCK -> result = "success";
            case LOW_STOCK -> result = "warning";
            case OUT_OF_STOCK -> result = "danger";
        }
        return result;
    }

    public List<Product> getProducts() {
        return this.productService.getProducts();
    }

    public List<ProductBrand> getProductBrands() {
        return this.productBrandService.getProductBrands();
    }

    public List<ProductCategory> getProductCategories() {
        return this.productCategoryService.getProductCategories();
    }

    public Status[] getStatuses() {
        return Status.values();
    }

    public void onRowEdit(RowEditEvent<Product> event) {

    }

    public void onRowCancel(RowEditEvent<Product> event) {

    }
}
