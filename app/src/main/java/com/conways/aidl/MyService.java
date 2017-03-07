package com.conways.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

public class MyService extends Service {

    private List<Employee> list;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return manager;
    }

    private Manager.Stub manager = new Manager.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void addEmployee(long id) throws RemoteException {
            Employee employee = new Employee();
            employee.setId(id);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(employee);
        }

        @Override
        public int getEmployeeCount() throws RemoteException {
            return list.size();
        }

        @Override
        public Employee getEmployee() throws RemoteException {
            if (list.size()>0){
                return list.get(0);
            }
            return null;
        }

        @Override
        public void delEmployeee(long id) throws RemoteException {

        }
    };


//    private Manager.Stub manager = new Manager.Stub() {
//        @Override
//        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
//
//        }
//
//        @Override
//        public int getEmployeeCount() throws RemoteException {
//            return list.size();
//        }
//
//        @Override
//        public void addEmployee(long id) throws RemoteException {
//            Employee employee = new Employee();
//            employee.setId(id);
//            if (list == null) {
//                list = new ArrayList<>();
//            }
//            list.add(employee);
//            System.out.println("zzzzzz===="+list.size());
//        }
//
//        @Override
//        public void delEmployeee(long id) throws RemoteException {
//
//        }
//    };


}
