package com.hospital.modulecreator;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@AssociationOverride(name="id", joinColumns=@JoinColumn(name="id"))
public class Analysis extends AbstractModule {

}
