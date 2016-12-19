package com.zor07.domain;

import javax.persistence.*;

@Entity
public class AppiumSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String applicationPath;

    private String applicationPackage;
    private String applicationActivity;
    private String androidVersion;
    private String deviceName;

    private String one;
    private String two;
    private String three;
    private String four;
    private String five;
    private String six;
    private String seven;
    private String eight;
    private String nine;
    private String zero;

    private String equals;
    private String subtract;

    @Column(name = "plus") //if keep add name, sql error will occur
    private String add;
    private String divide;
    private String multiply;

    private String brackets;
    private String point;

    private String result;


    public AppiumSettings() {
    }


    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getBrackets() {
        return brackets;
    }

    public void setBrackets(String brackets) {
        this.brackets = brackets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getApplicationPath() {
        return applicationPath;
    }

    public void setApplicationPath(String applicationPath) {
        this.applicationPath = applicationPath;
    }

    public String getApplicationPackage() {
        return applicationPackage;
    }

    public void setApplicationPackage(String applicationPackage) {
        this.applicationPackage = applicationPackage;
    }

    public String getApplicationActivity() {
        return applicationActivity;
    }

    public void setApplicationActivity(String applicationActivity) {
        this.applicationActivity = applicationActivity;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getFive() {
        return five;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public String getSeven() {
        return seven;
    }

    public void setSeven(String seven) {
        this.seven = seven;
    }

    public String getEight() {
        return eight;
    }

    public void setEight(String eight) {
        this.eight = eight;
    }

    public String getNine() {
        return nine;
    }

    public void setNine(String nine) {
        this.nine = nine;
    }

    public String getZero() {
        return zero;
    }

    public void setZero(String zero) {
        this.zero = zero;
    }

    public String getEquals() {
        return equals;
    }

    public void setEquals(String equals) {
        this.equals = equals;
    }

    public String getSubtract() {
        return subtract;
    }

    public void setSubtract(String subtract) {
        this.subtract = subtract;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getDivide() {
        return divide;
    }

    public void setDivide(String divide) {
        this.divide = divide;
    }

    public String getMultiply() {
        return multiply;
    }

    public void setMultiply(String multiply) {
        this.multiply = multiply;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
