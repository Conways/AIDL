package com.conways.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Conways on 2017/3/7.
 */

public class Employee implements Parcelable {

    private long id;
    private int age;
    private int sex;
    private String name;
    private String mobile;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeInt(this.age);
        dest.writeInt(this.sex);
        dest.writeString(this.name);
        dest.writeString(this.mobile);
    }

    public Employee() {
    }

    protected Employee(Parcel in) {
        this.id = in.readLong();
        this.age = in.readInt();
        this.sex = in.readInt();
        this.name = in.readString();
        this.mobile = in.readString();
    }

    public static final Parcelable.Creator<Employee> CREATOR = new Parcelable.Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel source) {
            return new Employee(source);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };
}
