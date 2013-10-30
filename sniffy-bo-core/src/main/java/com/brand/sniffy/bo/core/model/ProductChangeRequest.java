package com.brand.sniffy.bo.core.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class ProductChangeRequest {

    /**
     */
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     */
    private String name;

    /**
     */
    private String source;

    /**
     */
    private BigDecimal price;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date requestDate;

    /**
     */
    private String description;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Component> components = new HashSet<Component>();

    /**
     */
    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    /**
     */
    private String barcode;
}