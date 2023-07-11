package cn.edu.guet.ahydcad.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName cart
 */
@TableName(value ="cart")
public class Cart implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 
     */
    @TableField(value = "name")
    private String name;

    /**
     * 
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 
     */
    @TableField(value = "checkbox")
    private Integer checkbox;

    /**
     * 
     */
    @TableField(value = "num")
    private Integer num;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 
     */
    public Integer getCheckbox() {
        return checkbox;
    }

    /**
     * 
     */
    public void setCheckbox(Integer checkbox) {
        this.checkbox = checkbox;
    }

    /**
     * 
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 
     */
    public void setNum(Integer num) {
        this.num = num;
    }
}