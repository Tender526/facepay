package com.abc.facepay.controller.test;

import com.abc.facepay.pojo.Country;
import com.abc.facepay.pojo.Depart;
import com.abc.facepay.pojo.School;
import com.abc.facepay.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("test")
public class TestController {

    @Value("${server.port}")
    private int port ;

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "HELLO SPRING DEVTOOLS test";
    }

    @RequestMapping("/getPort")
    public String getPort(){

        return "端口是:"+port;
    }


    @Autowired
    private Student student;

    @Autowired
    private Country country;

    @Autowired
    private School school;



    @GetMapping("/getStudent")
    public Object getStudent(){
        return student;
    }

    public static void main(String[] args) {


    }


    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            if (map.containsKey(nums[left])){
                res[0] = left;
                res[1] = map.get(nums[left]);
                if (left > map.get(nums[left])){
                    res[0] = map.get(nums[left]);
                    res[1] = left;
                }
                // 3 2 4    3 4 2
                return res;

            }else {
                map.put(target-nums[left],left); // 3 0, 4 1 ,
            }

            if (map.containsKey(nums[right])){
                res[0] = right;
                res[1] = map.get(nums[right]);
                if (left > map.get(nums[right])){
                    res[0] = map.get(nums[right]);
                    res[1] = right;
                }
                // 3 2 4    3 4 2
                return res;

            }else {
                map.put(target-nums[right],right); // 3 0, 4 1 ,
            }

            left ++;
            right --;
        }


        return res;
    }

    @GetMapping("/getCountry")
    public Object getCountry(){
        String[] cities = country.getCities();
        Arrays.asList(cities).forEach(city -> System.out.println(city));
        return cities;
    }

    @GetMapping("/getSchool")
    public Object getSchool(){
        Depart[] departs = school.getDeparts();
        Arrays.asList(departs).forEach(depart ->
                System.out.println(depart.getName()+"-"
                        +depart.getAddress()+"-"+depart.getTel())
        );
        return departs;
    }
}
