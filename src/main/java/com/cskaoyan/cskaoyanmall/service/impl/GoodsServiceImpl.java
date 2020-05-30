package com.cskaoyan.cskaoyanmall.service.impl;

import com.cskaoyan.cskaoyanmall.bean.*;
import com.cskaoyan.cskaoyanmall.mapper.*;
import com.cskaoyan.cskaoyanmall.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.System;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class GoodsServiceImpl implements GoodsService {




    @Autowired
    SqlSession sqlSession;

    /**
     * 判断条件查询的输入框里是否为空
     */
    private boolean isEmpty(String s){
        if (s == null || "".equals(s)){
            return true;
        }
        return false;
    }

    @Autowired
    CommonRespBaseData commonRespBaseData;
    @Override
    public CommonRespBaseData<Goods> selectGoodsList(int page, int limit, String goodsSn, String name, String sort, String order) {
        PageHelper.startPage(page, limit);
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause("add_time DESC");
        if (isEmpty(goodsSn) && isEmpty(name)){
            goodsExample.createCriteria();
        }else if (!isEmpty(goodsSn) && isEmpty(name)){
            goodsExample.createCriteria().andGoodsSnLike("%"+goodsSn+"%");
        }else if (isEmpty(goodsSn) && !isEmpty(name)){
            goodsExample.createCriteria().andNameLike("%"+name+"%");
        }else if (!isEmpty(name) && !isEmpty(goodsSn)){
            goodsExample.createCriteria().andGoodsSnLike("%"+goodsSn+"%").andNameLike("%"+name+"%");;
        }
        List<Goods> goods = mapper.selectByExample(goodsExample);
        commonRespBaseData.setItems(goods);
        PageInfo<Goods> userPageInfo = new PageInfo<>(goods);
        long total = userPageInfo.getTotal();
        commonRespBaseData.setTotal(total);
        return commonRespBaseData;

    }



    @Override
    public GoodsDetails selectGoodsDetails(Integer id) {
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        //先查询出类目id
        int categoryId = goodsMapper.selectCatrgoryId(id);
        //再查出pid
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        int pid = categoryMapper.selectPidByCategoryId(categoryId);
        //放进数组
        GoodsDetails goodsDetails = new GoodsDetails();
        goodsDetails.setCategoryIds(new Integer[]{categoryId,pid});
        //查询商品信息
        Goods goods = goodsMapper.selectGoodsById(id);
        //查询属性列表
        GoodsAttributeMapper attributeMapper = sqlSession.getMapper(GoodsAttributeMapper.class);
        GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
        goodsAttributeExample.createCriteria().andGoodsIdEqualTo(id);
        List<GoodsAttribute> attributes = attributeMapper.selectByExample(goodsAttributeExample);
        //查询规格列表
        GoodsSpecificationMapper specificationMapper = sqlSession.getMapper(GoodsSpecificationMapper.class);
        GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample();
        goodsSpecificationExample.createCriteria().andGoodsIdEqualTo(id);
        List<GoodsSpecification> specifications = specificationMapper.selectByExample(goodsSpecificationExample);
        //查询产品列表
        GoodsProductMapper productMapper = sqlSession.getMapper(GoodsProductMapper.class);
        GoodsProductExample goodsProductExample = new GoodsProductExample();
        goodsProductExample.createCriteria().andGoodsIdEqualTo(id);
        List<GoodsProduct> products = productMapper.selectByExample(goodsProductExample);

        //设置参数
        goodsDetails.setGoods(goods);
        goodsDetails.setAttributes(attributes);
        goodsDetails.setProducts(products);
        goodsDetails.setSpecifications(specifications);
        return goodsDetails;
    }


    @Override
    public int deleteGoods(Goods goods) {
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andIdEqualTo(goods.getId());
        int i = mapper.deleteByExample(goodsExample);
        return i;
    }

    @Override
    public List<CategoryList> selectCategoryList() {
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        List<CategoryList> categoryList = new ArrayList<>();
        categoryList = mapper.selectCategoryList();
        return categoryList;
    }


    @Override
    public List<CategoryL1RespVo> selectBrandList() {
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<CategoryL1RespVo> brandList = mapper.selectBrandList();
        return brandList;
    }


    @Override
    public void updateGoods(GoodsDetails goodsDetails) {
        int goodsId = goodsDetails.getGoods().getId();
        //更新goods表
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        //根据传入的goods的id来更新
        int i =goodsMapper.updateByPrimaryKey(goodsDetails.getGoods());
        //更新specification
        GoodsSpecificationMapper specificationMapper = sqlSession.getMapper(GoodsSpecificationMapper.class);
        GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample();
        for (GoodsSpecification s : goodsDetails.getSpecifications()) {
            specificationMapper.updateByPrimaryKey(s);
        }
        //更新products
        GoodsProductMapper productMapper = sqlSession.getMapper(GoodsProductMapper.class);
        for (GoodsProduct p :
                goodsDetails.getProducts()) {
            productMapper.updateByPrimaryKey(p);
        }
        //更新attributes
        GoodsAttributeMapper mapper = sqlSession.getMapper(GoodsAttributeMapper.class);

        for (GoodsAttribute a:
              goodsDetails.getAttributes()) {
            mapper.updateByPrimaryKey(a);
        }
    }

    @Override
    public void insertGoods(GoodsDetails goodsDetails) {
        //插入goods
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        goodsMapper.insert(goodsDetails.getGoods());

        //插入specification
        GoodsSpecificationMapper specificationMapper = sqlSession.getMapper(GoodsSpecificationMapper.class);

        for (GoodsSpecification s :
                goodsDetails.getSpecifications()) {
            specificationMapper.insert(s);
        }
        //插入products
        GoodsProductMapper goodsProductMapper = sqlSession.getMapper(GoodsProductMapper.class);
        for (GoodsProduct product : goodsDetails.getProducts()
             ) {
            goodsProductMapper.insert(product);
        }


        //插入attribute
        GoodsAttributeMapper attributeMapper = sqlSession.getMapper(GoodsAttributeMapper.class);
        for (GoodsAttribute attribute: goodsDetails.getAttributes()) {
            attributeMapper.insert(attribute);
        }


    }
}
