package com.codegym.service;

import java.util.List;

public interface GeneralService<E> {
    List<E> findAllHaveBusiness();
    void addHaveBusiness(E e);
}
