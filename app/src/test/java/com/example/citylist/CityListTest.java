package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testDelete(){
        CityList cityList = new CityList();
        City city = new City("Khulna", "Khalishpur");
        City city1 = new City("Dhaka", "Mirpur");
        cityList.add(city);
        cityList.add(city1);
        cityList.delete(city);
        assertTrue(!cityList.getCities().contains(city));
        //this method is used to check whether city is deleted or not
        //if the city is deleted then the test will be passed
    }

    @Test
    public void testDeleteException(){
        CityList cityList=new CityList();
//        City c3 = new City("abc", "xyz");
        City c1 = new City("Khulna", "Khalishpur");
        City c2 = new City("Dhaka", "Mirpur");
        cityList.add(c1);
        cityList.add(c2);
        cityList.delete(c1);
//        cityList.delete(c3);
        assertThrows(IllegalArgumentException.class, ()->
        {
            cityList.delete(c1);
        });
//  this function is used to check if it gives an exception to delete a city when the city doesn't exist
    }

    @Test
    public void testCount(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.Count());
        City c1=new City("ABCD","abcd");
        cityList.add(c1);
        assertEquals(2, cityList.Count());
        cityList.delete(c1);
        assertEquals(1, cityList.Count());
//this method is used to check if it is giving the total number of cities right or wrong
    }

    @Test
    public void testSort() {
            CityList cityList = new CityList();

            City c1=new City("Khulna", "Jashore");
            City c2 = new City("Dhaka", "Savar");

            cityList.add(c2);
            assertEquals(0, c2.compareTo(cityList.getCities(true).get(0)));//sorted by city name
            assertEquals(0, c2.compareTo(cityList.getCities(false).get(0)));//sorted by province name

            cityList.add(c1);

            assertEquals(0, c1.compareTo(cityList.getCities(true).get(1)));
            //here c1 is Khulna, true means it will sort by cityname, .get(1) will give the second city from the sorted city list which is Khulna
        //so it matches and test will be ok
            assertEquals(0, c2.compareTo(cityList.getCities(true).get(0)));

            assertEquals(0, c1.compareTo(cityList.getCities(false).get(0)));
            assertEquals(0, c2.compareTo(cityList.getCities(false).get(1)));
        //here c2 is Dhaka, false means it will sort by province name, .get(1) will give the second city from the sorted city list which is Dhaka
        //therefore test will be passed
        }
    }

