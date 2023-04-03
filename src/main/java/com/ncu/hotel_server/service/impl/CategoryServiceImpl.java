package com.ncu.hotel_server.service.impl;

import com.ncu.hotel_server.entity.Category;
import com.ncu.hotel_server.mapper.CategoryMapper;
import com.ncu.hotel_server.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xph
 * @since 2023-04-03
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
