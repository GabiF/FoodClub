package com.user.service.food.club.Service;

import com.user.service.food.club.Entity.Restaurant;
import com.user.service.food.club.Repository.RestaurantRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService implements RestaurantRepository {
    @Override
    public Restaurant findById(long id) {
        return null;
    }

    @Override
    public List<Restaurant> findAll() {
        return null;
    }

    @Override
    public List<Restaurant> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Restaurant> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Restaurant> findAll(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Restaurant entity) {

    }

    @Override
    public void delete(Iterable<? extends Restaurant> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Restaurant> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Restaurant> List<S> save(Iterable<S> entities) {
        return null;
    }

    @Override
    public Restaurant findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Restaurant> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Restaurant> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Restaurant getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Restaurant> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Restaurant> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Restaurant> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Restaurant> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Restaurant> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Restaurant> boolean exists(Example<S> example) {
        return false;
    }
}
