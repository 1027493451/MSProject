package com.imooc2.product.controller;

import com.imooc2.product.VO.ProductInfoVO;
import com.imooc2.product.VO.ProductVO;
import com.imooc2.product.VO.ResultVO;
import com.imooc2.product.common.DecreaseStockInput;
import com.imooc2.product.dataobject.ProductCategory;
import com.imooc2.product.dataobject.ProductInfo;
import com.imooc2.product.repository.ProductInfoRepository;
import com.imooc2.product.service.CategoryService;
import com.imooc2.product.service.ProductService;
import com.imooc2.product.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Api2Doc(id = "product", name = "产品接口")
//@ApiComment(seeClass = ProductInfo.class)
@Api(value = "商品接口", tags = "商品管理" )
@RequestMapping("/product")
@RestController
public class ProductInfoController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductInfoRepository productInfoRepository;

    //@ApiComment(value = "获取所有产品")
    @ApiOperation(value = "获取所有产品",httpMethod = "Get")
    @GetMapping("/getAll")
    public List<ProductInfo> getUser() {
        List<ProductInfo> list = productInfoRepository.findAll();
        return list;
    }

    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */
    //@CrossOrigin(allowCredentials = "true")
    @GetMapping("/list")
    @ApiOperation(value = "查询所有在架的商品",httpMethod = "Get")
    public ResultVO<ProductVO> list() {
        //1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3. 从数据库查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //4. 构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }


    /**
    * @description: 获取商品列表(给订单服务用的)
    * @author: snail
    * @create: 10:53 2020/6/1
    * @Version: 1.0
    * @param productIdList
    * @return: java.util.List<com.imooc2.product.dataobject.ProductInfo>
    **/
    @ApiOperation(value = "获取商品列表", notes = "根据商品列表id获取商品列表详细信息",httpMethod = "Post")
    @ApiImplicitParam(paramType = "path", dataType = "List<String>", name = "productIdList", value = "商品列表id", required = true, example = "{1，2}")
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findList(productIdList);
    }

    /**
     * @param decreaseStockInputList
     * @description: 扣库存
     * @author: snail
     * @create: 11:35 2020/4/28
     * @Version: 1.0
     * @return: void
     **/
    @ApiOperation(value = "扣库存",httpMethod = "Post")
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        productService.decreaseStock(decreaseStockInputList);
    }


}
