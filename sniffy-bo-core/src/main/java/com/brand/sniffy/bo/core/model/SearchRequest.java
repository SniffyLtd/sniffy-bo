package com.brand.sniffy.bo.core.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;
import com.brand.sniffy.bo.core.utils.SearchRequestStatus;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class SearchRequest {

    /**
     */
    @NotNull
    private String barcode;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date requestDate;
    
    private Long processingTime;

    /**
     */
    private String productName;

    /**
     */
    @ManyToOne
    @NotNull
    private User owner;

    /**
     */
    @ManyToOne
    @NotNull
    private Device device;

    /**
     */
    @ManyToOne
    private Product searchResult;

    /**
     */
    @Enumerated
    private SearchRequestStatus status = SearchRequestStatus.TO_RESOLVE;
}
