package cn.edu.guet.ahydcad.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.guet.ahydcad.bean.Cart;
import cn.edu.guet.ahydcad.service.CartService;
import cn.edu.guet.ahydcad.mapper.CartMapper;
import org.springframework.stereotype.Service;

/**
* @author Cloud
* @description 针对表【cart】的数据库操作Service实现
* @createDate 2023-07-11 20:51:49
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
    implements CartService{

}




