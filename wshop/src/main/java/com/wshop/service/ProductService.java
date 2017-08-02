package com.wshop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wshop.dao.CategoryMapper;
import com.wshop.dao.ProductDetailsMapper;
import com.wshop.dao.ProductMapper;
import com.wshop.dto.condition.CategoryCondition;
import com.wshop.dto.condition.ProductCondition;
import com.wshop.dto.form.ProductForm;
import com.wshop.dto.model.CategoryModel;
import com.wshop.dto.model.ProductBasicModel;
import com.wshop.dto.model.ProductModel;
import com.wshop.entity.Category;
import com.wshop.entity.Product;
import com.wshop.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alan on 2017/7/22.
 */
@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailsMapper productDetailsMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional
    public Integer insertProductInfo(ProductForm form){
        Product product = form.toProduct(form);
        product.setCreatedAt(new Date());
        product.setCreatedBy("Admin");
        product.setUpdatedAt(new Date());
        product.setUpdatedBy("");
        product.setStatus(1);
        product.setMerchantId(123);
        Integer result = productMapper.insertSelective(product);
        if(result > 0){
            ProductDetails productDetails = form.toProductDetails(form, product.getId());
            result = productDetailsMapper.insertSelective(productDetails);
        }
        return result;
    }

    public PageInfo<Product> selectAll(ProductCondition condition){
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());

        Page<Product> products = productMapper.selectAll(condition);

        for(Product product : products){
            if(product.getCategoryId() != null){
                Category category = categoryMapper.selectByPrimaryKey(product.getCategoryId());
                if(category != null){
                    product.setCategoryName(category.getName());
                }
            }
            if(!StringUtils.isEmpty(product.getLabel())){
                String[] labelsArr = product.getLabel().split(",");
                List<String> labels = new ArrayList<>();
                for(String label: labelsArr){
                    labels.add(label);
                }
                product.setLabels(labels);
            }
        }
        return new PageInfo<>(products);
    }

    public ProductModel selectProductInfo(Integer id){
        Product product = productMapper.selectByPrimaryKey(id);
        ProductModel model = new ProductModel();
        model = model.toProductModel(product);

        if(!StringUtils.isEmpty(product.getPic())){
            String[] picArr = product.getPic().split(",");
            List<String> pics = new ArrayList<>();
            for(String pic : picArr){
                pics.add(pic);
            }
            model.setPics(pics);
        }

        if(!StringUtils.isEmpty(product.getLabel())){
            String[] labelsArr = product.getLabel().split(",");
            List<String> labels = new ArrayList<>();
            for(String label: labelsArr){
                labels.add(label);
            }
            model.setLabels(labels);
        }

        if(model.getCategoryId() != null){
           Category category = categoryMapper.selectByPrimaryKey(model.getCategoryId());
           if(category != null){
               model.setCategoryName(category.getName());
           }
        }
        ProductDetails productDetails = productDetailsMapper.selectByPrimaryKey(id);
        model = model.toProductDetails(model, productDetails);
        return model;
    }

    @Transactional
    public Integer updateProductInfo(ProductForm form){
        Product product = form.toProduct(form);
        product.setCreatedAt(new Date());
        product.setCreatedBy("Admin");
        product.setUpdatedAt(new Date());
        product.setUpdatedBy("");
        product.setStatus(1);
        product.setMerchantId(123);
        Integer result = productMapper.insertSelective(product);
        if(result > 0){
            ProductDetails productDetails = form.toProductDetails(form, product.getId());
            result = productDetailsMapper.insertSelective(productDetails);
        }
        if(result > 0){
            product.setIsTarget(0);  //1：当前可用，0:无用
            result = productMapper.updateByPrimaryKeySelective(product);
        }
        return result;
    }

    public Product selectByPrimaryKey(Integer id){
        return productMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Product record){
        return productMapper.updateByPrimaryKeySelective(record);
    }

    //API 调用
    public List<ProductBasicModel> selectAllByCondition(ProductCondition condition){
        List<Product> products = productMapper.selectAllByCondition(condition);
        List<ProductBasicModel> models = new ArrayList<>();

        for(Product product : products){
            if(product.getCategoryId() != null){
                Category category = categoryMapper.selectByPrimaryKey(product.getCategoryId());
                if(category != null){
                    product.setCategoryName(category.getName());
                }
            }
            if(!StringUtils.isEmpty(product.getLabel())){
                String[] labelsArr = product.getLabel().split(",");
                List<String> labels = new ArrayList<>();
                for(String label: labelsArr){
                    labels.add(label);
                }
                product.setLabels(labels);
            }

            ProductBasicModel model = new ProductBasicModel();
            model = model.toProductModel(product);
            models.add(model);
        }
        return models;
    }
}
