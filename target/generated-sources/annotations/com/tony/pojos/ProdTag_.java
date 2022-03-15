package com.tony.pojos;

import com.tony.pojos.Product;
import com.tony.pojos.Tag;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-03-15T23:23:48")
@StaticMetamodel(ProdTag.class)
public class ProdTag_ { 

    public static volatile SingularAttribute<ProdTag, Product> productId;
    public static volatile SingularAttribute<ProdTag, Tag> tagId;
    public static volatile SingularAttribute<ProdTag, Integer> id;

}