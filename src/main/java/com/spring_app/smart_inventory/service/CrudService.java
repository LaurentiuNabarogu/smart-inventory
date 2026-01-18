package com.spring_app.smart_inventory.service;

import java.util.List;

public interface CrudService<D, ID> {
    D create(D dto);
    D getById(ID id);
    D update(ID id, D dto);
    void delete(ID id);
    List<D> getAll();
}
