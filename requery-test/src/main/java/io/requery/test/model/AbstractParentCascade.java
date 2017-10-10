package io.requery.test.model;


import java.util.List;

import io.requery.CascadeAction;
import io.requery.Entity;
import io.requery.ForeignKey;
import io.requery.JunctionTable;
import io.requery.Key;
import io.requery.ManyToMany;
import io.requery.ManyToOne;
import io.requery.OneToMany;
import io.requery.OneToOne;
import io.requery.ReferentialAction;


/**
 * Created by mluchi on 03/08/2017.
 */

@Entity(cacheable = false)
public abstract class AbstractParentCascade {

    @Key
    long id;

    @ForeignKey(delete = ReferentialAction.SET_NULL, update = ReferentialAction.RESTRICT)
    @OneToOne(cascade = {CascadeAction.SAVE, CascadeAction.DELETE})
    ChildOneToOneCascade oneToOne;

    @ForeignKey(delete = ReferentialAction.SET_NULL, update = ReferentialAction.RESTRICT)
    @ManyToOne(cascade = {CascadeAction.SAVE, CascadeAction.DELETE})
    ChildManyToOneCascade manyToOne;

    @OneToMany(cascade = {CascadeAction.SAVE, CascadeAction.DELETE})
    List<ChildOneToManyCascade> oneToMany;

    @ManyToMany(cascade = {CascadeAction.SAVE, CascadeAction.DELETE})
    @JunctionTable
    List<ChildManyToManyCascade> manyToMany;

}
