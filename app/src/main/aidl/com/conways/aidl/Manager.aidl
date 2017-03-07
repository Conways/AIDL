// Manager.aidl
package com.conways.aidl;
import com.conways.aidl.Employee;
// Declare any non-default types here with import statements

interface Manager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    void addEmployee(long id);

    int getEmployeeCount();

    Employee getEmployee();

    void delEmployeee(long id);


}
