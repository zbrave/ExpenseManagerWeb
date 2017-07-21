package com.mertaydar.emw.entity;
// Generated 19.Tem.2017 22:36:54 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TypeId generated by hbm2java
 */
@Embeddable
public class TypeId implements java.io.Serializable {

	private int id;
	private int typeId;

	public TypeId() {
	}

	public TypeId(int id, int typeId) {
       this.id = id;
       this.typeId = typeId;
    }

	@Column(name = "id", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="type_id", nullable=false)
    public int getTypeId() {
        return this.typeId;
    }

	public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

	public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TypeId) ) return false;
		 TypeId castOther = ( TypeId ) other; 
         
		 return (this.getId()==castOther.getId())
 && (this.getTypeId()==castOther.getTypeId());
   }

	public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + this.getTypeId();
         return result;
   }

}