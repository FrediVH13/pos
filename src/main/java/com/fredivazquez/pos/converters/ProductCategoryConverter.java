package com.fredivazquez.pos.converters;

import com.fredivazquez.pos.models.ProductCategory;
import com.fredivazquez.pos.services.ProductCategoryService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "productCategoryConverter", forClass = ProductCategory.class)
public class ProductCategoryConverter implements Converter {

    private final ProductCategoryService productCategoryService;

    ProductCategoryConverter(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }



    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return productCategoryService.getProductCategoryByName(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof ProductCategory productCategory) {
            return productCategory.getCategoryName();
        }
        return null;
    }
}
