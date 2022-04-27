package com.fredivazquez.pos.services;

import com.fredivazquez.pos.exceptions.PosException;
import com.fredivazquez.pos.models.ProductTag;
import com.fredivazquez.pos.repository.ProductTagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTagServiceImpl implements IProductTagService {

    private final ProductTagRepository repository;

    public ProductTagServiceImpl(ProductTagRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductTag> getProductTags() {
        return repository.findAll();
    }

    @Override
    public ProductTag updateProductTag(ProductTag newProductTag, Long id) {
        return repository.findById(id).map(productTag -> {
            productTag.setProduct(newProductTag.getProduct());
            productTag.setTag(newProductTag.getTag());
            return repository.save(productTag);
        }).orElseThrow(() -> new PosException(id));
    }

    @Override
    public void deleteProductTag(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void saveProductTag(ProductTag productTag) {
        repository.save(productTag);
    }

    @Override
    public void saveProductTags(List<ProductTag> productTags) {
        repository.saveAll(productTags);
    }
}
