package com.ruoyi.system.domain.zs.other;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @desc:
 * @auther: lxj
 * @date: 2021/2/24 17:02
 */
public abstract class GenericModel<K extends Serializable> implements Serializable {

    @JsonIgnore
    private final Class<K> _genericClass;

    @SuppressWarnings("unchecked")
    protected GenericModel() {
        if (!GenericModel.class.isAssignableFrom(getClass())) {
            throw new IllegalArgumentException(
                    "The class " + getClass() + " must be inherit from GenericModel");
        }
        Type parentType = getClass().getGenericSuperclass();
        while (true) {
            if (parentType instanceof ParameterizedType) {
                this._genericClass = (Class<K>) ((ParameterizedType) parentType)
                        .getActualTypeArguments()[0];
                break;
            }
            parentType = ((Class) parentType).getGenericSuperclass();
        }
    }

    public abstract K getId();

    public abstract void setId(K id);

    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        K id = getId();
        if (id == null) {
            return false;
        }
        GenericModel<K> model = (GenericModel<K>) obj;
        return id.equals(model.getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        K id = getId();
        return 31 * hash + (id == null ? 0 : id.hashCode());
    }

    @JsonIgnore
    public Class<K> getGenericClass() {
        return _genericClass;
    }
}
