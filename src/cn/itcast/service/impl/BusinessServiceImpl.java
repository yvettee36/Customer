package cn.itcast.service.impl;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.impl.CustomerDaoImpl;
import cn.itcast.domain.Customer;
import cn.itcast.factory.DaoFactory;
import cn.itcast.service.BusinessService;

import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    private CustomerDao dao = DaoFactory.getInstance().createDao(CustomerDao.class);

    @Override
    public void addCustomer(Customer customer) {
        dao.add(customer);
    }

    @Override
    public void update(Customer customer) {
        dao.update(customer);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }

    @Override
    public Customer findCustomer(String id) {
        return dao.find(id);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return dao.getAll();
    }
}
