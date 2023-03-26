package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This deletes a city to the list if that city exists
     * @param city
     *      This is to delete the city
     */
    public void delete(City city){
        if(cities.contains(city)==false)
        {
            throw new IllegalArgumentException();
            //when i want to delete city which doesn't exist then it will give exception
        }
        cities.remove(city);
    }

    /**
     * This returns the total number of cities
     * @return
     *      Return the total number of cities
     */
    public int Count(){
        return cities.size();
    }

    /**
     * This returns a sorted list of
     * @return
     *      Return the sorted list either by cityname or by province name
     */
    public List<City> getCities(boolean f){
        List<City>cityList=cities;
        Comparator<City>comByCity=(City c1,City c2)->c1.getCityName().compareTo(c2.getCityName());
        Comparator<City>comByProvince=(City c1, City c2)->c1.getProvinceName().compareTo(c2.getProvinceName());
        if(f==true)
            Collections.sort(cityList, comByCity);
        else
            Collections.sort(cityList, comByProvince);
        return cityList;

    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> cityList = cities;
        Collections.sort(cityList);
        return cityList;
    }
}
