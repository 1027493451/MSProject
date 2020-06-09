package com.imooc2.product.product.controller;


import com.imooc2.product.VO.ProductInfoVO;
import com.imooc2.product.VO.ProductVO;
import com.imooc2.product.VO.ResultVO;
import com.imooc2.product.category.entity.ProductCategory;
import com.imooc2.product.category.service.IProductCategoryService;
import com.imooc2.product.common.DecreaseStockInput;
import com.imooc2.product.product.entity.ProductInfo;
import com.imooc2.product.product.service.IProductInfoService;
import com.imooc2.product.utils.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Snail
 * @since 2020-06-08
 */
@Api(value = "商品接口", tags = "商品管理" )
@RestController
@RequestMapping("/product")
public class ProductInfoController {

    @Resource
    private IProductCategoryService productCategoryService;

    @Autowired
    private IProductInfoService productService;

    @ApiOperation(value = "获取所有产品",httpMethod = "GET")
    @GetMapping("/getAll")
    public List<ProductInfo> getUser() {
        List<ProductInfo> list =  productService.list();
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
    @ApiOperation(value = "查询所有在架的商品",httpMethod = "GET")
    public ResultVO<ProductVO> list() {
        //1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productService.list();

        //2. 获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3. 从数据库查询类目
        List<ProductCategory> categoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

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

    //@ApiImplicitParam(paramType = "body", dataType = "List<String>", name = "productIdList", value = "商品列表id", required = true, example = ("['1','2']"))
    @ApiOperation(value = "获取商品列表", notes = "根据商品列表id获取商品列表详细信息",httpMethod = "POST")
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
    //@ApiImplicitParam(paramType = "body", dataType = "List<DecreaseStockInput>", name = "decreaseStockInputList",value = "商品扣除输入类", required = true)
    @ApiOperation(value = "扣库存",httpMethod = "POST")
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        productService.decreaseStock(decreaseStockInputList);
    }
}
