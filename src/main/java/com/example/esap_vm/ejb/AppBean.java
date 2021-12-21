package com.example.esap_vm.ejb;


import com.example.esap_vm.dao.*;
import com.example.esap_vm.model.*;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class AppBean {
    public int i;
    private int j;
    protected int k;
    int m; // default

    private final UsersDao usersDao = new UsersDao();
    private final DrivesDao drivesDao = new DrivesDao();
    private final BikesDao bikesDao = new BikesDao();

    // === create
    public void createDrive(Drive drive, Long userId, Long bikeId) {
        User user = usersDao.get(userId);
        Bike bike = bikesDao.get(bikeId);
        if (user == null || bike == null)
            return;
        drive.setCost(bike.getPrice() * drive.getHours());
        drive.setBike(bike);
        drive.setUser(user);
        drivesDao.create(drive);
    }

    public void createUser(User user) {
        usersDao.create(user);
    }

    public void createBike(Bike bike) {
        bikesDao.create(bike);
    }

    // ======= drive ===
    public List<Drive> getAllDrives() {
        return drivesDao.getAll();
    }

    public Drive getDriveById(Long id) {
        return drivesDao.get(id);
    }
    // ======= user ===

    public List<User> getAllUsers() {
        return usersDao.getAll();
    }

    public User getUserById(Long id) {
        return usersDao.get(id);
    }

    // ======= bike ===
    public List<Bike> getAllBikes() {
        return bikesDao.getAll();
    }

    public Bike getBikeById(Long id) {
        return bikesDao.get(id);
    }

    public void updateUser(Long userId, User user) {
        usersDao.update(userId, user);
    }

    public void updateDrive(Long driveId, Drive drive, Long userId, Long bikeId) {
        User user = usersDao.get(userId);
        Bike bike = bikesDao.get(bikeId);
        if (user == null || bike == null)
            return;
        drive.setCost(bike.getPrice() * drive.getHours());
        drive.setBike(bike);
        drive.setUser(user);
        drivesDao.update(driveId, drive);
    }

    public void updateBike(Long bikeId, Bike bike) {
        bikesDao.update(bikeId, bike);
    }

    public void deleteUser(Long userId){ usersDao.delete(userId);}


    public void deleteBike(Long bikeId){ bikesDao.delete(bikeId);}

    public void deleteDrive(Long driveId){ drivesDao.delete(driveId);}

}
