package com.infirmarium.core.services;

import com.infirmarium.core.persistance.core.IBaseService;
import com.infirmarium.core.persistance.dao.CardDAO;
import com.infirmarium.core.persistance.domain.Card;

public interface ICardService extends IBaseService<Card, CardDAO> {

}
